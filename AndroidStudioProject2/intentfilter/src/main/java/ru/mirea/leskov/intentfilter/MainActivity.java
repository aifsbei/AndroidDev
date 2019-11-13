package ru.mirea.leskov.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickOpenWebBrowser(View view) {
        Uri address = Uri.parse("https://mirea.ru/");
        Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);

        if (openLinkIntent.resolveActivity(getPackageManager())!= null)
            startActivity(openLinkIntent);
        else
            Log.d("Intent", "проблема с намерением!");
    }
}
