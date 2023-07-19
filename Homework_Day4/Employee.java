package Homework_Day4;

public class Employee {
    private int id;
    private String name;
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public double rawSalary(double config) {
        double rawSalary = 5000000;
        salary = rawSalary * config;
        return salary;
    }

    public String getInfo() {
        return (id + "\n" + name + "\n" + salary);
    }
}
