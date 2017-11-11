package org.corvine.demo.domain;

import lombok.Data;

@Data
public class Item {
    private String title;
    private String description;
    private String link;

    private Item() {
    }

    public Item(String title, String description, String link) {

        this.title = title;
        this.description = description;
        this.link = link;
    }
}
