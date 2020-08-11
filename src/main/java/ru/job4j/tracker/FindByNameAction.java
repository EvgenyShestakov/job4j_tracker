package ru.job4j.tracker;

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
        Item[] itemName = tracker.findByName(input.askStr("Enter name: "));
        if (itemName.length > 0) {
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
