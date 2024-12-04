
package com.example.elitte.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.elitte.R;
import com.example.elitte.entity.HistoryTopic;

import java.util.List;

public class HistoryTopicAdapter extends ArrayAdapter<HistoryTopic> {
    public HistoryTopicAdapter(Context context, List<HistoryTopic> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.history_topic_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.numberTopic = convertView.findViewById(R.id.number_topic);
            viewHolder.point = convertView.findViewById(R.id.point_topic);
            viewHolder.ngayLamBai = convertView.findViewById(R.id.ngayLamBai);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        HistoryTopic historyTopic = getItem(position);
        viewHolder.numberTopic.setText(historyTopic.getTopic().getName());
        viewHolder.point.setText("Điểm : " + historyTopic.getPoint());
        viewHolder.ngayLamBai.setText(historyTopic.getNgayLamBai());
        return convertView;
    }

    static class ViewHolder {
        TextView numberTopic;
        TextView point;
        TextView ngayLamBai;
    }
}
