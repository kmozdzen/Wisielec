package com.company.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuForm extends JFrame{
    private JPanel mainPanel;
    private JButton StartButton;
    private JButton OptionsButton;
    private JLabel imageField;
    private JLabel backgroundField;
    private static MenuForm form;

    public MenuForm(){
        setContentPane(mainPanel);
        setSize(600,600);
        setTitle("MENU");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        ImageIcon image;
        Image ScaleImage;

        String path = System.getProperty("user.dir").replace("\\", "\\\\");
        image = new ImageIcon(path + "\\images\\7.1.png");
        ScaleImage = image.getImage().getScaledInstance(400,450,Image.SCALE_SMOOTH);
        image = new ImageIcon(ScaleImage);
        imageField.setIcon(image);

        final OptionsForm optionsForm = new OptionsForm();

        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GameForm gameForm = new GameForm(optionsForm.wordsList);
                    gameForm.setVisible(true);
                } catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Musisz podać słowa do losowania");
                }
            }
        });


        OptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionsForm.setVisible(true);
            }
        });
    }


    public static void main(String[] args){
        MenuForm menuForm = new MenuForm();
    }
}
