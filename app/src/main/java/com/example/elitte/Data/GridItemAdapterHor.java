package com.example.elitte.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elitte.R;
import com.example.elitte.entity.GridItem;

import java.util.List;

public class GridItemAdapterHor extends ArrayAdapter<GridItem> {
    public GridItemAdapterHor(Context context, List<GridItem> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item_horizontal, parent, false);
            viewHolder = new GridItemAdapterHor.ViewHolder();
            viewHolder.icon = convertView.findViewById(R.id.item_icon);
            viewHolder.title = convertView.findViewById(R.id.item_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (GridItemAdapterHor.ViewHolder) convertView.getTag();
        }

        GridItem gridItem = getItem(position);
        viewHolder.icon.setImageResource(gridItem.getIconRes());
        viewHolder.title.setText(gridItem.getTitle());

//        convertView.setOnClickListener(v ->
//                Toast.makeText(getContext(), "Clicked: " + gridItem.getTitle(), Toast.LENGTH_SHORT).show()
//        );

        return convertView;
    }

    static class ViewHolder {
        ImageView icon;
        TextView title;
    }
}
