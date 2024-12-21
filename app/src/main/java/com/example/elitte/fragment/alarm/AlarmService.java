package com.example.elitte.fragment.alarm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import com.example.elitte.R;

public class AlarmService extends Service {
    private MediaPlayer mediaPlayer;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this, R.raw.alarm_sound); // Thay alarm_sound bằng tên file âm thanh của bạn
//        mediaPlayer = MediaPlayer.create(this, R.raw.alarm_sound);



        mediaPlayer.start();

        // Tạo thông báo với nút tắt và hoãn

        createNotificationChannel();
        createNotification();

        mediaPlayer.setOnCompletionListener(mp -> {
            // Dừng âm thanh và xóa thông báo khi âm thanh kết thúc
            stopSelf(); // Dừng dịch vụ
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            if (notificationManager != null) {
                notificationManager.cancel(1); // Xóa thông báo
            }
        });

        return START_STICKY;
    }

    private void createNotification() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "alarm_channel")
                .setSmallIcon(R.drawable.ic_alarm) // Thay bằng icon của bạn
                .setContentTitle("Nhắc nhở")
                .setContentText("Elitte nhắc bạn đã đến giờ học bài!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setOngoing(true);

        // Tạo Intent để tắt báo thức
        Intent stopIntent = new Intent(this, StopAlarmReceiver.class);
        PendingIntent stopPendingIntent = PendingIntent.getBroadcast(this, 0, stopIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.addAction(R.drawable.ic_stop, "Tắt", stopPendingIntent);

        // Tạo Intent để hoãn báo thức
//        Intent snoozeIntent = new Intent(this, SnoozeAlarmReceiver.class);
//        PendingIntent snoozePendingIntent = PendingIntent.getBroadcast(this, 1, snoozeIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//        builder.addAction(R.drawable.ic_snooze, "Hoãn", snoozePendingIntent);

        Notification notification = builder.build();
        notificationManager.notify(1, notification);
        startForeground(1, notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private static final String CHANNEL_ID = "alarm_channel";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Alarm Channel",
                    NotificationManager.IMPORTANCE_HIGH
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(serviceChannel);
            }
        }
    }
}