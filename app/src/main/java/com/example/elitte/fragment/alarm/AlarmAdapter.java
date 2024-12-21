package com.example.elitte.fragment.alarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.elitte.R;

import java.util.List;

public class AlarmAdapter extends ArrayAdapter<Alarm> {

    private final Context context;
    private final List<Alarm> alarmList;
    private final OnAlarmActionListener listener;
    private final int resource;
    private MyAlarmManager alarmManager;


    // Interface để xử lý sự kiện
    public interface OnAlarmActionListener {
        void onDelete(Alarm alarm);
        void onToggle(Alarm alarm, boolean isEnabled);
    }

    public AlarmAdapter(Context context, int resource, @NonNull List<Alarm> alarmList, OnAlarmActionListener listener) {
        super(context, resource, alarmList);
        this.context = context;
        this.alarmList = alarmList;
        this.resource = resource;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return alarmList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            // Inflate layout item
            convertView = LayoutInflater.from(context).inflate(R.layout.item_alarm, parent, false);
            holder = new ViewHolder();
            holder.tvTime = convertView.findViewById(R.id.tvTime);
            holder.tvTitle = convertView.findViewById(R.id.tvTitle);
            holder.switchEnabled = convertView.findViewById(R.id.switchEnabled);
            holder.btnDelete = convertView.findViewById(R.id.btnDelete);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Lấy dữ liệu cho item
        Alarm alarm = alarmList.get(position);

        holder.tvTime.setText(alarm.getTime());
        holder.tvTitle.setText(alarm.getTitle());
        holder.switchEnabled.setChecked(alarm.isEnabled());


        holder.switchEnabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Gọi phương thức onToggle trong MainActivity để xử lý bật/tắt báo thức
                if (listener != null) {
                    // Cập nhật trạng thái bật/tắt chỉ cho báo thức đã thay đổi
//                    listener.onToggle(alarm, isChecked);
                    Alarm newAlarm = new Alarm(alarm.getId(), alarm.getTitle(), alarm.getTime(), !alarm.isEnabled());
                    alarmList.set(position, alarm);
                }
            }
        });

        // Bắt sự kiện xóa báo thức
        holder.btnDelete.setOnClickListener(v -> {
            alarmList.remove(alarm); // Xóa báo thức khỏi danh sách
            notifyDataSetChanged(); // Cập nhật giao diện
            if (listener != null) {
                listener.onDelete(alarm); // Xóa báo thức khỏi cơ sở dữ liệu
            }
        });

        return convertView;
    }

    // ViewHolder để tái sử dụng các view
    private static class ViewHolder {
        TextView tvTime, tvTitle;
        Switch switchEnabled;
        Button btnDelete;
    }
}