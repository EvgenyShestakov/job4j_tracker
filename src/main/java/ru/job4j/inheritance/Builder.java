package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String name;
    private String surname;
    private String education;
    private  int birthday;
    private Construction construction;

    public Builder() {

    }

    public Builder(String name, String surname, String education, int birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public Construction build(TechTask techTask) {
        return new Construction();
    }

    public Construction getConstruction() {
        return construction;
    }
}
