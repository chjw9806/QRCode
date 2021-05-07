package com.example.qrcode;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;


public class KakaoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        KakaoSdk.init(this,"6c135f6f3f4dc1ea009c09fadb0a9ef4");
    }
}
