package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "New item name", "1"});
        UserAction[] actions = {
                new ReplaceAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {
                new DeleteAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new Exit(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), Matchers.is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindAll() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item"));
        Input in = new StubInput(new String[]{"0", "1"});
        UserAction[] actions = {new ShowAllAction(output), new Exit(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), Matchers.is(
                "Menu." + System.lineSeparator() +
                        "0. ShowAll" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Show all items ===" + System.lineSeparator() +
                        "Item{id=1, name='Item'}" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. ShowAll" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(new String[]{"0", "Item", "1"});
        tracker.add(new Item("Item"));
        UserAction[] actions = {new FindByNameAction(output), new Exit(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), Matchers.is(
                "Menu." + System.lineSeparator() +
                        "0. FindByName" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Find items by name ===" + System.lineSeparator() +
                        "Item{id=1, name='Item'}" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. FindByName" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindById() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item"));
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new FindByIdAction(output), new Exit(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), Matchers.is(
                "Menu." + System.lineSeparator() +
                        "0. FindById" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "=== Find item by Id ===" + System.lineSeparator() +
                        "Item{id=1, name='Item'}" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. FindById" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()));

    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"8", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), Matchers.is(
                String.format(
                        "Menu.%n" +
                                "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
/*
    @Test
    public void whenCheckOutput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"one", "1"});
        ValidateInput input = new ValidateInput(out, in);
        input.askInt("Enter menu:");
        assertThat(input.getOut().toString(),
                is("Please enter validate data again." + System.lineSeparator()));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"one","1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }
    */
}

