package org.corvine.demo.domain;

public class Item {
    private String title;

    public Item(String title) {

        this.title = title;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                '}';
    }
}
