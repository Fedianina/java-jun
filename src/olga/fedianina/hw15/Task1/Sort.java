package olga.fedianina.hw15.Task1;

import olga.fedianina.lesson14.Student;

import java.util.Comparator;

 class SortName implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}


