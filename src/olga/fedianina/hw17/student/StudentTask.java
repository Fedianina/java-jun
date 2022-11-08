package olga.fedianina.hw17.student;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StudentTask {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Женя", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "Олег", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "Алексей", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "Григорий", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "Ирина", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // TODO: Используя Stream API:
        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Student.Gender, ArrayList<Student>>
        //  2. Найти средний возраст учеников
        //  3. Найти самого младшего ученика
        //  4. Найти самого старшего ученика
        //  5. Собрать учеников в группы по году рождения
        //  6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        //  7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        //  8. Вывести в консоль всех учеников в возрасте от N до M лет
        //  9. Собрать в список всех учеников с именем=someName
        //  10. Собрать Map<Student.Gender, Integer>, где Student.Gender - пол, Integer - суммарный возраст учеников данного пола


        Map<Student.Gender, ArrayList<Student>> map1 = students.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.toCollection(ArrayList::new)));
        System.out.println(map1);


        System.out.println(students.stream().flatMapToInt(student -> IntStream.of(LocalDate.now().getYear() -student.getBirth().getYear())).average());
        System.out.println(students.stream().min((c1, c2)-> (c1.getBirth().getDayOfYear() - c2.getBirth().getDayOfYear())));
        System.out.println(students.stream().max((c1, c2)-> (c1.getBirth().getDayOfYear() - c2.getBirth().getDayOfYear())));
        Map<Integer, ArrayList<Student>> yearOfBirth = students.stream().collect(Collectors.groupingBy(student -> student.getBirth().getYear(), Collectors.toCollection(ArrayList::new)));
        System.out.println(yearOfBirth);
        System.out.println(Arrays.toString(students.stream().filter(student -> {
            int a = 0;
            for (Student student1 : students) {
                if (student.getName().equals(student1.getName())) a++;
            }
            return a < 2;
        }).toArray()));
        Comparator<Student> comparator1 = (s1, s2) -> s1.getGender().compareTo(s2.getGender());
        Comparator<Student>comparator2 = (s1, s2) -> s1.getBirth().compareTo(s2.getBirth());
        Comparator<Student>comparator3 = (s1, s2) -> s1.getName().compareTo(s2.getName());
        List<Student> sortStudent = students.stream().sorted(comparator1.thenComparing(comparator2).thenComparing(comparator3).reversed()).collect(Collectors.toList());
        System.out.println(sortStudent);
        System.out.println("Задание 8");
        int age1 = 8, age2 = 10;

        students.stream().filter(student -> {
                    if (age1 <= (LocalDate.now().getYear() - student.getBirth().getYear()) && (LocalDate.now().getYear() -student.getBirth().getYear()) <= age2) return true;
                    return false;
                }).forEach(student -> System.out.println(student));

        System.out.println("Задание 9");
        String someName = "Иван";
        students.stream().filter(student -> {
            if (student.getName().equalsIgnoreCase(someName)) return true;
            return false;
        }).forEach(student -> System.out.println(student));


        Map<Student.Gender, Integer> studentIntegerMap = students.stream().collect(Collectors.toMap(elem ->elem.getGender(),elem -> LocalDate.now().getYear() - elem.getBirth().getYear(), (elemValue1, elemValue2) -> elemValue1+elemValue2));
        System.out.println(studentIntegerMap);
    }
}