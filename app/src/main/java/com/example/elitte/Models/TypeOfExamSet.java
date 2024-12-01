package com.example.elitte.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TypeOfExamSet {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nameOfExamSet")
    @Expose
    private String nameOfExamSet;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("listExamSet")
    @Expose
    private List<ListExamSet> listExamSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfExamSet() {
        return nameOfExamSet;
    }

    public void setNameOfExamSet(String nameOfExamSet) {
        this.nameOfExamSet = nameOfExamSet;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ListExamSet> getListExamSet() {
        return listExamSet;
    }

    public void setListExamSet(List<ListExamSet> listExamSet) {
        this.listExamSet = listExamSet;
    }
}
