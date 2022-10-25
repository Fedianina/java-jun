package olga.fedianina.lesson14;
import java.util.*;

public class CollectionsLesson {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Maxim", 17);
        Student student2 = new Student(2, "Anna", 21);
        Student student3 = new Student(3, "Paul", 23);
        Student student4 = new Student(4, "Helen", 19);
        Student student5 = new Student(4, "Helen", 19);


        System.out.println("ArrayList");

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList = new ArrayList<>(30);

        studentArrayList.add(student1);
        studentArrayList.add(student2);


        studentArrayList.add(1, student3);

        studentArrayList.trimToSize();

        System.out.println(studentArrayList.get(1));


        studentArrayList.remove(2);

        studentArrayList.remove(student1);


        Student[] students = {student1, student2};
        List<Student> studentsList = Arrays.asList(students);


        studentArrayList.removeAll(studentsList);

        studentArrayList.addAll(Arrays.asList(student1, student2, student3, student4, student5));

        for (Student student : studentsList) {
            System.out.println(student.getId());
            student.setName("Студент" + student.getName());
        }


        Iterator<Student> iterator = studentArrayList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getAge() > 20) {
                iterator.remove();
            }
        }


        // LinkedList


        //class Node;
        //private Node next;
        //private value;


        //add (st1)
        //new Node [value - student1, next - null]
        HashSet<Student> studentHashSet = new HashSet<>();
        studentHashSet = new HashSet<>(studentArrayList); //тут не добавит дублдир эл ты
        System.out.println(studentHashSet);

        int age = 0;
        for (Student student : studentHashSet) {
            age += student.getAge();
        }
        System.out.println(age);

        TreeSet<Student> studentTreeSet = new TreeSet<>();
        studentTreeSet.add(student5);
        studentTreeSet.add(student3);
        studentTreeSet.add(student2);
        studentTreeSet.add(student1);

        System.out.println(studentTreeSet);


        Comparator<Student> comparator = new AgeComparator();
        //если есть компоратор по возратсту. при одинаковом имени

        //comporator1.thenComparing(comparator2)
        //TreeSet<Student> studentTreeSet2 = new TreeSet <>(comparator)
        //st

    }
    Comparator<Magazine> magazineComparator = new TitleComparator();
    Comparator<Magazine> magazineComparator2 = new PicturesCountComporator();
    Comparator <Magazine> magazineComparator3 = new TitleComparator().thenComparing(new PicturesCountComporator());
    TreeSet<Magazine> magazineTreeSet = new TreeSet<>(magazineComparator3);

}















