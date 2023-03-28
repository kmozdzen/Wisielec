package com.company.word;

public class Word implements IWord{
    private String word;

    public Word(String word){
        this.word = word.toUpperCase();
    }

    @Override
    public String toString() {
        return word;
    }

    public void setWord(String word){
        this.word = word;
    }

    public String getWord(){
        return word;
    }
}
