package com.example.pratyushsingh.shareaway;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.i("ffgghh",String.valueOf(remoteMessage.getData()));
        super.onMessageReceived(remoteMessage);
    }

}
