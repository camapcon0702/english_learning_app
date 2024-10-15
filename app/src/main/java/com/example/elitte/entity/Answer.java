package com.example.elitte.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Answer implements Parcelable {
    private String content;
    private boolean isCorrect;

    public Answer(String content, boolean isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }

    protected Answer(Parcel in) {
        content = in.readString();
        isCorrect = in.readByte() != 0; // 0 là false, 1 là true
    }

    public static final Creator<Answer> CREATOR = new Creator<Answer>() {
        @Override
        public Answer createFromParcel(Parcel in) {
            return new Answer(in);
        }

        @Override
        public Answer[] newArray(int size) {
            return new Answer[size];
        }
    };

    public String getContent() {
        return content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    @Override
    public int describeContents() {
        return 0; // Không sử dụng
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(content);
        dest.writeByte((byte) (isCorrect ? 1 : 0)); // Chuyển đổi boolean thành byte
    }
}
