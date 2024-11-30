package com.example.elitte.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlashCard {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tuVung")
    @Expose
    private String tuVung;
    @SerializedName("amThanh")
    @Expose
    private String amThanh;
    @SerializedName("phienAm")
    @Expose
    private String phienAm;
    @SerializedName("cachDung")
    @Expose
    private String cachDung;
    @SerializedName("dichNghia")
    @Expose
    private String dichNghia;
    @SerializedName("hinhAnh")
    @Expose
    private String hinhAnh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTuVung() {
        return tuVung;
    }

    public void setTuVung(String tuVung) {
        this.tuVung = tuVung;
    }

    public String getAmThanh() {
        return amThanh;
    }

    public void setAmThanh(String amThanh) {
        this.amThanh = amThanh;
    }

    public String getPhienAm() {
        return phienAm;
    }

    public void setPhienAm(String phienAm) {
        this.phienAm = phienAm;
    }

    public String getCachDung() {
        return cachDung;
    }

    public void setCachDung(String cachDung) {
        this.cachDung = cachDung;
    }

    public String getDichNghia() {
        return dichNghia;
    }

    public void setDichNghia(String dichNghia) {
        this.dichNghia = dichNghia;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
