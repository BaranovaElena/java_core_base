package ru.geekbrains.javaCoreBase.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private static final int WIN_WIDTH = 500;
    private static final int WIN_HEIGHT = 550;
    private static final int WIN_X = 500;
    private static final int WIN_Y = 200;

    private Settings settings;
    private GameMap gameMap = new GameMap();

    MainWindow()
    {
        //настройки окна
        setSize(WIN_WIDTH,WIN_HEIGHT);
        setLocation(WIN_X,WIN_Y);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        settings = new Settings(this);

        //работа с кнопками
        JButton btnStart = new JButton("Начать новую игру");
        JButton btnExit = new JButton("Выйти из игры");
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2));
        buttonsPanel.add(btnStart,0);
        buttonsPanel.add(btnExit,1);

        //добавление элементов на mainwindow
        add(buttonsPanel, BorderLayout.SOUTH);
        add(gameMap);

        //обработка нажатий кнопок
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    void startNewGame(int mode, int sizeX, int sizeY, int winLen){
        gameMap.startNewGame(mode, sizeX, sizeY, winLen);
    }
}
