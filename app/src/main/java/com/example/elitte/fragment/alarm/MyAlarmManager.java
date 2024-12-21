package com.example.elitte.fragment.alarm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyAlarmManager {
    private AlarmDBHelper dbHelper;
    private Context context;

    public MyAlarmManager(Context context) {
        this.context = context;
        dbHelper = new AlarmDBHelper(context);
    }

    public void addAlarm(Alarm alarm) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", alarm.getTitle());
        values.put("time", alarm.getTime());
        values.put("enabled", alarm.isEnabled() ? 1 : 0);
        db.insert("alarms", null, values);
        db.close();
    }

    public List<Alarm> getAllAlarms() {
        List<Alarm> alarms = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("alarms", new String[]{"id", "title", "time", "enabled"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String time = cursor.getString(2);
            boolean enabled = cursor.getInt(3) == 1;
            alarms.add(new Alarm(id, title, time, enabled));
        }
        cursor.close();
        db.close();
        return alarms;
    }

    public void deleteAlarm(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("alarms", "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void updateEnable(int id, boolean isEnabled) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("enabled", isEnabled ? 1 : 0);  // Cập nhật trạng thái enabled
        int rowsAffected = db.update("alarms", values, "id = ?", new String[]{String.valueOf(id)});
        if (rowsAffected == 0) {
            Log.e("MyAlarmManager", "No rows updated in database for alarm ID: " + id);
        }
        db.close();
    }

    public void toggleAlarmState(Alarm alarm) {
        boolean currentState = alarm.isEnabled();  // Lấy trạng thái hiện tại của alarm
        alarm.setEnabled(!currentState);  // Đảo ngược trạng thái (nếu true -> false, nếu false -> true)

        // Cập nhật lại trạng thái mới vào database
        updateEnable(alarm.getId(), alarm.isEnabled());  // Giả sử Alarm có phương thức getId() để lấy id của báo thức
    }

}