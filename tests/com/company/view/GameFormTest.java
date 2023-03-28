package com.company.view;

import com.company.word.Word;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameFormTest {
    public static Collection<Object[]> gameFormExamples() {
        return Arrays.asList(new Object[][] {
                { "_ _ _ _ _ _", "A", "_ A _ _ _ _"},
                { "_ A _ _ _ _", "O", "_ A _ _ _ O"},
                { "_ A _ _ _ O", "D", "_ A _ _ _ O"},
                { "J A _ _ K O", "Ł", "J A _ Ł K O"},
                { "J A B Ł _ O", "K", "J A B Ł K O"}
        });
    }
    @ParameterizedTest
    @MethodSource("gameFormExamples")
    void test(String operation, String sign, String result) {
        OptionsForm optionsForm = new OptionsForm();

        optionsForm.wordsList.add(new Word("JABŁKO"));

        GameForm gameForm = new GameForm(optionsForm.wordsList);

        List<String> blind = new ArrayList<String>();
        for(int i = 0; i < operation.length(); i+=2){
            blind.add(String.valueOf(operation.charAt(i)));
        }

        gameForm.blind = blind;
        gameForm.useButton(sign);
        String text = gameForm.getText();

        assertEquals(result, text);
    }
}