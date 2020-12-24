package ru.geekbrains.JavaCoreBase.Lesson4;

public class Employee {
    private String  fullName;
    private String  position;
    private String  phoneNumber;
    private int     salary;
    private int     age;
    private int     id;

    Employee(String name, String position,
             String phone, int salary, int age, int id){
        this.fullName = name;
        this.position = position;
        this.phoneNumber = phone;
        this.salary = salary;
        this.age = age;
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getId() { return id; }

    public void increaseSalary(int increase) {
        salary += increase;
    }
}
