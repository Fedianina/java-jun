package olga.fedianina.hw14.Task1;

import java.util.Comparator;

class SortCompani implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}
