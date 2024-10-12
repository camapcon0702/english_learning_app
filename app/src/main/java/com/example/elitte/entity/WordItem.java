package com.example.elitte.entity;

public class WordItem {
    private int iconRes;
    private String word;
    private String definition;
    private String example;

    public WordItem() {

    }

    public WordItem(int iconRes, String word, String definition, String example) {
        this.iconRes = iconRes;
        this.word = word;
        this.definition = definition;
        this.example = example;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public int getIconRes() {
        return iconRes;
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

    public String getExample() {
        return example;
    }
}