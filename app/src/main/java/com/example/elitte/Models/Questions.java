package com.example.elitte.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Questions {

    @SerializedName("idQuestion")
    @Expose
    private Integer idQuestion;
    @SerializedName("sound")
    @Expose
    private Object sound;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("option1")
    @Expose
    private String option1;
    @SerializedName("option2")
    @Expose
    private String option2;
    @SerializedName("option3")
    @Expose
    private String option3;
    @SerializedName("option4")
    @Expose
    private String option4;
    @SerializedName("correctAnswer")
    @Expose
    private String correctAnswer;
    @SerializedName("explainCorrectAnswer")
    @Expose
    private String explainCorrectAnswer;
    @SerializedName("examSet")
    @Expose
    private ListExamSet examSet;

    @SerializedName("numberQuestion")
    @Expose
    private int numberQuestion;

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Object getSound() {
        return sound;
    }

    public void setSound(Object sound) {
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getExplainCorrectAnswer() {
        return explainCorrectAnswer;
    }

    public void setExplainCorrectAnswer(String explainCorrectAnswer) {
        this.explainCorrectAnswer = explainCorrectAnswer;
    }

    public ListExamSet getListExamSet() {
        return examSet;
    }

    public void setListExamSet(ListExamSet examSet) {
        this.examSet = examSet;
    }

    public ListExamSet getExamSet() {
        return examSet;
    }

    public void setExamSet(ListExamSet examSet) {
        this.examSet = examSet;
    }

    public int getNumberQuestion() {
        return numberQuestion;
    }

    public void setNumberQuestion(int numberQuestion) {
        this.numberQuestion = numberQuestion;
    }
}
