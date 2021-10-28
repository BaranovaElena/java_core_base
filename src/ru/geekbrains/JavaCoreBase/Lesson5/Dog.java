package ru.geekbrains.JavaCoreBase.Lesson5;

public class Dog extends Animal {

    public Dog(String name) {
        super(name, 500, 10, 0.5f);
    }
    //перегруженный конструктор для выбора пользователем, будет ли разброс в ограничениях
    public Dog(String name, boolean error) {
            super(name, 500, 10, 0.5f, error?0.2f:0);
    }

    @Override
    public void swim(int distance) {
        if (distance <= maxSwim)
            System.out.println(name + " has swam!");
        else
            System.out.println(name + " has swam only " + maxSwim + "m");
    }
}
