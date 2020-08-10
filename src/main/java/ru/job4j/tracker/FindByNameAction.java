package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean flag = false;
        Item[] itemName = tracker.findByName(input.askStr("Enter name: "));
        if (itemName.length > 0) {
            for (Item elem : itemName) {
                System.out.println(elem);
            }
            flag = true;
        } else {
            System.out.println("No request found by name");
        }
        return flag;
    }
}
