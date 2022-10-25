package olga.fedianina.lesson14;


import java.util.Comparator;

class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAge() < o2.getAge()) return -1;
        if (o1.getAge() > o2.getAge()) return 1;
        return 0;
    }
}

    public class Student implements Comparable<Student> {
        private final int id;
        private String name;
        private int age;

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return id == student.id;
        }

        // 0 - объекты равны
        //(<0) текущий объект меньше, чем тот, что передается в метот
        //(0<)текущий объект больше, чем тот, что передается в метот
        @Override
        public int compareTo(Student o) {
            if (this.getId() < o.getId()) return -1;
            if (this.getId() > o.getId()) return 1;
            return 0;
        }

    }

