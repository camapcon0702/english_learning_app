package com.example.elitte.entity;

public class GridItem {
    private int iconRes;
    private String title;
    private Integer id;

    public GridItem(int iconRes, String title, Integer id) {
        this.iconRes = iconRes;
        this.title = title;
        this.id = id;
    }

    public GridItem(int iconRes, String title) {
        this.iconRes = iconRes;
        this.title = title;

    }

    public int getIconRes() {
        return iconRes;
    }

    public String getTitle() {
        return title;
    }

    public Integer getId() {
        return id;
    }
}