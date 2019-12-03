package ru.mirea.leskov.diplom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = (TextView)findViewById(R.id.textView);
    }


    public void onClickAsyncTask(View view) {
        MyAsyncTask myAsyncTask = new MyAsyncTask(resultTextView);
        myAsyncTask.execute();
    }

}

class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
    int daysLeft = 561;
    private static final String TAG = MyAsyncTask.class.getSimpleName();
    private WeakReference<TextView> wTextView;
    MyAsyncTask(TextView textView) {
        this.wTextView = new WeakReference<>(textView);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        updateText("Запуск");
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        updateText("" + values[0] + " часов осталось до диплома");
    }
    @Override
    protected Void doInBackground(Void... params) {
        publishProgress(daysLeft * 24);
        return null;
    }
    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
//        updateText("Выполнено");
    }
    private void getTime() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
    }
    private void updateText(String str){
        final TextView textView = wTextView.get();
        if (textView != null) {
            textView.setText(str);
        } else {
            Log.d(TAG, "Что-то пошло не так!");
        }
    }
}
