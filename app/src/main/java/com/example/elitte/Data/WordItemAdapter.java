package com.example.elitte.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elitte.R;
import com.example.elitte.entity.WordItem;

import java.util.List;

public class WordItemAdapter extends ArrayAdapter<WordItem> {
    public WordItemAdapter(Context context, List<WordItem> items) {
        super(context,0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.word_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.icon = convertView.findViewById(R.id.image);
            viewHolder.word = convertView.findViewById(R.id.word);
            viewHolder.definition = convertView.findViewById(R.id.definition);
            viewHolder.example = convertView.findViewById(R.id.example);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        WordItem wordItem = getItem(position);
        viewHolder.icon.setImageResource(wordItem.getIconRes());
        viewHolder.word.setText(wordItem.getWord());
        viewHolder.definition.setText(wordItem.getDefinition());
        viewHolder.example.setText(wordItem.getExample());



        return convertView;
    }

    static class ViewHolder{
        ImageView icon;
        TextView word;
        TextView definition;
        TextView example;
    }
}
