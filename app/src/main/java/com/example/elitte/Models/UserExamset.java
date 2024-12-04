package com.example.elitte.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserExamset {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user")
    @Expose
    private UserResponse user;
    @SerializedName("examSet")
    @Expose
    private ListExamSet examSet;
    @SerializedName("diem")
    @Expose
    private Integer diem;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public ListExamSet getExamSet() {
        return examSet;
    }

    public void setExamSet(ListExamSet examSet) {
        this.examSet = examSet;
    }

    public Integer getDiem() {
        return diem;
    }

    public void setDiem(Integer diem) {
        this.diem = diem;
    }

    public String getCreatedAt() {
        return createdAt;

    }

}
