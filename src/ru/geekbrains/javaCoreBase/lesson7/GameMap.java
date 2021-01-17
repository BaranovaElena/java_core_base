package ru.geekbrains.javaCoreBase.lesson7;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {
    public static final int MODE_HA = 0;
    public static final int MODE_HH = 1;

    private GridLayout layout;
    GameMap(){}

    public void startNewGame(int mode, int sizeX, int sizeY, int winLength){
        removeAll();    //удаляем поле предыдущей игры
        createMap(sizeX,sizeY);     // расчертим поле
        updateUI();
    }

    private void createMap(int sizeX, int sizeY){
        setBackground(new Color(180,180,255));

        layout = new GridLayout(sizeY, sizeX);
        setLayout(layout);
        for (int i=0; i<sizeY; i++) {
            for (int j=0; j<sizeX; j++) {
                //add(new JButton());
                JLabel label = new JLabel();
                label.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                add(label);
            }
        }
    }
}
