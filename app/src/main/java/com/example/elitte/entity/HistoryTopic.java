package com.example.elitte.entity;

public class HistoryTopic {
    private Topic topic;
    private int point;

    public HistoryTopic(Topic topic, int point) {
        this.topic = topic;
        this.point = point;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Topic getTopic() {
        return topic;
    }

    public int getPoint() {
        return point;
    }
}
