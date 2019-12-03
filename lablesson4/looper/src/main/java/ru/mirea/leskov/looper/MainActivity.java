package ru.mirea.leskov.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private MyLooper myLooper;
    private TextView catv;
    private TextView a4tv;
    private EditText caet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLooper = new MyLooper();
        myLooper.start();
    }

    public class MyLooper extends Thread {
        private int number = 0;
        private int currentAge = 0;
        private int shift = 40;
        private Handler handler;
        @SuppressLint("HandlerLeak")
        @Override
        public void run(){
            Log.d("MyLooper", "run");
            Looper.prepare();
            handler = new Handler(){
                @Override
                public void handleMessage(Message msg){
                    Log.d("MyLooper", number + ":"+ msg.getData().getString("KEY"));
                    currentAge = Integer.parseInt(msg.getData().getString("KEY"));
                    currentAge += shift;
                    a4tv.setText(Integer.toString(currentAge));
                }
            };
            Looper.loop();
        }
    }

    public void onClick(View view) {
        catv = (TextView)findViewById(R.id.textView5);
        a4tv = (TextView)findViewById(R.id.textView3);
        caet = (EditText)findViewById(R.id.editText);
        if (catv.getText().equals("")){
            catv.setText(caet.getText());
        }
        else {
            catv.setText(Integer.toString(Integer.parseInt(catv.getText().toString()) + 40));
        }
        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("KEY", catv.getText().toString());
        msg.setData(bundle);
        if (myLooper != null) {
            myLooper.handler.sendMessage(msg);
        }
    }
}
