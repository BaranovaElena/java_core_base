package ru.geekbrains.JavaCoreBase.Lesson5;

public class Horse extends Animal {

    public Horse(String name) {
        super(name, 1500, 100, 3);
    }
    //перегруженный конструктор для выбора пользователем, будет ли разброс в ограничениях
    public Horse(String name, boolean error) {
        super(name, 1500, 100, 3, error?0.1f:0);
    }

    @Override
    public void swim(int distance) {
        if (distance <= maxSwim)
            System.out.println(name + " has swam!");
        else
            System.out.println(name + " has swam only " + maxSwim + "m");
    }
}
