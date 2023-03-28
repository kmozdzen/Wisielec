package com.company.view;

import javax.swing.*;
import java.awt.*;

public class LoseForm extends JFrame {
    private JLabel loseImageField;
    private JPanel losePanel;

    private ImageIcon image;
    private Image ScaleImage;

    public LoseForm(){
        setContentPane(losePanel);
        setSize(800,800);
        setTitle("GAME");
        setLocationRelativeTo(null);

        String path = System.getProperty("user.dir").replace("\\", "\\\\");
        image = new ImageIcon(path + "\\images\\8.1.png");
        ScaleImage = image.getImage().getScaledInstance(400,450, Image.SCALE_SMOOTH);
        image = new ImageIcon(ScaleImage);
        loseImageField.setIcon(image);
    }
}
