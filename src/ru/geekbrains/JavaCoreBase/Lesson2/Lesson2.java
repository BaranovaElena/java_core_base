package ru.geekbrains.JavaCoreBase.Lesson2;

public class Lesson2 {

    public static void main(String[] args) {

        System.out.println("Задание 1:");
        int[] array1 = {1,1,0,0,1,0,1,1,0,0};
        outputArray(array1);
        invert(array1);
        outputArray(array1);

        System.out.println("\nЗадание 2:");
        int[] array2 = new int[8];
        fillArray(array2);
        outputArray(array2);

        System.out.println("\nЗадание 3:");
        int[] array3 = {1,5,3,2,11,4,5,2,4,8,9,1};
        multiply(array3);
        outputArray(array3);

        System.out.println("\nЗадание 4:");
        int[] array4 = array3;
        System.out.println("Максимальный элемент: " + max(array4));
        System.out.println("Минимальный элемент: " + min(array4));

        System.out.println("\nЗадание 5:");
        int[][] array5 = new int[5][5];
        fillDiagonals(array5);
        for (int i=0; i<array5.length; i++){
            outputArray(array5[i]);
        }

        System.out.println("\nЗадание 6:");
        int[] array6 = {10,1,2,3,4};
        outputArray(array6);
        System.out.println("\t" + checkBalance(array6));

        System.out.println("\nЗадание 7:");
        int[] array7 = new int[5];
        for (int i=0; i<array7.length; i++)
            array7[i] = i+1;
        outputArray(array7);
        int n = -2;
        System.out.println("Смещение на " +n+":");
        shiftCyclically(array7, n);
        outputArray(array7);

        System.out.println("\nЗадание 8:");
        int[] array8 = new int[5];
        for (int i=0; i<array8.length; i++)
            array8[i] = i+1;
        n = -2;
        System.out.println("Смещение на " +n+":");
        shiftWithoutHelp(array8, n);
        outputArray(array8);
    }

    private static void shiftWithoutHelp(int[] array, int n) {
        n = n % array.length;   //убираем полные обороты
        if (n<0){
            for (int i=0; i>n; i--){
                int arr0 = array[0];    //запоминаем крайний слева
                for (int j=1; j<array.length; j++)  // двигаем влево
                    array[j-1] = array[j];
                array[array.length-1] = arr0;   //ставим крайний справа
            }
        }
        else {
            for (int i=0; i<n; i++){
                int arrLast = array[array.length-1];    //запоминаем крайний справа
                for (int j=array.length-1; j>0; j--)    //двигаем вправо
                    array[j] = array[j-1];
                array[0] = arrLast;     //ставим крайний слева
            }
        }
    }

    private static void shiftCyclically(int[] array, int n) {
        int[] help = new int[array.length];
        for (int i=0; i<array.length; i++)
            help[i] = array[i];

        n = n % array.length;   //убираем полные обороты
        for (int i=0; i<help.length; i++){
            int newIndex = i + n;   //ищем новое место для array[i]
            if (newIndex<0)
                newIndex = newIndex + help.length;
            else if (newIndex>help.length-1)
                newIndex = newIndex - help.length;

            array[newIndex] = help[i];
        }
    }

    private static boolean checkBalance(int[] array) {
        for (int i=1; i<array.length; i++){
            int sumLeft = 0;
            int sumRight = 0;
            for (int j=0; j<array.length; j++){
                if (j<i)
                    sumLeft += array[j];
                else
                    sumRight += array[j];
            }
            if (sumLeft == sumRight)
                return true;
        }
        return false;
    }

    private static void fillDiagonals(int[][] array) {
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array[i].length; j++){
                if (i == j || i+j == array.length-1)
                    array[i][j] = 1;
            }
        }
    }

    private static int min(int[] array) {
        int min = array[0];
        for (int i=1; i<array.length; i++){
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }

    private static int max(int[] array) {
        int max = array[0];
        for (int i=1; i<array.length; i++){
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    private static void multiply(int[] array) {
        for (int i=0; i<array.length; i++){
            if (array[i] < 6)
                array[i] = array[i]*2;
        }
    }

    private static void fillArray(int[] array) {
        int value = 1; //можно было обойтись i, но так можно менять длину массива
        for (int i=0; i<array.length; i++){
            array[i] = value;
            value += 3;
        }
    }

    public static void invert(int[] array){
        for (int i=0; i<array.length; i++){
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }

    public static void outputArray(int[] array){
        for (int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
