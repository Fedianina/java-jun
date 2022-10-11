package olga.fedianina.hw6.task4.people;

import olga.fedianina.hw6.task4.people.school.School;

public final class Director extends People {

    public Director(String name, int age) {
        super(name, age);
        if (age<40)
            throw new IllegalArgumentException("Директор слишком молод. Значение возраста не может быть меньше 40 лет");
    }

    public void beginningOfClasses(School school){
        System.out.println("Занятия начались");
        school.setOpenClose(true);

    }
    public void endOfClasses(School school){
        System.out.println("Занятия закончены");
        school.setOpenClose(true);
    }


    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
