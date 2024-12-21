package com.example.elitte.fragment.alarm;

import static android.content.Context.ALARM_SERVICE;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;

import com.example.elitte.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalendarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalendarFragment extends Fragment {

    EditText alarmLabel;
    EditText timeHour;
    EditText timeMinute;
    Button setTime;
    Button setAlarm;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    View view;
    private MyAlarmManager alarmManager;
    private ListView listViewAlarms;
    //    private ArrayAdapter<Alarm> adapter;
    private List<Alarm> alarmList;
    private EditText txtTitle;
    private AlarmAdapter alarmAdapter;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalendarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalendarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalendarFragment newInstance(String param1, String param2) {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_calendar, container, false);
        
        addControls();
        addEvents();

        alarmManager = new MyAlarmManager(getContext());
        listViewAlarms = view.findViewById(R.id.listViewAlarms);
        TimePicker timePicker = view.findViewById(R.id.timePicker);
        Button buttonSetAlarm = view.findViewById(R.id.buttonSetAlarm);
        txtTitle = view.findViewById(R.id.title);

        alarmList = new ArrayList<>();

        loadAlarms();


        alarmAdapter = new AlarmAdapter(getContext(), R.layout.item_alarm, alarmList, new AlarmAdapter.OnAlarmActionListener() {
            @Override
            public void onDelete(Alarm alarm) {
                // Xử lý sự kiện xóa báo thức
                alarmList.remove(alarm);  // Xóa báo thức khỏi danh sách
                alarmAdapter.notifyDataSetChanged(); // Cập nhật lại giao diện
                alarmManager.deleteAlarm(alarm.getId()); // Xóa báo thức khỏi cơ sở dữ liệu
                loadAlarms();
            }

            @Override
            public void onToggle(Alarm alarm, boolean isEnabled) {
                // Cập nhật trạng thái bật/tắt báo thức
                alarm.setEnabled(isEnabled);
//                alarmAdapter.notifyDataSetChanged();
//                alarmManager.toggleAlarmState(alarm); // Cập nhật trạng thái vào database
                loadAlarms();
            }
        });

//        alarmAdapter = new AlarmAdapter(this, R.layout.activity_main, alarmList);

        listViewAlarms.setAdapter(alarmAdapter);

        // Tải danh sách báo thức từ cơ sở dữ liệu
//        loadAlarms();

        // Thiết lập sự kiện cho nút Đặt báo thức
        buttonSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int hour = timePicker.getCurrentHour();
                int hour = timePicker.getHour();
//                int minute = timePicker.getCurrentMinute();
                int minute = timePicker.getMinute();
                String title = txtTitle.getText().toString();
                String time = String.format("%02d:%02d", hour, minute);

                // Tạo và thêm báo thức
                Alarm alarm = new Alarm(0, title, time, true);
                alarmManager.addAlarm(alarm);
                alarmList.add(alarm);
                alarmAdapter.notifyDataSetChanged();

                // Đặt báo thức
                setAlarm(time);
            }
        });
        return view;
    }

    private void loadAlarms() {
        alarmList.clear();
        alarmList.addAll(alarmManager.getAllAlarms());
//        alarmAdapter.notifyDataSetChanged();
    }

    private void addEvents() {
    }

    private void addControls() {
        
    }


    private void setAlarm(String time) {
        AlarmManager alarmManager = (AlarmManager) requireContext().getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(getContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Chuyển đổi thời gian từ chuỗi sang milliseconds
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        // Nếu thời gian đã qua, đặt báo thức cho ngày hôm sau
        if (calendar.getTimeInMillis() < System.currentTimeMillis()) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }

}