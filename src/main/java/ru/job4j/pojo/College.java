package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Евгений");
        student.setPatronymic("Николаевич");
        student.setLastName("Шестаков");
        student.setAdmission(new Date());
        System.out.println("Студент - " + student.getLastName() + " " + student.getFirstName() + " "
                + student.getPatronymic() + ", поступил " + student.getAdmission());
    }
}
