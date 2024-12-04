package com.example.elitte.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ListExamSet implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("typeOfExamSet")
    @Expose
    private Object typeOfExamSet;
    @SerializedName("listUserExamSet")
    @Expose
    private Object listUserExamSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getTypeOfExamSet() {
        return typeOfExamSet;
    }

    public void setTypeOfExamSet(Object typeOfExamSet) {
        this.typeOfExamSet = typeOfExamSet;
    }

    public Object getListUserExamSet() {
        return listUserExamSet;
    }

    public void setListUserExamSet(Object listUserExamSet) {
        this.listUserExamSet = listUserExamSet;
    }
}
