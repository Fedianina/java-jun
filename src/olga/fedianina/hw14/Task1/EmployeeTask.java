package olga.fedianina.hw14.Task1;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeTask {
    public static void main(String[] args) {
    List<Employee> employeeList = Employee.employeeGenerator(50);
        System.out.println(employeeList);


    // TODO 1: отсортировать список по имени
        Comparator<Employee> sortName = new SortName();
        Collections.sort(employeeList, sortName);
        System.out.println(employeeList);
    // TODO 2: отсортировать список по имени и зп
        Comparator<Employee> sortSalary = new SortSalary();
        Comparator <Employee> sortNameAndSalary = sortName.thenComparing(sortSalary);
        Collections.sort(employeeList, sortNameAndSalary);
        System.out.println(employeeList);

    // TODO 3: отсортировать список по имени, зарплате, возрасту и компании
        Comparator<Employee> sortAge = new SortAge();
        Comparator<Employee> sortCompany = new SortCompani();
        Comparator<Employee> sortAll = sortName.thenComparing(sortSalary.thenComparing(sortAge.thenComparing(sortCompany)));
        Collections.sort(employeeList, sortAll);
        System.out.println(employeeList);

}
}

