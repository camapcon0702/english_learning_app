package com.example.elitte.entity;

public class Answer {
    private String conten;
    private boolean isCorrect;

    public Answer(String conten, boolean isCorrect) {
        this.conten = conten;
        this.isCorrect = isCorrect;
    }

    public String getConten() {
        return conten;
    }

    public void setConten(String conten) {
        this.conten = conten;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
