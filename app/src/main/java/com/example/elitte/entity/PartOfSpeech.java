package com.example.elitte.entity;

public class PartOfSpeech {
    private int idPoS;
    private String namePoS;
    private String contentPoS;
    private String learnNow;

    public String getLearnNow() {
        return learnNow;
    }

    public PartOfSpeech(String namePoS, String contentPoS, String learnNow) {
        this.namePoS = namePoS;
        this.contentPoS = contentPoS;
        this.learnNow = learnNow;
    }

    public void setLearnNow(String learnNow) {
        this.learnNow = learnNow;
    }

    public PartOfSpeech(int idPoS, String namePoS, String contentPoS) {
        this.idPoS = idPoS;
        this.namePoS = namePoS;
        this.contentPoS = contentPoS;

    }

    public PartOfSpeech(String namePoS, String contentPoS) {
        this.namePoS = namePoS;
        this.contentPoS = contentPoS;
    }

    public PartOfSpeech() {
    }

    public int getIdPoS() {
        return idPoS;
    }

    public void setIdPoS(int idPoS) {
        this.idPoS = idPoS;
    }

    public String getNamePoS() {
        return namePoS;
    }

    public void setNamePoS(String namePoS) {
        this.namePoS = namePoS;
    }

    public String getContentPoS() {
        return contentPoS;
    }

    public void setContentPoS(String contentPoS) {
        this.contentPoS = contentPoS;
    }
}
