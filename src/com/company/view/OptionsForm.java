package com.company.view;

import com.company.word.Word;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionsForm extends JFrame{
    private JButton addWordButton;
    private JPanel optionPanel;
    private JTextField addWordTextField;
    private JButton deleteWordButton;
    private JComboBox wordsComboBox;
    private static OptionsForm form;

    private String text = "";
    List<Word> wordsList = new ArrayList<Word>();
    private int lastWord = 0;
    private int index;

    String[] availableChars = new String[]{
            "A", "Ą", "B", "C", "Ć", "D", "E", "Ę", "F", "G",
            "H", "I", "J", "K", "L", "Ł", "M", "N", "Ń", "O",
            "Ó", "P", "Q", "R", "S", "Ś", "T", "U", "V", "W",
            "X", "Y", "Z", "Ź", "Ż"
    };


    public OptionsForm(){
        setContentPane(optionPanel);
        setSize(400,400);
        setTitle("OPCJE");
        setLocationRelativeTo(null);

        addWordButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    text = addWordTextField.getText();
                    boolean block = false;
                    if(text.compareTo("") != 0){
                        Word word = new Word(text);

                        List<String> availableCharsList = Arrays.asList(availableChars);
                        for(int i = 0; i < text.length(); i++){
                            if(availableCharsList.contains(String.valueOf(text.charAt(i)).toUpperCase()) == false){
                                JOptionPane.showMessageDialog(null,"Błędne znaki!");
                                block = true;
                                break;
                            }
                        }
                        if(block == false){
                            wordsList.add(word);
                            wordsComboBox.addItem(wordsList.get(lastWord));
                            lastWord += 1;
                            addWordTextField.setText("");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Nie możesz dodać pustego słowa");
                    }
                }
        });

        deleteWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                   index = wordsComboBox.getSelectedIndex();
                   wordsComboBox.removeItemAt(index);
                   wordsList.remove(index);
               } catch (Exception exception){
                   JOptionPane.showMessageDialog(null,"Nie ma słow na liście");
               }
            }
        });

    }
    public String useAddWordButton(String text){
        boolean block = false;
        if(text.compareTo("") != 0){
            Word word = new Word(text);

            List<String> availableCharsList = Arrays.asList(availableChars);
            for(int i = 0; i < text.length(); i++){
                if(availableCharsList.contains(String.valueOf(text.charAt(i)).toUpperCase()) == false){
                    JOptionPane.showMessageDialog(null,"Błędne znaki!");
                    block = true;
                    break;
                }
            }
            if(block == false){
                wordsList.add(word);
                wordsComboBox.addItem(wordsList.get(lastWord));
                lastWord += 1;
                addWordTextField.setText("");
            }
        return word.toString();
        }
        else{
            return "";
        }
    }
}

