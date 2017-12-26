package com.example.myfresco;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 杨洪 on 2017/12/21.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

    }
}
