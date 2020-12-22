package ru.geekbrains.JavaCoreBase.Lesson3;

import java.util.Random;
import java.util.Scanner;

public class XOGame {
    public static final char PLAYER_DOT = 'X';
    public static final char PC_DOT = 'O';
    public static final char EMPTY_DOT = '_';

    public static final int MAP_SIZE_X = 5;
    public static final int MAP_SIZE_Y = 5;
    public static final int WIN_SIZE = 4;

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();

    public static char[][] map;

    public static void main(String[] args) {
        System.out.println("Игра крестики-нолики!");

        initMap();
        printMap();

        while (true) {
            playerTurn();
            if (isWin(PLAYER_DOT)){
                System.out.println("Вы выиграли!");
                return;
            }

            PCTurn();
            if (isWin(PC_DOT)){
                System.out.println("Выиграл компьютер");
                return;
            }
        }

    }

    private static void initMap() {
        map = new char[MAP_SIZE_Y][MAP_SIZE_X];

        for (int y=0; y<MAP_SIZE_Y; y++){
            for (int x=0; x<MAP_SIZE_X; x++)
                map[y][x] = EMPTY_DOT;
        }
    }

    private static void printMap() {
        for (int y=0; y<MAP_SIZE_Y; y++){
            System.out.print("|");
            for (int x=0; x<MAP_SIZE_X; x++){
                System.out.print(map[y][x]+"|");
            }
            System.out.println();
        }
    }

    private static boolean isWin(char dot) {
        //horizontal
        for (int y=0; y<MAP_SIZE_Y; y++){   //по строкам
            for (int x=0; x<=(MAP_SIZE_X-WIN_SIZE); x++){   //по наборам в строке
                int counter = 0;
                for (int i=0; i<WIN_SIZE; i++){ //по элементам
                    if (map[y][x+i] == dot)
                        counter++;
                    else break;
                }
                if (counter == WIN_SIZE)
                    return true;
            }
        }

        //vertical
        for (int x=0; x<MAP_SIZE_X; x++){   //по столбцам
            for (int y=0; y<=(MAP_SIZE_Y-WIN_SIZE); y++){   //по наборам в столбце
                int counter = 0;
                for (int i=0; i<WIN_SIZE; i++){ //по элементам
                    if (map[y+i][x] == dot)
                        counter++;
                    else break;
                }
                if (counter == WIN_SIZE)
                    return true;
            }
        }

        //diagonal
        for (int y=0; y<=(MAP_SIZE_Y-WIN_SIZE); y++){   //по строкам
            for (int x=0; x<(MAP_SIZE_X-WIN_SIZE); x++){    //по столбцам
                int counterLeft=0;
                int counterRight=0;
                for (int i=0; i<WIN_SIZE; i++){ //по диагоналЯМ вниз
                     if (map[y+i][x+i] == dot)  //главная
                         counterLeft++;
                     if (map[y+i][MAP_SIZE_X-i-1] == dot) //побочная
                         counterRight++;
                }
                if (counterLeft==WIN_SIZE || counterRight==WIN_SIZE)
                    return true;
            }
        }
        return false;
    }

    private static void playerTurn() {
        System.out.println("Ваш ход: введите координаты выбранной клетки");

        int row, col;
        do{
            do {
                System.out.print("Введите номер строки (от 1 до "+MAP_SIZE_Y+"): ");
                row = SCANNER.nextInt()-1;
            } while (row<0 || row>MAP_SIZE_Y-1);

            do {
                System.out.print("Введите номер столбца (от 1 до "+MAP_SIZE_X+"): ");
                col = SCANNER.nextInt()-1;
            } while (col<0 || col>MAP_SIZE_X-1);

            if (map[row][col] != EMPTY_DOT)
                System.out.println("Клетка занята, выберете другую");
        } while (map[row][col] != EMPTY_DOT);

        map[row][col] = PLAYER_DOT;
        printMap();
    }

    private static void PCTurn() {
        System.out.println("Ход компьютера:");

        int row, col;
        do{
            row = RANDOM.nextInt(MAP_SIZE_Y);
            col = RANDOM.nextInt(MAP_SIZE_X);
        } while (map[row][col] != EMPTY_DOT);

        map[row][col] = PC_DOT;
        printMap();
    }
}
