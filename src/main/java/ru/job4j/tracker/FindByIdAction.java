package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean flag = false;
        Item itemId = tracker.findById((input.askInt("Enter Id: ")));
        if (itemId != null) {
            System.out.println(itemId);
            flag = true;
        } else {
            System.out.println("No requests by Id found");
        }
        return flag;
    }
}
