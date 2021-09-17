package com.mi.myactivity;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.FileReader;

public class MyService2 extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyService2(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
