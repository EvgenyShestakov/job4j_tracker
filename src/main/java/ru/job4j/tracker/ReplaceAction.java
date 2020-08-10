package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Replace item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean flag = false;
        int idTmp = input.askInt("Enter replacement Id: ");
        if (tracker.replace(idTmp, new Item(input.askStr("Enter a new name: ")))) {
            System.out.println("Request rewritten");
            flag = true;
        } else {
            System.out.println("Error, request to overwrite not found");
        }
        return flag;
    }
}
