package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "FindByName";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ===");
        boolean flag = false;
        List<Item> itemName = tracker.findByName(input.askStr("Enter name: "));
        if (itemName.size() > 0) {
            for (Item elem : itemName) {
                out.println(elem);
            }
            flag = true;
        } else {
            out.println("No request found by name");
        }
        return flag;
    }
}
