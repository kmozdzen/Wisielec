package com.company.view;

import javax.swing.*;
import java.awt.*;

public class WinForm extends JFrame {
    private JPanel winPanel;
    private JLabel winImageField;

    private ImageIcon image;
    private Image ScaleImage;

    public WinForm(){
        setContentPane(winPanel);
        setSize(800,800);
        setTitle("GAME");
        setLocationRelativeTo(null);

        String path = System.getProperty("user.dir").replace("\\", "\\\\");
        image = new ImageIcon(path + "\\images\\win.1.png");
        ScaleImage = image.getImage().getScaledInstance(400,450, Image.SCALE_SMOOTH);
        image = new ImageIcon(ScaleImage);
        winImageField.setIcon(image);
    }
}
