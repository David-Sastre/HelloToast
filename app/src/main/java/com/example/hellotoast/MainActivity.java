package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.String;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Integer mContador;
    private Button mButtonToast;
    private Button mButtonCount;
    private TextView mShowCount;
    private static final String KEY_INDEX = "Number";
    private int mCurrentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            mCurrentNumber = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        mButtonCount = (Button) findViewById(R.id.button_count);
        mButtonToast = (Button) findViewById(R.id.button_toast);
        mShowCount = (TextView) findViewById(R.id.show_count);

        mContador = 0;

        mButtonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContador++;
                mShowCount.setText(String.valueOf(mContador));
            }
        });
        mButtonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, mShowCount.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("Number", mContador);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        mContador = savedInstanceState.getInt("Number");
        mShowCount.setText(String.valueOf(mContador));
    }
}

