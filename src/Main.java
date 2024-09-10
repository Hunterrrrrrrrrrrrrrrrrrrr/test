import java.util.*;


public class Main {
    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();

        management.addEmployee("A", 1);
        management.addEmployee("B", 2);
        management.addEmployee("C", 3);

        management.deleteEmployee("B");

        management.addEmployee("A", 1);
        management.addEmployee("D", 2);

        management.printEmployees();
    }
}


class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + '}';
    }
}

class EmployeeManagement {
    private List<Employee> employees;

    public EmployeeManagement() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, int age) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return;
            }
        }
        employees.add(new Employee(name, age));
    }

    public void deleteEmployee(String name) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getName().equals(name)) {
                iterator.remove();
                break;
            }
        }
    }

    public void printEmployees() {
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}


