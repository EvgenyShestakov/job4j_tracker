package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                tracker.add(new Item(input.askStr("Enter name: ")));
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] itemAll = tracker.findAll();
                if (itemAll.length > 0) {
                    for (Item elem : itemAll) {
                        System.out.println(elem);
                    }
                } else {
                    System.out.println("No requests found");
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                int idTmp = Integer.valueOf(input.askStr("Enter replacement Id: "));
                if (tracker.replace(idTmp, new Item(input.askStr("Enter a new name: ")))) {
                    System.out.println("Request rewritten");
                } else {
                    System.out.println("Error, request to overwrite not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                if (tracker.delete(Integer.valueOf(input.askStr("Enter Id: ")))) {
                    System.out.println("Request successfully deleted");
                } else {
                    System.out.println("Mistake. Request not found");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                Item itemId = tracker.findById(Integer.valueOf(input.askStr("Enter Id: ")));
                if (itemId != null) {
                    System.out.println(itemId);
                } else {
                    System.out.println("No requests by Id found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                Item[] itemName = tracker.findByName(input.askStr("Enter name: "));
                if (itemName.length > 0) {
                    for (Item elem : itemName) {
                        System.out.println(elem);
                    }
                } else {
                    System.out.println("No request found by name");
                }
            } else if (select == 6) {
                run = false;
            }

        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }
    }
