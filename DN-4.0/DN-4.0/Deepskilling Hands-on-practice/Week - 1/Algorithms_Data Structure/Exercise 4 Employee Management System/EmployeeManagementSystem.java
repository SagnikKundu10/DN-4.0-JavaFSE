import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "[" + employeeId + " - " + name + " - " + position + " - $" + salary + "]";
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee emp) {
        if (size < employees.length) {
            employees[size++] = emp;
        } else {
            System.out.println("Employee array is full!");
        }
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void displayEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(10);

        system.addEmployee(new Employee(101, "Alice", "Manager", 80000));
        system.addEmployee(new Employee(102, "Bob", "Developer", 60000));
        system.addEmployee(new Employee(103, "Charlie", "Designer", 50000));

        System.out.println("All Employees:");
        system.displayEmployees();

        System.out.println("\nSearching for Employee with ID 102:");
        Employee found = system.searchEmployee(102);
        System.out.println(found != null ? found : "Not found");

        System.out.println("\nDeleting Employee with ID 101:");
        system.deleteEmployee(101);
        System.out.println("Employees after deletion:");
        system.displayEmployees();
    }
}
