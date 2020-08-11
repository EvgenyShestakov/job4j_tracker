package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "ShowAll";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ===");
        boolean flag = false;
        Item[] itemAll = tracker.findAll();
        if (itemAll.length > 0) {
            for (Item elem : itemAll) {
               out.println(elem);
            }
         flag = true;
        } else {
            out.println("No requests found");

        }
        return flag;
    }
}
