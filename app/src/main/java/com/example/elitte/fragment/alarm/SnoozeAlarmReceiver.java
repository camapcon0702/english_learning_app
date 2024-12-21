package com.example.elitte.fragment.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SnoozeAlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Hoãn báo thức 10 phút
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent alarmIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);

        long snoozeTime = System.currentTimeMillis() + 10 * 60 * 1000; // Hoãn 10 phút
        alarmManager.set(AlarmManager.RTC_WAKEUP, snoozeTime, pendingIntent);
    }
}