package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, this.size);
    }

    public Item[] findByName(String key) {
        Item[] namesWithoutNull = new Item[this.size];
        int count = 0;
        for (int index = 0; index < this.size; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                namesWithoutNull[count++] = item;
            }
        }
        return Arrays.copyOf(namesWithoutNull, count);
    }

    public boolean replace(int id, Item replacement) {
        boolean flag = false;
        int index = indexOf(id);
        if (index != -1) {
            items[index] = replacement;
            items[index].setId(id);
            flag = true;
        }
        return flag;
        }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}
