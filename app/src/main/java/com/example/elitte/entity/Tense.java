package com.example.elitte.entity;

public class Tense {
    private int idTense;
    private String nameTense;
    private String contentTense;
    private String structTense;
    private String signTense;

    public Tense() {
    }

    public Tense(int idTense, String nameTense, String contentTense, String structTense, String signTense) {
        this.idTense = idTense;
        this.nameTense = nameTense;
        this.contentTense = contentTense;
        this.structTense = structTense;
        this.signTense = signTense;
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

    public String getStructTense() {
        return structTense;
    }

    public void setStructTense(String structTense) {
        this.structTense = structTense;
    }

    public String getSignTense() {
        return signTense;
    }

    public void setSignTense(String signTense) {
        this.signTense = signTense;
    }
}
