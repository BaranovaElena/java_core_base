package ru.geekbrains.javaCoreBase.lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    private static final int WIN_WIDTH = 300;
    private static final int WIN_HEIGHT = 200;
    private static final int MIN_DIM = 3;
    private static final int MAX_DIM = 10;

    private MainWindow mainWindow;
    private JRadioButton rbtnModeHA;
    private JRadioButton rbtnModeHH;
    private JSlider sliderDimension;
    private JSlider sliderWin;

    Settings(MainWindow mainWindow){
        this.mainWindow = mainWindow;

        setSize(WIN_WIDTH,WIN_HEIGHT);
        setLocation((int)mainWindow.getBounds().getCenterX()-WIN_WIDTH/2,
                    (int)mainWindow.getBounds().getCenterY()-WIN_HEIGHT/2);

        //нужен layout, размещающий элементы друг над другом
        GridLayout layoutColumn = new GridLayout();
        layoutColumn.setColumns(1);
        layoutColumn.setRows(0);
        setLayout(layoutColumn);

        addModesToWindow();
        addDimensionToWindow();
        addWinLengthToWindow();

        // работа с кнопкой
        JButton btnStart = new JButton("Начать игру");
        add(btnStart, BorderLayout.SOUTH);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    startNewGame();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                setVisible(false);
            }
        });


    }

    private void addModesToWindow()
    {
        JLabel lblMode = new JLabel("Выберете режим игры:", SwingConstants.CENTER);
        rbtnModeHA = new JRadioButton("Human vs AI",true);
        rbtnModeHH = new JRadioButton("Human vs Human",false);
        ButtonGroup groupModes = new ButtonGroup();
        groupModes.add(rbtnModeHA);
        groupModes.add(rbtnModeHH);

        add(lblMode);
        add(rbtnModeHA);
        add(rbtnModeHH);
    }

    private void addDimensionToWindow()
    {
        JLabel lbl = new JLabel("Выберете размер поля:", SwingConstants.CENTER);
        sliderDimension = new JSlider(MIN_DIM,MAX_DIM,MAX_DIM);
        JLabel lblDim = new JLabel("Размер поля: "+sliderDimension.getValue());

        sliderDimension.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblDim.setText("Размер поля: "+sliderDimension.getValue());
                sliderWin.setMaximum(sliderDimension.getValue());
            }
        });

        add(lbl);
        add(lblDim);
        add(sliderDimension);
    }

    private void addWinLengthToWindow()
    {
        JLabel lbl = new JLabel("Выберете выигрышную длину:", SwingConstants.CENTER);
        sliderWin = new JSlider(MIN_DIM,sliderDimension.getValue(),MIN_DIM);
        JLabel lblWin = new JLabel("Выигрышная длина: "+sliderWin.getValue());

        sliderWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblWin.setText("Выигрышная длина: "+sliderWin.getValue());
            }
        });

        add(lbl);
        add(lblWin);
        add(sliderWin);
    }

    private void startNewGame() throws Exception {
        int mode;
        if (rbtnModeHA.isSelected())
            mode = GameMap.MODE_HA;
        else if (rbtnModeHH.isSelected())
            mode = GameMap.MODE_HH;
        else
            throw new Exception("Режим игры неопределен");

        int sizeX = sliderDimension.getValue();
        int sizeY = sliderDimension.getValue();

        int winLength = sliderWin.getValue();

        mainWindow.startNewGame(mode, sizeX, sizeY, winLength);
    }
}
