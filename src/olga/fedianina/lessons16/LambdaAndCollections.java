package olga.fedianina.lessons16;

import olga.fedianina.lessons16.education.University;
import olga.fedianina.lessons16.education.Course;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class LambdaAndCollections {
    public static void main(String[] args) {
        University university = new University();
        university.addCourses(Course.getInstances(15));


        //метод перебора коллекций foreach
        Consumer<Course> soutConsumer = course -> System.out.println(course);
        university.getCourses().forEach(soutConsumer);

        //увелич стоимость курсов на 10%

        Consumer<Course> pl = course -> {
            course.setPrice(course.getPrice()*1.1);
        };
        university.getCourses().forEach(pl);

        university.getCourses().forEach(course -> course.setPrice(course.getPrice()*1.1));

        //Вывести название курсов если они длятся менее 3 мес


        Consumer<Course> month = course -> {
            if (course.getDuration()<3) System.out.println(course.getName());
        };
        university.getCourses().forEach(month);

// курс дешевле 20_00
        Predicate<Course> byPrice = course -> course.getPrice()<20_000;
        Predicate<Course> byDuration = course -> course.getDuration()<=3;
        Predicate<Course> byName = course -> course.getName().equalsIgnoreCase("jjd");


        university.getFilteredCourses(byPrice).forEach(course -> System.out.println(course));

        university.getFilteredCourses(byPrice.and(byDuration)).forEach(course -> System.out.println(course));


        // удаление removeIf
        university.getCourses().removeIf(course -> course.getPrice()<15_00);

        //сортировка (Comparator)

        Comparator<Course> comparingByName = (course1, course2) -> course1.getName().compareTo(course2.getName());
        Comparator<Course> comparingByPrice = (course1, course2) -> (int) (course1.getPrice()-course2.getPrice());

        university.getCourses().sort(comparingByName.thenComparing(comparingByPrice));
        System.out.println(university.getCourses());

        }
    }