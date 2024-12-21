package com.example.elitte.fragment.alarm;

public class Alarm {
    private int id;
    private String time;
    private String title;
    private boolean enabled;

    public Alarm(int id, String title, String time, boolean enabled) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.enabled = enabled;
    }

    public Alarm(int id, String time, boolean enabled) {
        this.id = id;
        this.time = time;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title + ", " + time + ", " + enabled;
    }
}