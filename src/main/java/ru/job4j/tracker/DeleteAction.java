package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ===");
        boolean flag = false;
        if (tracker.delete((input.askInt("Enter Id: ")))) {
            out.println("Request successfully deleted");
            flag = true;
        } else {
            out.println("Mistake. Request not found");
        }
        return flag;
    }
}

