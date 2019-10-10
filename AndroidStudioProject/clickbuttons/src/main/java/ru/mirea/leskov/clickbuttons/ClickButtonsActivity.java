package ru.mirea.leskov.clickbuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickButtonsActivity extends AppCompatActivity {

    TextView tvOut;
    Button btnOK;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_buttons);

        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOK = (Button) findViewById(R.id.btnOK);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        View.OnClickListener oclBtnOK = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOut.setText(("Нажата кнопка OK"));
            }
        };

        /*View.OnClickListener oclBtnCancel = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOut.setText("Нажата кнопка Cancel");
            }
        };*/

        btnOK.setOnClickListener(oclBtnOK);
        //btnCancel.setOnClickListener(oclBtnCancel);
    }


    public void onBtnCancelClick(View view) {
        tvOut.setText("Нажато кнопка Cancel");
    }
}
