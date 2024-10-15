package com.example.elitte.entity;

public class Tense {
    private int idTense;
    private String nameTense;
    private String description;
    private String structureTense;
    private String keyUse;
    private String example;
    private String note;
    private String affirmative;
    private String negative;
    private String question;
    private String sign;

    public Tense(String nameTense, String affirmative, String negative, String question, String keyUse, String example, String sign) {
        this.nameTense = nameTense;
        this.affirmative = affirmative;
        this.negative = negative;
        this.question = question;
        this.keyUse = keyUse;
        this.example = example;
        this.sign = sign;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAffirmative() {
        return affirmative;
    }

    public void setAffirmative(String affirmative) {
        this.affirmative = affirmative;
    }

    public String getNegative() {
        return negative;
    }

    public void setNegative(String negative) {
        this.negative = negative;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Tense(int idTense, String nameTense, String description, String structureTense, String keyUse, String example, String note) {
        this.idTense = idTense;
        this.nameTense = nameTense;
        this.description = description;
        this.structureTense = structureTense;
        this.keyUse = keyUse;
        this.example = example;
        this.note = note;
    }

    public Tense() {
    }

    public Tense(int idTense, String nameTense, String description, String structureTense, String keyUse) {
        this.idTense = idTense;
        this.nameTense = nameTense;
        this.description = description;
        this.structureTense = structureTense;
        this.keyUse = keyUse;

    }

    public Tense(String nameTense, String description) {
        this.nameTense = nameTense;
        this.description = description;
    }

    public int getIdTense() {
        return idTense;
    }

    public void setIdTense(int idTense) {
        this.idTense = idTense;
    }

    public String getNameTense() {
        return nameTense;
    }

    public void setNameTense(String nameTense) {
        this.nameTense = nameTense;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStructureTense() {
        return structureTense;
    }

    public void setStructureTense(String structureTense) {
        this.structureTense = structureTense;
    }

    public String getKeyUse() {
        return keyUse;
    }

    public void setKeyUse(String keyUse) {
        this.keyUse = keyUse;
    }

}
