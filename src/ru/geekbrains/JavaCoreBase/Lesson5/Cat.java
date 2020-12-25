package ru.geekbrains.JavaCoreBase.Lesson5;

public class Cat extends Animal {

    public Cat(String name) {
        super(name, 200, 0, 2);
    }
    //перегруженный конструктор для выбора пользователем, будет ли разброс в ограничениях
    public Cat(String name, boolean error) {
        super(name, 200, 0, 2, error?0.1f:0);
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " can't swim!!!");
    }
}
