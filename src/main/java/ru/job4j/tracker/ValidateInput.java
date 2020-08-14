package ru.job4j.tracker;

public class ValidateInput extends  ConsoleInput {
    private final Output out = null;

    public ValidateInput(Output out) {
     super(out);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
