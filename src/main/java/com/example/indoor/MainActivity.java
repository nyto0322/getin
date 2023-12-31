package com.example.indoor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Handler;

import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.os.Handler;

import android.os.Bundle;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;




public class MainActivity extends AppCompatActivity {
    private TextView clockTextView0;
    private TextView clockTextView11;
    private TextView clockTextView12;
    private TextView clockTextView2;
    private Handler handler1 = new Handler();
    private Handler handler2 = new Handler();
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clockTextView0 = findViewById(R.id.text_0);
        clockTextView11 = findViewById(R.id.text_11);
        clockTextView12 = findViewById(R.id.text_12);
        clockTextView2 = findViewById(R.id.text_2);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());
        String currentTime = sdf.format(new Date());
        clockTextView0.setText(currentTime);

        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                update1();
                handler1.postDelayed(this, 1000); // 1 秒钟后再次执行
            }
        }, 100); // 1 秒钟后第一次执行

        handler2.postDelayed(new Runnable() {
        @Override
        public void run() {
            update2();
            handler1.postDelayed(this, 100); // 1 秒钟后再次执行
        }
    }, 100); // 1 秒钟后第一次执行


        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
}
    private void update1() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:", Locale.getDefault());
        String currentTime = sdf.format(new Date());
        clockTextView11.setText(currentTime);
        SimpleDateFormat sdf2 = new SimpleDateFormat("ss.", Locale.getDefault());
        String currentTime2 = sdf2.format(new Date());
        clockTextView12.setText(currentTime2);
    }
    private void update2() {
        clockTextView2.setText(String.valueOf(i++%10));
    }
}