package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter name: ");
                tracker.add(new Item(scanner.nextLine()));
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
                System.out.print("Enter replacement Id: ");
                int idTmp = Integer.valueOf(scanner.nextLine());
                System.out.print("Enter a new name: ");
                if (tracker.replace(idTmp, new Item(scanner.nextLine()))) {
                    System.out.println("Request rewritten");
                } else {
                    System.out.println("Error, request to overwrite not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.print("Enter Id: ");
                if (tracker.delete(Integer.valueOf(scanner.nextLine()))) {
                    System.out.println("Request successfully deleted");
                } else {
                    System.out.println("Mistake. Request not found");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                System.out.print("Enter Id: ");
                Item itemId = tracker.findById(Integer.valueOf(scanner.nextLine()));
                if (itemId != null) {
                    System.out.println(itemId);
                } else {
                    System.out.println("No requests by Id found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                System.out.print("Enter name: ");
                Item[] itemName = tracker.findByName(scanner.nextLine());
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
