package olga.fedianina.lesson17;

import olga.fedianina.lessons16.education.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        Stream<Integer> integerSystem1 = Stream.of(-560, 315, 12, -1, 45, 0, 0, 23, -2, 221);
        integerSystem1.filter(elem -> elem < 0).limit(5).map(elem -> elem + "p.").forEach(element -> System.out.println(element));


        Stream<Integer> integerSystem2 = Stream.of(-6, 45, 12, -77, 77, 45, 6, -6, 0, 0, 12);
        integerSystem2.distinct().sorted().forEach(element -> System.out.println(element));


        Stream<Integer> integerSystem3 = Stream.of(411,7,90,-100,0,2,71);
        System.out.println(integerSystem3.anyMatch(num -> num == 0));


        Stream<Integer> integerSystem4 = Stream.of(411,7,90,-100,0,2,71);
        System.out.println(integerSystem3.allMatch(num -> num > 0));

        Stream<Integer> integerSystem5 = Stream.of(411,7,90,-100,0,2,71);
        System.out.println(integerSystem3.noneMatch(num -> num > 10_000));


        String [] colors = {"white", "black", "red", "yellow", "yellowgreen"};
        String color = Arrays.stream(colors).findAny().get();
        color = Arrays.stream(colors).findAny().orElse("yellow");
        boolean isPresent = Arrays.stream(colors).findAny().isPresent();
        Arrays.stream(colors)
                .skip(2)
                .filter(eny ->eny.startsWith("y"))
                .forEach(System.out::println);


// ьинимальный по стоимости курс
        ArrayList<Course> courses = new ArrayList<>(Course.getInstances(7));
        System.out.println(courses);

        Course minByPrice = courses.stream().min((c1, c2) ->(int)(c1.getPrice() - c2.getPrice())).orElse(Course.getInstance());
        System.out.println(minByPrice);

        Course maxByD = courses.stream().max((c1, c2) -> c1.getDuration() - c2.getDuration()).orElse(Course.getInstance());
        System.out.println(maxByD);




        // массив из потока с курсами дороже 20к
        Course [] coursesArr = courses.stream().filter(course ->course.getPrice() > 20_000).toArray(Course[]::new);
        System.out.println(Arrays.toString(coursesArr));


        //List <Course> продолжительностью 3 мес и более и увеличить стоимость каждого на 5000р

        List<Course> courseList = courses.stream().filter(course -> course.getDuration()>=3)
                .peek(course -> course.setPrice(course.getPrice()+5000))
                .collect(Collectors.toList());
                //collect(Collectors.toSet()) - множество
                //collect(Collectors.toCollection(ArrayList::new))


        //мапа ключи - эл ты массива, значение - размер строки
        colors = new String[] {"white", "black", "red", "yellow", "yellowgreen"};
        Map<String, Integer> map01 = Arrays.stream(colors).collect(Collectors.toMap(elem->elem, elem -> elem.length(),(elem1, elem2)->elem1));
        System.out.println(map01);


        //ключи - названия, значения - списки курса с таким названием

        Map<String, List<Course>> map2 = courses.stream().collect(Collectors.groupingBy(course -> course.getName()));

        Map<Integer, List<Course>> map3 = courses.stream().collect(Collectors.groupingBy(course -> course.getDuration(), Collectors.toCollection(ArrayList::new)));

        //ключи -- названия, значение - кол - во курсов

        Map<String, Long>map4 = courses.stream().collect(Collectors.groupingBy(course -> course.getName(), Collectors.counting()));
        Map<String, Double>map5 = courses.stream().collect(Collectors.groupingBy(course -> course.getName(),Collectors.averagingDouble(course -> course.getPrice())));







    }
}



