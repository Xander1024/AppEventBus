package com.xu.smart.appeventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

public class MainActivity extends AppCompatActivity {

    private android.widget.Button skipsecondact;
    private android.widget.RelativeLayout activitymain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_main);
        this.activitymain = (RelativeLayout) findViewById(R.id.activity_main);
        this.skipsecondact = (Button) findViewById(R.id.skip_second_act);

        skipsecondact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Main2Activity.class));
            }
        });

    }
    @Subscribe
   public void onEventMainThread(String msg){
       if (msg == null) {
           return;
       }
       skipsecondact.setText(msg);
   }
    @Subscribe
   public void onEventMainThread(MessageEvent msg){
       if (msg == null) {
           return;
       }
       skipsecondact.setText(msg.i+msg.s);
   }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
