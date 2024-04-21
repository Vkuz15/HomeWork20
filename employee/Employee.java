package employee;

import java.util.Objects;

public class Employee {
    private String fullName;
    private double salary;
    private int department;
    private static int counter;
    private int id;


    public Employee(String fullName, double salary, int department) {
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
        id = ++counter;
    }

    public String getFullName() {
        return fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public static void printStaff(Employee[] staff){
        for (Employee e:staff) {
            System.out.println(e);
        }
    }

    public static double totalCosts(Employee[] staff) {
        double totalSum = 0;
        for (int i = 0; i < staff.length; i++) {
            totalSum = totalSum + staff[i].getSalary();
        }
        return totalSum;
    }

    public static int maxSalary(Employee[] staff) {
        double max = staff[0].getSalary();
        int idx = 0;
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getSalary() > max) {
                max = staff[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    public static int minSalary(Employee[] staff) {
        double min = staff[0].getSalary();
        int idx = 0;
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getSalary() < min) {
                min = staff[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    public static double average(Employee[] staff) {
        return (double) totalCosts(staff) / staff.length;
    }

    public static void listFullName(Employee[] staff) {
        System.out.println("Фамилии, Имена, Отчества сотрудников компании: \n");
        for (Employee name:staff) {
            System.out.println(name.getFullName());
        }
    }

    //Middle

    public static void salaryPercentage(Employee[] staff, int percent) {
        for (Employee i : staff) {
            i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, salary, department);
    }

    @Override
    public String toString() {
        return  "Id " + id + " ФИО - " + fullName + " Зарплата - " + salary + " Отдел - " + department;
    }
}
