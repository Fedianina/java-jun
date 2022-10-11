package olga.fedianina.hw6.task4.people.school;

import olga.fedianina.hw6.task2.condition.Foodstuff;
import olga.fedianina.hw6.task4.people.Student;
import olga.fedianina.hw6.task4.people.Teacher;
import olga.fedianina.hw6.task4.people.Director;

public class School {
    /*название - задается при создании объекта и не может быть изменено в последствии
директор - школа не может функционировать без директора
учителя[] - массив
ученики[] - массив
методом:

день в школе():
директор объявляет начало занятий
учителя учат учеников (предмет учителя и ученика должны совпадать, уровень знаний ученика в процессе обучения должен увеличиваться)
директор объявляет окончание занятий*/
    private Director director;
    public   Teacher[]  arrTeacher;
    public Student [] arrStudent;
    private boolean openClose;

    public School(Director director, Teacher[] arrTeacher, Student[] arrStudent) {
        this.director = director;
        this.arrTeacher = arrTeacher;
        this.arrStudent = arrStudent;
    }

    public void schoolDay(){
        director.beginningOfClasses(this);
        for (int i = 0; i<arrStudent.length; ++i) {
            for (int j = 0; j < arrTeacher.length; ++j) {
               if (arrStudent[i].getSubjectStudent().equals(arrTeacher[j].getSubjectTeacher())){
                   arrTeacher[j].lesson(arrStudent[i]);
                   System.out.println("Учитель " + arrTeacher[j].getName() + " учит ученика " + arrStudent [i] + " предмету " + arrTeacher [j].getSubjectTeacher() + " Уровень предмета  " + arrStudent[i].getLevelSubject());

               }
            }
        }
       director.endOfClasses(this);
    }
    public boolean isOpenClose() {
        return openClose;
    }

    public void setOpenClose(boolean openClose) {
        this.openClose = openClose;
    }
}
