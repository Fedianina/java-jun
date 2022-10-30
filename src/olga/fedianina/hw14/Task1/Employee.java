package olga.fedianina.hw14.Task1;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;


    // TODO: добавить конструктор, необходимы геттеры и сеттеры


    public Employee(String name, String company, int salary, int age) {
        setName(name);
        setCompany(company);
        setSalary(salary);
        setAge(age);
    }




    public String getName() {
        return name;
    }


    public void setName(String name) {
        if (name.length()<2) throw new IllegalArgumentException("Длинна имени не должна быть менее 2х символов");
        this.name = name;
    }


    public String getCompany() {
        return company;
    }


    public void setCompany(String company) {
        if (company.length()<3) throw new IllegalArgumentException("Название компани не должно быть короче 3х символов");
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 10_000) throw new IllegalArgumentException("Слишком низкая зарплата");
        this.salary = salary;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 21 && 60<age) throw new IllegalArgumentException("Возраст работника не может быть меньше 18 лет");
        this.age = age;
    }

    // TODO: дописать реализацию метода для создания списка из объектов класса Employee.
    //  Объекты Employee создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп.
    //  num - количество объектов в списке
    public static List<Employee> employeeGenerator(int num) {
        ArrayList<Employee> employees = new ArrayList<>();
        int i = 0;
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний
        while (i<num){
            Employee employee =  new Employee (names[(int)(Math.random()* names.length)], companies[(int)(Math.random()*companies.length)], (int) (Math.random()*10_000)+ 10_000, (int) (Math.random()*59)+21);
            employees.add(employee);
            ++i;
        }
        return employees;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}

