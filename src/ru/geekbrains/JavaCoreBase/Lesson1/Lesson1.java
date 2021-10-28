package ru.geekbrains.JavaCoreBase.Lesson1;

public class Lesson1 {

    public static void main(String[] args) {
	    int a = 2;
	    int b = 10;
	    int c = 7;
	    int d = 3;
        double result1 = task1(a,b,c,d);

        a = 10;
        b = 9;
        boolean result2 = task2(a,b);

        a = -10;
        String result3 = task3(a);
        System.out.println(result3);

        String name = "Александр";
        System.out.println(task4(name));

        int year = 1100;
        boolean isLeap = isLeapYear(year);
        System.out.println("Год "+year+" високосный: "+isLeap);
    }

    public static double task1(int a, int b, int c, int d){
        double result = a * (b + (c / d));
        return result;
    }

    public static boolean task2(int a, int b){
        if ((a+b >= 10) && (a+b <= 20))
            return true;
        else
            return false;
    }

    public static String task3(int a){
        if (a >= 0)
            return "Число положительное";
        else
            return "Число отрицательное";
    }

    private static String task4(String name) {
        return "Привет, "+name+"!";
    }

    private static boolean isLeapYear(int year) {
        return year%400 == 0 || (year%4 == 0 && year%100 != 0);
    }
}
