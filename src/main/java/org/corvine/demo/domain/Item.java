package org.corvine.demo.domain;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class Item {
    private String title;
    private String description;
    private String link;
    private String category;
    private String blurb;
    private String price;
    private String url;

    private Item() {
    }

    public Item(String title, String description, String link) {

        this.title = title;
        this.description = description;
        this.link = link;

        Pattern p = Pattern.compile("<p>Filed under: (.*)</p><p>(.*)<br />Price: (.*)<a href=\"(.*)\"><br />Read more ...</a></p>");
        Matcher m = p.matcher(description);
        this.category = m.group(1);
        this.blurb = m.group(2);
        this.price = m.group(3);
        this.url = m.group(4);

    }

    public String getCategory() { return category; }
    public String getBlurb() { return blurb; }
    public String getPrice() { return price; }
    public String getUrl() { return url; }
}
