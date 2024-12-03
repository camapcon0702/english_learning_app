//package com.example.elitte.Data;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.elitte.R;
//import com.example.elitte.entity.GridItem;
//import com.example.elitte.entity.Topic;
//
//import java.util.List;
//
//public class TopicAdapter extends ArrayAdapter<Topic> {
//    public TopicAdapter(Context context, List<Topic> items) {
//        super(context, 0, items);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder viewHolder;
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.topic_item, parent, false);
//            viewHolder = new ViewHolder();
//            viewHolder.title = convertView.findViewById(R.id.topic_item);
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//
//        Topic topic = getItem(position);
//        viewHolder.title.setText("Bộ đề " + topic.getNumberTopic());
//        return convertView;
//    }
//
//    static class ViewHolder {
//        TextView title;
//    }
//}

package com.example.elitte.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elitte.Models.ListExamSet;
import com.example.elitte.R;
import com.example.elitte.entity.GridItem;
import com.example.elitte.entity.Topic;

import java.util.List;

public class TopicAdapter extends ArrayAdapter<ListExamSet> {
    public TopicAdapter(Context context, List<ListExamSet> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.topic_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.title = convertView.findViewById(R.id.topic_item);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ListExamSet topic = getItem(position);
        viewHolder.title.setText(topic.getName());
        return convertView;
    }

    static class ViewHolder {
        TextView title;
    }
}

