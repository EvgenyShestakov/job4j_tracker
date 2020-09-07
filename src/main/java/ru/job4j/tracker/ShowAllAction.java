package ru.job4j.tracker;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "ShowAll";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ===");
        boolean flag = false;
        if (tracker.findAll().size() > 0) {
            for (Item elem : tracker.findAll()) {
               out.println(elem);
            }
         flag = true;
        } else {
            out.println("No requests found");

        }
        return flag;
    }
}
