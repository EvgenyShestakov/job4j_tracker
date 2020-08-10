package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean flag = false;
        if (tracker.delete((input.askInt("Enter Id: ")))) {
            System.out.println("Request successfully deleted");
            flag = true;
        } else {
            System.out.println("Mistake. Request not found");
        }
        return flag;
    }
}

