package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
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
                getOut().println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }

    public Output getOut() {
        return super.getOut();
    }
}
