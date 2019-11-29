package ru.mirea.leskov.mireaproject;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalcFragment extends Fragment {
    private TextView tv;
    private String str1;
    private String str2;
    private String sign;

    public CalcFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calc, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv = (TextView)getView().findViewById(R.id.textView3);

        View.OnClickListener digitButtonOcl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.append(((Button)v).getText());
            }
        };


        View.OnClickListener signButtonOcl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1 = tv.getText().toString();
                tv.setText("");
                sign = ((Button)v).getText().toString();
            }
        };


        Button b1 = (Button)getView().findViewById(R.id.button6);
        Button b2 = (Button)getView().findViewById(R.id.button7);
        Button b3 = (Button)getView().findViewById(R.id.button8);
        Button b4 = (Button)getView().findViewById(R.id.button9);
        Button b5 = (Button)getView().findViewById(R.id.button13);
        Button b6 = (Button)getView().findViewById(R.id.button14);
        Button b7 = (Button)getView().findViewById(R.id.button15);
        Button b8 = (Button)getView().findViewById(R.id.button16);
        Button b9 = (Button)getView().findViewById(R.id.button17);
        Button b0 = (Button)getView().findViewById(R.id.button19);
        Button bminus = (Button)getView().findViewById(R.id.button21);
        Button bplus = (Button)getView().findViewById(R.id.button22);
        Button bmult = (Button)getView().findViewById(R.id.button23);
        Button bdiv = (Button)getView().findViewById(R.id.button24);
        Button exec = (Button)getView().findViewById(R.id.button26);
        Button cancel = (Button)getView().findViewById(R.id.button27);
        b1.setOnClickListener(digitButtonOcl);
        b2.setOnClickListener(digitButtonOcl);
        b3.setOnClickListener(digitButtonOcl);
        b4.setOnClickListener(digitButtonOcl);
        b5.setOnClickListener(digitButtonOcl);
        b6.setOnClickListener(digitButtonOcl);
        b7.setOnClickListener(digitButtonOcl);
        b8.setOnClickListener(digitButtonOcl);
        b9.setOnClickListener(digitButtonOcl);
        b0.setOnClickListener(digitButtonOcl);
        bminus.setOnClickListener(signButtonOcl);
        bplus.setOnClickListener(signButtonOcl);
        bmult.setOnClickListener(signButtonOcl);
        bdiv.setOnClickListener(signButtonOcl);
        exec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str2 = tv.getText().toString();
                float val;
                if (sign.equals("-")) {
                    val = Float.parseFloat(str1) - Float.parseFloat(str2);
                    tv.setText(Float.toString(val));
                }
                else if (sign.equals("+")) {
                    val = Float.parseFloat(str1) + Float.parseFloat(str2);
                    tv.setText(Float.toString(val));
                }
                else if (sign.equals("*")) {
                    val = Float.parseFloat(str1) * Float.parseFloat(str2);
                    tv.setText(Float.toString(val));
                }
                else if (sign.equals("/")) {
                    val = Float.parseFloat(str1) / Float.parseFloat(str2);
                    tv.setText(Float.toString(val));
                }
                str1 = "";
                str2 = "";
                sign="";
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1 = "";
                str2 = "";
                sign = "";
                tv.setText("");
            }
        });


    }



}
