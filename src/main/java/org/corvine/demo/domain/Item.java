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
            throw new IllegalArgumentException("Title: " + title + " cannot be parsed");
        }
        this.title = m.group(2);
        this.id = m.group(1);
    }

    private void parseDescriptionComponents(String description) {
        Pattern descriptionRE = Pattern.compile("<p>Filed under: (.*)<\\/p><p>(.*)<br \\/>Price: (.*)<a href=\"(.*)\"><br \\/>Read more ...<\\/a><\\/p>");
        Matcher m = descriptionRE.matcher(description);
        if (!m.matches()) {
            throw new IllegalArgumentException("Description: " + description + " cannot be parsed");
        }
        this.category = m.group(1);
        this.blurb = m.group(2);
        this.price = m.group(3);
        this.url = m.group(4);
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
