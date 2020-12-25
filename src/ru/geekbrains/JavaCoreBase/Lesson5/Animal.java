package ru.geekbrains.JavaCoreBase.Lesson5;

import java.util.Random;

public abstract class Animal {
    protected String name;
    protected int maxRun;
    protected int maxSwim;
    protected float maxJump;

    protected Animal(String name, int maxRun, int maxSwim, float maxJump){
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.maxJump = maxJump;
    }
    //перегруженный конструктор для разброса в ограничениях
    protected Animal(String name, int maxRun, int maxSwim, float maxJump, float error){
        this.name = name;
        this.maxRun = addDispersion(maxRun, error);
        this.maxSwim = addDispersion(maxSwim, error);
        this.maxJump = addDispersion(maxJump, error);
    }

    public void run(int distance){
        if (distance <= maxRun)
            System.out.println(name + " has run!");
        else
            System.out.println(name + " has run only " + maxRun + "m");
    }

    abstract protected void swim(int distance);

    public void jump(float height){
        if (height <= maxJump)
            System.out.println(name + " has jumped");
        else
            System.out.println(name + " has jumped only " + maxJump + "m");
    }

    private int addDispersion(int value, float error){
        int min = (int)(value*(1-error));
        int max = (int)(value*(1+error));
        Random random = new Random();

        // например, от 0.8х до 1.2х , если error == 0.2
        return min + random.nextInt(max-min+1);
    }
    private float addDispersion(float value, float error){
        float min = value*(1-error);
        float max = value*(1+error);
        Random random = new Random();

        // например, от 0.8х до 1.2х , если error == 0.2
        return min + random.nextFloat()*(max-min);
    }

    public String getName() { return name; }
    public int getMaxRun() { return maxRun; }
    public int getMaxSwim() { return maxSwim; }
    public float getMaxJump() { return maxJump; }
}
