package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String name;
    private String surname;
    private String education;
    private  int birthday;
    private Prosthetics prosthetics;

    public Dentist() {

    }

    public Dentist(String name, String surname, String education, int birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public Prosthetics placeTheCrown(Patient patient) {
        return new Prosthetics();
    }

    public Prosthetics getProsthetics() {
        return prosthetics;
    }
}
