package com.example.elitte.entity;

import java.util.List;

public class Question {
    private int number;
    private String conten;
    private List<Answer> answerList;
    private String explain;

    public Question(int number, String conten, List<Answer> answerList, String explain) {
        this.number = number;
        this.conten = conten;
        this.answerList = answerList;
        this.explain = explain;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getConten() {
        return conten;
    }

    public void setConten(String conten) {
        this.conten = conten;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
