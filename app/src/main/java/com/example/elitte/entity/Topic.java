package com.example.elitte.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Parcelable {
    private int numberTopic;
    private List<Question> listQuestion;

    public Topic(int numberTopic, List<Question> listQuestion) {
        this.numberTopic = numberTopic;
        this.listQuestion = listQuestion;
    }

    protected Topic(Parcel in) {
        numberTopic = in.readInt();
        listQuestion = in.createTypedArrayList(Question.CREATOR);
    }

    public static final Creator<Topic> CREATOR = new Creator<Topic>() {
        @Override
        public Topic createFromParcel(Parcel in) {
            return new Topic(in);
        }

        @Override
        public Topic[] newArray(int size) {
            return new Topic[size];
        }
    };

    public int getNumberTopic() {
        return numberTopic;
    }

    public List<Question> getListQuestion() {
        return listQuestion;
    }

    @Override
    public int describeContents() {
        return 0; // Không sử dụng
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(numberTopic);
        dest.writeTypedList(listQuestion);
    }
}
