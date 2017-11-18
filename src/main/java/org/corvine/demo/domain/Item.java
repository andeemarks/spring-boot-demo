package org.corvine.demo.domain;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class Item {
    private String id;
    private String title;
    private String link;
    private String category;
    private String blurb;
    private String price;
    private String url;

    private Item() {
    }

    public Item(String title, String description, String link) {
        this.link = link;
        parseDescriptionComponents(description);
        parseTitleComponents(title);
    }

    private void parseTitleComponents(String title) {
        Pattern titleRE = Pattern.compile("(MSS\\s[\\d]*)\\s\\|\\s(.*)");
        Matcher m = titleRE.matcher(title);
        if (!m.matches()) {
            throw new IllegalArgumentException("Title: [" + title + "] cannot be parsed");
        }
        this.title = m.group(2);
        this.id = m.group(1);
    }

    private void parseDescriptionComponents(String description) {
        Pattern descriptionRE = Pattern.compile("\\s*<p>Filed under: (.*)<\\/p><p>(.*)<br \\/>Price: (.*)<a href=\"(.*)\"><br \\/>Read more ...<\\/a><\\/p>\\s*");
        Matcher m = descriptionRE.matcher(description);
        this.category = extractCategory(description);
        this.blurb = extractBlurb(description);
        this.price = extractPrice(description);
        this.url = extractUrl(description);
    }

    private String extractField(String description, String fieldSpec, String fieldTitle) {
        Pattern pattern = Pattern.compile(fieldSpec, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(description);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(fieldTitle + " in [" + description + "] cannot be parsed");
        }
        return matcher.group(1);
    }

    private String extractBlurb(String description) {
        return extractField(description, "\\s*<p>Filed under: .*<\\/p><p>(.*)<br \\/>Price.*", "Blurb");
    }

    private String extractUrl(String description) {
        return extractField(description, ".*<a href=\"(.*)\">.*", "Uri");
    }

    private String extractPrice(String description) {
        return extractField(description, ".*<br \\/>Price: (.*)<a href=\".*", "Price");
    }

    private String extractCategory(String description) {
        return extractField(description, "\\s*<p>Filed under: (\\p{Print}*)<\\/p><p>.*", "Category");
    }

    String getCategory() {
        return category;
    }

    String getBlurb() {
        return blurb;
    }

    String getPrice() {
        return price;
    }

    String getUrl() {
        return url;
    }

    String getId() {
        return id;
    }

    String getTitle() {
        return title;
    }
}
