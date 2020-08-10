package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean flag = false;
        Item[] itemAll = tracker.findAll();
        if (itemAll.length > 0) {
            for (Item elem : itemAll) {
                System.out.println(elem);
            }
         flag = true;
        } else {
            System.out.println("No requests found");

        }
        return flag;
    }
}
