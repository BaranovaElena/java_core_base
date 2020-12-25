package ru.geekbrains.JavaCoreBase.Lesson5;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        //create animals
        Dog dog = new Dog("Dog");
        Horse horse = new Horse("Horse");
        Bird bird = new Bird("Bird");
        Cat cat = new Cat("Cat");

        Animal[] animals = {dog, horse, bird, cat};

        for (Animal animal : animals) {
            animal.run(300);
            animal.swim(50);
            animal.jump(0.5f);
        }
        /*
         Dog has run!
         Dog has swam only 10m
         Dog has jumped
         Horse has run!
         Horse has swam!
         Horse has jumped
         Bird has run only 5m
         Bird can't swim!!!
         Bird has jumped only 0.2m
         Cat has run only 200m
         Cat can't swim!!!
         Cat has jumped
        */

        //task 5
        Dog dog1 = new Dog("dog1",true);
        Dog dog2 = new Dog("dog2",true);
        Dog dog3 = new Dog("dog3",false);
        Horse horse1 = new Horse("horse1",true);
        Cat cat1 = new Cat("cat1", true);
        Animal[] animals1 = {dog1, dog2, dog3, horse1, cat1};

        for (Animal a : animals1) {
            System.out.println(a.getName() + " can run " + a.getMaxRun() +
                    "m, can swim " + a.getMaxSwim() +
                    "m, can jump to " + (double)Math.round(a.getMaxJump()*100)/100 + "m");
        }
        /*
        dog1 can run 555m, can swim 8m, can jump to 0.58m
        dog2 can run 570m, can swim 10m, can jump to 0.51m
        dog3 can run 500m, can swim 10m, can jump to 0.5m
        horse1 can run 1568m, can swim 106m, can jump to 2.87m
        cat1 can run 210m, can swim 0m, can jump to 2.16m
         */
    }
}
