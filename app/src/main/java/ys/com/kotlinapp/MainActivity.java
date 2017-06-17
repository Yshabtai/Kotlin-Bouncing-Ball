package ys.com.kotlinapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread animationThread = new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   long startTime, endTime;
                   while(true) {
                       startTime = System.currentTimeMillis();
                       ((BallView) findViewById(R.id.ball)).moveBall();
                       findViewById(R.id.ball).postInvalidate();
                       endTime = System.currentTimeMillis();
                       Thread.sleep(16 - (endTime - startTime));
                   }
               } catch(InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });

        animationThread.start();
    }
}

