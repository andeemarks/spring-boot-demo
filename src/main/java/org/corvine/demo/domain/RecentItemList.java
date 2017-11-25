package org.corvine.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class RecentItemList {
    private List<Item> items = new ArrayList<>();

    public RecentItemList add(Item item) {
        items.add(item);
        items.sort((item1, t1) -> t1.getId().compareTo(item1.getId()));
        return this;
    }

    Item get(int index) {
        return items.get(index);
    }

    public List<Item> getItems() {
        return items;
    }
}
