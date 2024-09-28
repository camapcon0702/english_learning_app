package com.example.elitte;

public class GridItem {
    private int iconRes;
    private String title;

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
}