package com.company.view;

import com.company.word.Word;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsFormTest {
    public static Collection<Object[]> optionsFormTest() {
        return Arrays.asList(new Object[][] {
                { "koszulka", "KOSZULKA"},
                { "SPODNIE", "SPODNIE"},
                { "CzApkA", "CZAPKA"},
                { "Bl/*za",  ""},
                { "bu12ty9", ""}
        });
    }
    @ParameterizedTest
    @MethodSource("optionsFormTest")
    void test(String operation, String result) {
        OptionsForm optionsForm = new OptionsForm();
        String text =  optionsForm.useAddWordButton(result);
        assertEquals(result, text);
    }
}