package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(item.getCreated().format(formatter));
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput(output));
        Tracker tracker = TrackerSingleEnum.INSTANCE.getTracker();
        UserAction[] actions = {new CreateAction(output), new ShowAllAction(output),
                new ReplaceAction(output), new DeleteAction(output),
                new FindByIdAction(output), new FindByNameAction(output), new Exit(output)};
        new StartUI(output).init(input, tracker, actions);
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }
}
