package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String name;
    private String surname;
    private String education;
    private  int birthday;
    private Operation operation;

    public Surgeon() {

    }

    public Surgeon(String name, String surname, String education, int birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public Operation operate(Patient patient) {
        return  new Operation();
    }

    public Operation getOperation() {
        return operation;
    }
}
