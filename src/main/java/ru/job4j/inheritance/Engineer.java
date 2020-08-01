package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String name;
    private String surname;
    private String education;
    private  int birthday;
    private Project project;

    public Engineer() {

    }

    public Engineer(String name, String surname, String education, int birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public Project createProject(TechTask techTask) {
        return new Project();
    }

    public Project getProject() {
        return project;
    }
}
