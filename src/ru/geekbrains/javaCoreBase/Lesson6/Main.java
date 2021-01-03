package ru.geekbrains.javaCoreBase.Lesson6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        //task2
        String text1, text2;

        text1 = getText("test1.txt");
        text2 = getText("test2.txt");
        setText(text1+text2, "test3.txt");

        //task3
        String file = "test3.txt";
        String word = "drink";
        boolean result = isContainsWord(file, word);
        System.out.print("В файле "+file+" ");
        System.out.println((result ? "есть слово ":"нет слова ") + word);

        //task4
        result = isContainsWordInDir(word);
        System.out.print("В папке проекта ");
        System.out.println((result ? "есть слово ":"нет слова ") + word);

    }

    public static String getText(String file){
        StringBuilder text = new StringBuilder();
        int intText;

        try {
            FileInputStream fis = new FileInputStream(file);
            while ((intText = fis.read()) != -1) {
                text.append((char)intText);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public static void setText(String str, String file){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            byte[] text = str.getBytes();
            fos.write(text);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isContainsWord(String file, String word) {
        String text = getText(file);
        text = text.toLowerCase();
        word = word.toLowerCase();

        // с читами :)
        //return text.contains(word);

        for (int i=0; i+word.length()-1<text.length(); i++){
            String substring = text.substring(i,i+word.length());
            if (substring.equals(word))
                return true;
        }
        return false;
    }

    public static boolean isContainsWordInDir(String word){
        File dir = new File(".");   //в текущей папке

        try {
            //warning Dereference of 'dir.listFiles()' may produce 'NullPointerException'
            //подскажите, как избавиться от warning? я использовала try-catch, но warning остался
            for (File file : dir.listFiles()) {
                if (file.getName().endsWith(".txt")) {
                    if (isContainsWord(file.toString(), word))
                        return true;
                }
            }
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        return false;
    }

}
