package ru.mirea.leskov.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[] pairs = {6, 2, 0, 2, 2, 2, 0, 4, 0, 2, 4, 2, 2, 0, 2, 2, 4, 4, 2, 2, 0, 2, 0, 2, 4, 2, 2, 0};
    TextView tv;
    int av = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.textView2);
    }

    public class MyThread extends Thread {
        private final String TAG = MyThread.class.getSimpleName();
        public void run() {
            av = 0;
            for (int pair : pairs) {
                av += pair;
            }
            av = av / pairs.length;
        }
    }
    public class MyRunnable implements Runnable {
        private final String TAG = MyRunnable.class.getSimpleName();
        private String goal;
        public MyRunnable(String goal) {
            this.goal=goal;
        }
        @Override
        public void run() {
            Log.d(TAG, " Mой поток запущен:" + goal);
        }
    }

    public void onBtnClick(View view) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.join();
        tv.setText(Integer.toString(av));
    }

    /*public void onBtnClick(View view) {
        MyThread thr = new MyThread();
        thr.start();
        tv.setText(av);
    }

    public class MyThread extends Thread {

        public void run() {
            av = 0;
            for (int i = 0; i < pairs.length; i++){
                av += pairs[i];
            }
            av = av / pairs.length;
//            tv.setText("aye");
        }
    }*/

}
