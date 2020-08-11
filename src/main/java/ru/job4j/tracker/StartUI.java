package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput(output);
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(output), new ShowAllAction(output),
                new ReplaceAction(output), new DeleteAction(output),
                new FindByIdAction(output), new FindByNameAction(output),
                new Exit(output)};
        new StartUI(output).init(input, tracker, actions);
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }
    }
