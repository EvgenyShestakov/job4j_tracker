package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findByName(String key) {
        List<Item> names = new ArrayList<>();
        for (int index = 0; index < this.items.size(); index++) {
            Item item = items.get(index);
            if (item.getName().equals(key)) {
               names.add(item);
            }
        }
        return names;
    }

    public boolean replace(int id, Item replacement) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            replacement.setId(id);
            items.set(index, replacement);
        }
        return rsl;
        }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return  rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}
