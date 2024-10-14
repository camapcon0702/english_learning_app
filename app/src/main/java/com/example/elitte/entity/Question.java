package com.example.elitte.entity;

import java.util.List;

public class Question {
    private int number;
    private String content;
    private List<Answer> answerList;
    private String explain;

    public Question(int number, String content, List<Answer> answerList, String explain) {
        this.number = number;
        this.content = content;
        this.answerList = answerList;
        this.explain = explain;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
