package com.example.elitte.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Question implements Parcelable {
    private int number;
    private String content;
    private List<Answer> answerList;
    private String explain;

    public Question(int number, String content, List<Answer> answerList, String explain) {
        this.number = number;
        this.content = content;
        this.answerList = answerList;
        this.explain = explain;
    }

    protected Question(Parcel in) {
        number = in.readInt();
        content = in.readString();
        answerList = in.createTypedArrayList(Answer.CREATOR);
        explain = in.readString();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public int getNumber() {
        return number;
    }

    public String getContent() {
        return content;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public String getExplain() {
        return explain;
    }

    @Override
    public int describeContents() {
        return 0; // Không sử dụng
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(content);
        dest.writeTypedList(answerList);
        dest.writeString(explain);
    }
}
