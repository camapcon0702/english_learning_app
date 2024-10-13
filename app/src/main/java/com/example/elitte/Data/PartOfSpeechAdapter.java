package com.example.elitte.Data;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.elitte.R;
import com.example.elitte.entity.PartOfSpeech;

import java.util.ArrayList;
import java.util.List;

public class PartOfSpeechAdapter extends ArrayAdapter<PartOfSpeech> {

    private Context context;
    private int resource;
    private List<PartOfSpeech> arrayPartOfSpeech;

    public PartOfSpeechAdapter(@NonNull Context context, int resource, @NonNull ArrayList<PartOfSpeech> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrayPartOfSpeech = objects;
    }

    public PartOfSpeechAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.part_of_speech_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txtWord_type = (TextView) convertView.findViewById(R.id.word_type);
            viewHolder.txtWord_type_content = (TextView) convertView.findViewById(R.id.word_type_content);
            viewHolder.txtLearn_now = (TextView) convertView.findViewById(R.id.learn_now);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PartOfSpeech partOfSpeech = arrayPartOfSpeech.get(position);
        viewHolder.txtWord_type.setText(partOfSpeech.getNamePoS());
        viewHolder.txtWord_type_content.setText(partOfSpeech.getContentPoS());
        viewHolder.txtLearn_now.setText("Học ngay");
        viewHolder.txtLearn_now.setPaintFlags(viewHolder.txtLearn_now.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        return convertView;
    }

    static class ViewHolder {
        TextView txtWord_type, txtWord_type_content, txtLearn_now;
    }
}
