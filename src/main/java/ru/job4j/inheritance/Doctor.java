package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String name;
    private String surname;
    private String education;
    private int birthday;
    private Diagnosis diagnosis;

    public Doctor() {

    }

    public Doctor(String name, String surname, String education, int birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    Diagnosis heal(Patient patient) {
      return new Diagnosis();
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }
}
