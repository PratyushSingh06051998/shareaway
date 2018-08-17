package com.example.pratyushsingh.shareaway;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    String TOKEN="";

    @Override
    public void onTokenRefresh() {
        TOKEN = FirebaseInstanceId.getInstance().getToken();
        Log.i("aslkasl",String .valueOf(TOKEN));
        super.onTokenRefresh();
    }


}
