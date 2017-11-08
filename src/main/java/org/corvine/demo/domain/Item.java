package org.corvine.demo.domain;

public class Item {
    private String title;
    private String description;
    private String link;

    public Item(String title, String description, String link) {

        this.title = title;
        this.description = description;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
