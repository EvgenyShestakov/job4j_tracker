package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new ShowAllAction(), new ReplaceAction(),
        new DeleteAction(), new FindByIdAction(), new FindByNameAction(), new Exit()};
        new StartUI().init(input, tracker, actions);
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] itemAll = tracker.findAll();
        if (itemAll.length > 0) {
            for (Item elem : itemAll) {
                System.out.println(elem);
            }
        } else {
            System.out.println("No requests found");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int idTmp = Integer.valueOf(input.askStr("Enter replacement Id: "));
        if (tracker.replace(idTmp, new Item(input.askStr("Enter a new name: ")))) {
            System.out.println("Request rewritten");
        } else {
            System.out.println("Error, request to overwrite not found");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        if (tracker.delete(Integer.valueOf(input.askStr("Enter Id: ")))) {
            System.out.println("Request successfully deleted");
        } else {
            System.out.println("Mistake. Request not found");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        Item itemId = tracker.findById(Integer.valueOf(input.askStr("Enter Id: ")));
        if (itemId != null) {
            System.out.println(itemId);
        } else {
            System.out.println("No requests by Id found");
        }
    }

    public static void findItemsByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        Item[] itemName = tracker.findByName(input.askStr("Enter name: "));
        if (itemName.length > 0) {
            for (Item elem : itemName) {
                System.out.println(elem);
            }
        } else {
            System.out.println("No request found by name");
        }
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
