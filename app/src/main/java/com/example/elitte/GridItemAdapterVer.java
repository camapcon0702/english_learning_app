package com.example.elitte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GridItemAdapterVer extends ArrayAdapter<GridItem> {

    public GridItemAdapterVer(Context context, List<GridItem> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item_vertical, parent, false);
            holder = new ViewHolder();
            holder.icon = convertView.findViewById(R.id.item_icon);
            holder.title = convertView.findViewById(R.id.item_text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        GridItem gridItem = getItem(position);
        holder.icon.setImageResource(gridItem.getIconRes());
        holder.title.setText(gridItem.getTitle());

        // Thêm sự kiện nhấn cho mỗi mục
        convertView.setOnClickListener(v ->
                Toast.makeText(getContext(), "Clicked: " + gridItem.getTitle(), Toast.LENGTH_SHORT).show()
        );

        return convertView;
    }

    static class ViewHolder {
        ImageView icon;
        TextView title;
    }
}
