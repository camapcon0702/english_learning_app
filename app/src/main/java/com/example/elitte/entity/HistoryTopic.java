package com.example.elitte.entity;

import com.example.elitte.Models.ListExamSet;

public class HistoryTopic {
    private ListExamSet topic;
    private int point;
    private String ngayLamBai;

    public HistoryTopic(ListExamSet topic, int point, String ngayLamBai) {
        this.topic = topic;
        this.point = point;
        this.ngayLamBai = ngayLamBai;
    }

    public void setTopic(ListExamSet topic) {
        this.topic = topic;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setNgayLamBai(String ngayLamBai) {
        this.ngayLamBai = ngayLamBai;
    }

    public ListExamSet getTopic() {
        return topic;
    }

    public int getPoint() {
        return point;
    }

    public String getNgayLamBai() {
        return ngayLamBai;
    }
}

