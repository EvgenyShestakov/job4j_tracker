package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out; }

    @Override
    public String name() {
        return "FindById";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by Id ===");
        boolean flag = false;
        Item itemId = tracker.findById((input.askInt("Enter Id: ")));
        if (itemId != null) {
            out.println(itemId);
            flag = true;
        } else {
            out.println("No requests by Id found");
        }
        return flag;
    }
}
