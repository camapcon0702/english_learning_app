package com.example.elitte.entity;

public class Tense {
    private int idTense;
    private String nameTense;
    private String contentTense;
    private String structureTense;
    private String keyUse;
    private String example;
    private String note;
    private String affirmative;
    private String positive;
    private String Question;

    public Tense(int idTense, String nameTense, String contentTense, String structureTense, String keyUse, String example, String note) {
        this.idTense = idTense;
        this.nameTense = nameTense;
        this.contentTense = contentTense;
        this.structureTense = structureTense;
        this.keyUse = keyUse;
        this.example = example;
        this.note = note;
    }

    public Tense() {
    }

    public Tense(int idTense, String nameTense, String contentTense, String structureTense, String keyUse) {
        this.idTense = idTense;
        this.nameTense = nameTense;
        this.contentTense = contentTense;
        this.structureTense = structureTense;
        this.keyUse = keyUse;

    }

    public Tense(String nameTense, String contentTense) {
        this.nameTense = nameTense;
        this.contentTense = contentTense;
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

    public String getContentTense() {
        return contentTense;
    }

    public void setContentTense(String contentTense) {
        this.contentTense = contentTense;
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
