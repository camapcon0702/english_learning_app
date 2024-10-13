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
import com.example.elitte.entity.Clause;
import com.example.elitte.entity.Tense;

import java.util.List;

public class ClauseAdapter extends ArrayAdapter<Clause> {

    private Context context;
    private int resource;
    private List<Clause> arrayTense;

    public ClauseAdapter(@NonNull Context context, int resource, @NonNull List<Clause> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrayTense = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_tense_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txtClauseName = convertView.findViewById(R.id.tense_type);
            viewHolder.txtClauseContent = convertView.findViewById(R.id.tense_type_content);
            viewHolder.txtLearnNow = convertView.findViewById(R.id.learn_now);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Clause clause = arrayTense.get(position);
        viewHolder.txtClauseName.setText(clause.getNameClause());
        viewHolder.txtClauseContent.setText(clause.getContentClause());
        viewHolder.txtLearnNow.setText("Học ngay");
        viewHolder.txtLearnNow.setPaintFlags(viewHolder.txtLearnNow.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        return convertView;
    }

    static class ViewHolder {
        TextView txtClauseName, txtClauseContent, txtLearnNow;
    }
}
