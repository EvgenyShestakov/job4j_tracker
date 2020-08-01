package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String name;
    private String surname;
    private String education;
    private  int birthday;
    private Program program;

    public Programmer() {

    }

    public Programmer(String name, String surname, String education, int birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public Program writeProgram(TechTask techTask) {
        return  new Program();
    }

    public Program getProgram() {
        return program;
    }
}
