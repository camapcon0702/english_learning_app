package com.example.elitte.entity;

public class Clause {
    private int idClause;
    private String nameClause;
    private String contentClause;

    public Clause(String nameClause, String structure, String keyUse, String example) {
        this.nameClause = nameClause;
        this.structure = structure;
        this.keyUse = keyUse;
        this.example = example;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getKeyUse() {
        return keyUse;
    }

    public void setKeyUse(String keyUse) {
        this.keyUse = keyUse;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    private String structure;
    private String keyUse;
    private String example;

    public Clause() {
    }

    public Clause(int idClause, String nameClause, String contentClause) {
        this.idClause = idClause;
        this.nameClause = nameClause;
        this.contentClause = contentClause;
    }

    public Clause(String nameClause, String contentClause) {
        this.nameClause = nameClause;
        this.contentClause = contentClause;
    }

    public int getIdClause() {
        return idClause;
    }

    public void setIdClause(int idClause) {
        this.idClause = idClause;
    }

    public String getNameClause() {
        return nameClause;
    }

    public void setNameClause(String nameClause) {
        this.nameClause = nameClause;
    }

    public String getContentClause() {
        return contentClause;
    }

    public void setContentClause(String contentClause) {
        this.contentClause = contentClause;
    }
}
