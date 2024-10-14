package com.example.elitte.entity;

public class PartOfSpeech {
    private int idPoS;
    private String namePoS;
    private String contentPoS;
    private String learnNow;
    private String position;
    private String sign;
    private String example;

    public PartOfSpeech(String namePoS, String position, String sign, String example) {
        this.namePoS = namePoS;
        this.position = position;
        this.sign = sign;
        this.example = example;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

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
