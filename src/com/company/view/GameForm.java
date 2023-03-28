package com.company.view;

import com.company.word.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class GameForm extends JFrame{
    private JPanel gamePanel;
    private JLabel imageField;
    private JButton aButton;
    private JButton ąButton;
    private JTextField GuessField;
    private JButton bButton;
    private JButton cButton;
    private JButton ćButton;
    private JButton dButton;
    private JButton eButton;
    private JButton ęButton;
    private JButton fButton;
    private JButton gButton;
    private JButton hButton;
    private JButton iButton;
    private JButton jButton;
    private JButton kButton;
    private JButton lButton;
    private JButton łButton;
    private JButton mButton;
    private JButton nButton;
    private JButton ńButton;
    private JButton oButton;
    private JButton óButton;
    private JButton pButton;
    private JButton qButton;
    private JButton rButton;
    private JButton sButton;
    private JButton śButton;
    private JButton tButton;
    private JButton uButton;
    private JButton vButton;
    private JButton wButton;
    private JButton xButton;
    private JButton yButton;
    private JButton zButton;
    private JButton źButton;
    private JButton żButton;

    private ImageIcon image;
    private Image ScaleImage;
    private String guess;
    List<String> blind = new ArrayList<String>();
    List<String> imagePath = new ArrayList<String>();
    private StringBuilder text;
    private String sign;
    private int WrongAnswers = 0;
    private int MaxWrongAnswers = 5;

    List<Word> wordsList = new ArrayList<Word>();

    public GameForm(List wordsList){
        this.wordsList = wordsList;

        setContentPane(gamePanel);
        setSize(800,800);
        setTitle("GAME");
        setLocationRelativeTo(null);

        Random random = new Random();
        guess = wordsList.get(random.nextInt(wordsList.size())).toString();
        //System.out.println(guess);

        String path = System.getProperty("user.dir").replace("\\", "\\\\");
        image = new ImageIcon(path + "\\images\\1.1.png");
        ScaleImage = image.getImage().getScaledInstance(400,450,Image.SCALE_SMOOTH);
        image = new ImageIcon(ScaleImage);
        imageField.setIcon(image);
        //imageField.setLocation(0,100);

        for(int i = 0; i < guess.length();i++)
            blind.add("_");

        text = new StringBuilder();

        for(int i =0; i < guess.length(); i++){
            text.append(blind.get(i));
            if( i+1 != guess.length())
                text.append(" ");
        }
        GuessField.setText(String.valueOf(text));

        imagePath.add(path + "\\images\\2.1.png");
        imagePath.add(path + "\\images\\3.1.png");
        imagePath.add(path + "\\images\\4.1.png");
        imagePath.add(path + "\\images\\5.1.png");
        imagePath.add(path + "\\images\\6.1.png");
        imagePath.add(path + "\\images\\7.1.png");

        addSign(aButton, "A");
        addSign(ąButton, "Ą");
        addSign(bButton, "B");
        addSign(cButton, "C");
        addSign(ćButton, "Ć");
        addSign(dButton, "D");
        addSign(eButton, "E");
        addSign(ęButton, "Ę");
        addSign(fButton, "F");
        addSign(gButton, "G");
        addSign(hButton, "H");
        addSign(iButton, "I");
        addSign(jButton, "J");
        addSign(kButton, "K");
        addSign(lButton, "L");
        addSign(łButton, "Ł");
        addSign(mButton, "M");
        addSign(nButton, "N");
        addSign(ńButton, "Ń");
        addSign(oButton, "O");
        addSign(óButton, "Ó");
        addSign(pButton, "P");
        addSign(qButton, "Q");
        addSign(rButton, "R");
        addSign(sButton, "S");
        addSign(śButton, "Ś");
        addSign(tButton, "T");
        addSign(uButton, "U");
        addSign(vButton, "V");
        addSign(wButton, "W");
        addSign(xButton, "X");
        addSign(yButton, "Y");
        addSign(zButton, "Z");
        addSign(źButton, "Ź");
        addSign(żButton, "Ż");


    }

    public void addSign(final JButton button, final String sign){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean wasLetter = false;
                for(int i = 0; i < guess.length(); i++){
                    if(sign.compareTo(Character.toString(guess.charAt(i))) == 0){
                        blind.set(i, sign);
                        wasLetter = true;
                    }

                    if(!blind.contains("_")){
                        WinForm winForm = new WinForm();
                        winForm.setVisible(true);
                        setVisible(false);
                    }

                    if(i+1 == guess.length() && wasLetter == false){
                        image = new ImageIcon(imagePath.get(WrongAnswers));
                        ScaleImage = image.getImage().getScaledInstance(400,450,Image.SCALE_SMOOTH);
                        image = new ImageIcon(ScaleImage);
                        imageField.setIcon(image);

                        if(WrongAnswers++ == MaxWrongAnswers){
                            LoseForm loseForm = new LoseForm();
                            loseForm.setVisible(true);
                            setVisible(false);
                        }
                    }
                }
                text = new StringBuilder();

                for(int i =0; i < guess.length(); i++){
                    text.append(blind.get(i));
                    if( i+1 != guess.length())
                        text.append(" ");
                }
                GuessField.setText(String.valueOf(text));
                button.setEnabled(false);
            }
        });
    }

    public void useButton(String sign){
        boolean wasLetter = false;
        for(int i = 0; i < guess.length(); i++){
            if(sign.compareTo(Character.toString(guess.charAt(i))) == 0){
                blind.set(i, sign);
                wasLetter = true;
            }

            if(!blind.contains("_")){
                WinForm winForm = new WinForm();
                winForm.setVisible(true);
                setVisible(false);
            }

            if(i+1 == guess.length() && wasLetter == false){
                image = new ImageIcon(imagePath.get(WrongAnswers));
                ScaleImage = image.getImage().getScaledInstance(400,450,Image.SCALE_SMOOTH);
                image = new ImageIcon(ScaleImage);
                imageField.setIcon(image);

                if(WrongAnswers++ == MaxWrongAnswers){
                    LoseForm loseForm = new LoseForm();
                    loseForm.setVisible(true);
                    setVisible(false);
                }
            }
        }
        text = new StringBuilder();

        for(int i =0; i < guess.length(); i++){
            text.append(blind.get(i));
            if( i+1 != guess.length())
                text.append(" ");
        }
        GuessField.setText(String.valueOf(text));
    }

    public String getText(){
        return String.valueOf(text);
    }
}
