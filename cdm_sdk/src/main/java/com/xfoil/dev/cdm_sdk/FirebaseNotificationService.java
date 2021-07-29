package com.xfoil.dev.cdm_sdk;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.security.cert.CertPathBuilder;

public class FirebaseNotificationService extends FirebaseMessagingService {

    private final String TAG = "FirebaseNotificationSer";


    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {

        if (remoteMessage != null && remoteMessage.getNotification() != null) {
            Log.e(TAG, "qq onMessageReceivedNotification: " + remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
        }

        if (remoteMessage != null && remoteMessage.getData() != null) {
            Log.e(TAG, "qq onMessageReceivedData: " + remoteMessage.getData());
        }

    }

    @Override
    public void onNewToken(@NonNull String s) {
        Log.e(TAG, "qq onNewToken: " + s);
    }

    private void sendNotification(String messageTitle, String messageBody) {
        String GROUP_KEY_SOUK = "com.xfoil.dev.cdm_sdk";

        String channelId = "com.xfoil.dev.cdm_sdk";
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, channelId)
                .setContentTitle(messageTitle)
                .setContentText(messageBody)
                .setSmallIcon(R.drawable.ic_notification)
                .setAutoCancel(true)
                .setGroup(GROUP_KEY_SOUK)
                .setSound(defaultSoundUri);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "cdm-sdk",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify((int) System.currentTimeMillis()/* ID of notification */, notificationBuilder.build());
    }
}
