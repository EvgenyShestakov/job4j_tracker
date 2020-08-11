package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Replace item ===");
        boolean flag = false;
        int idTmp = input.askInt("Enter replacement Id: ");
        if (tracker.replace(idTmp, new Item(input.askStr("Enter a new name: ")))) {
            out.println("Request rewritten");
            flag = true;
        } else {
            out.println("Error, request to overwrite not found");
        }
        return flag;
    }
}
