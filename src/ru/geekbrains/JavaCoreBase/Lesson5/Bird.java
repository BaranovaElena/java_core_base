package ru.geekbrains.JavaCoreBase.Lesson5;

public class Bird extends Animal {

    public Bird(String name) {
        super(name, 5, 0, 0.2f);
    }
    //перегруженный конструктор для выбора пользователем, будет ли разброс в ограничениях
    public Bird(String name, boolean error) {
        super(name, 5, 0, 0.2f, error?0.2f:0);
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " can't swim!!!");
    }
}
