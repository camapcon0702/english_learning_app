package com.example.elitte.entity;

public class Clause {
    private int idClause;
    private String nameClause;
    private String contentClause;

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
