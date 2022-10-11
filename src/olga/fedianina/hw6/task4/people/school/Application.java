package olga.fedianina.hw6.task4.people.school;

import olga.fedianina.hw6.task4.people.Student;
import olga.fedianina.hw6.task4.people.Teacher;
import olga.fedianina.hw6.task4.people.Director;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Director director = new Director("ыаа", 69);
        School school = new School(director,Teacher.createArrTeacher(6),Student.createArrStudent(3));
        school.schoolDay();
    }
}