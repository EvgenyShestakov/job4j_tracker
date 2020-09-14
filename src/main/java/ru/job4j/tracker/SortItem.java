package ru.job4j.tracker;

import java.util.Comparator;

public class SortItem implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        int result;
        if (first.getId() > second.getId()) {
            result = 1;
        } else  if (first.getId() < second.getId()) {
            result = -1;
        } else {
            result = 0;
        }
        return  result;
    }
}
