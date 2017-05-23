package com.xu.smart.appeventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import de.greenrobot.event.EventBus;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().post(new MessageEvent(2,"ddddd"));
    }
}
