package olga.fedianina.hw6.task4.people;
import olga.fedianina.hw6.task4.people.school.School;

public final class Teacher extends People {
    private final String subjectTeacher;
    private final int subjectLevel;

    public Teacher(String name, int age, String subjectTeacher, int subjectLevel) {
        super(name, age);
        if (age < 20)
            throw new IllegalArgumentException("Учитель слишком молод. Возраст не может быть ниже 20 лет");
        if (subjectLevel < 80)
            throw new IllegalArgumentException("Учитель слишком неопытен. Уровень знания предмета не может быть ниже 80");
        this.subjectTeacher = subjectTeacher;
        this.subjectLevel = subjectLevel;
    }

    public void lesson(Student student) {
        student.learn(Teacher.this);

    }

    public int getSubjectLevel() {
        return subjectLevel;
    }

    @Override
    public String toString() {
        return "Teacher{" + ", name='" + name + '\'' + ", age=" + age +
                "subjectTeacher='" + subjectTeacher + '\'' +
                ", subjectLevel=" + subjectLevel +
                '}';
    }

    public String getSubjectTeacher() {
        return subjectTeacher;
    }

    public static Teacher createTeacher() {
        String[] name = {"Валерий Иванович", "Мария Михайловна", "Онизука Икити", "Светлана Леонидовна", "Артемий Николаевич", "Виктор Владимирович", "Тигран Арменович", "Лаврентий Петрович"};
        String[] subject = {" Математика", "Русский язык", "ИЗО", "Литература", "Ядерная физика"};
        return new Teacher(name[(int) (Math.random() * name.length)], (int) (20 + Math.random() * 40), subject[(int) (Math.random() * subject.length)], ((int) (80 + Math.random() * 20)));
    }

    public static Teacher [] createArrTeacher(int count) {
        Teacher[] arrTeacher = new Teacher[count];
        for (int i = 0; i < count; i++) {
            arrTeacher[i] = Teacher.createTeacher();
        }
        return arrTeacher;
    }
}
