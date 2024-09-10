import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();

        management.addEmployee("Alice", 25);
        management.addEmployee("Bob", 30);
        management.addEmployee("Charlie", 22);
        management.addEmployee("David", 35);
        management.printEmployeesByName();

        management.deleteEmployee("Bob");

        management.updateEmployee("Alice", 26);

        management.findEmployee("Charlie");

        management.printEmployeesByName();

        management.printEmployeesByAge();

        management.printAverageAge();

        management.deleteEmployeesAboveAge(30);

        management.printEmployeesByName();
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

    public void setAge(int age) {
        this.age = age;
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
                System.out.println("员工 " + name + " 已被删除。");
                return;
            }
        }
        System.out.println("未找到员工 " + name + "。");
    }

    // 更新指定员工的年龄
    public void updateEmployee(String name, int newAge) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employee.setAge(newAge);
                System.out.println("员工 " + name + " 的年龄已更新为 " + newAge + "。");
                return;
            }
        }
        System.out.println("未找到员工 " + name + "。");
    }

    public void findEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                System.out.println("找到员工: " + employee);
                return;
            }
        }
        System.out.println("未找到员工 " + name + "。");
    }

    public void printEmployeesByName() {
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        System.out.println("按名字排序:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void printEmployeesByAge() {
        Collections.sort(employees, Comparator.comparing(Employee::getAge));
        System.out.println("按年龄排序:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void printAverageAge() {
        if (employees.isEmpty()) {
            System.out.println("没有员工信息。");
            return;
        }
        int totalAge = 0;
        for (Employee employee : employees) {
            totalAge += employee.getAge();
        }
        double averageAge = (double) totalAge / employees.size();
        System.out.println("平均年龄为: " + averageAge);
    }

    public void deleteEmployeesAboveAge(int age) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getAge() > age) {
                iterator.remove();
                System.out.println("员工 " + employee.getName() + " 已被删除。");
            }
        }
    }
}


