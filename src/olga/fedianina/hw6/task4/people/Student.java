package olga.fedianina.hw6.task4.people;

public final class Student extends People{
    private String subjectStudent;
    private int levelSubject = 0;


    public  Student (String name, int age, String subjectStudent){
        super (name, age);
        if (age<6)
            throw new IllegalArgumentException("Ученик слишком молод. В школу принимаются дети не моложе 6 лет");
        this.subjectStudent = subjectStudent;
    }

     void learn (Teacher teacher){
        int levelUp = ((int) (Math.random()*teacher.getSubjectLevel()));
        this.levelSubject += levelUp;
    }

    @Override
    public String toString() {
        return
                name + '\'' + age + " Лет "+
                 subjectStudent + '\'' +
                ", levelSubject=" + levelSubject
                ;
    }

    public String getSubjectStudent() {
        return subjectStudent;
    }
    public static Student createStudent() {
        String [] name = {"Света", "Вася", "Петя", "Аня", "Саша", "Вова", "Боря", "Лена"};
        String [] subject = {" Математика", "Русский язык", "ИЗО","Литература","Ядерная физика"};
        return new Student(name [(int) (Math.random()* name.length)], (int) (6 + Math.random()* 9), subject [(int) (Math.random()* subject.length)]);


    }
    public static Student [] createArrStudent(int count) {
        Student[] arrStudent = new Student[count];
        for (int i = 0; i < count; i++) {
            arrStudent[i] = Student.createStudent();
        }
        return arrStudent;
    }

    public int getLevelSubject() {
        return levelSubject;
    }
}
