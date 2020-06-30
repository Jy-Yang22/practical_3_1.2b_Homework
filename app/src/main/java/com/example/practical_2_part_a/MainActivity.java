package com.example.practical_2_part_a;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private Button mCountButton;
    private Button mResetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.show_count);
        mCountButton = findViewById(R.id.button_count);
        mResetButton = findViewById(R.id.button_zero);

    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_LONG);
        toast.show();
    }

    public void countUP(View view) {
        mCount ++;
        if (mShowCount != null){
            mShowCount.setText(String.format(Locale.ENGLISH, "%d", mCount));
        }
        mResetButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        mResetButton.setClickable(true);

        switch (mCount % 2){
            case 0: view.setBackgroundColor(Color.RED);
                break;
            case 1: view.setBackgroundColor(Color.GREEN);
                break;
            default: break;
        }
    }

    public void zero(View view) {
        mCount = 0;
        mShowCount.setText(String.valueOf(mCount));

        view.setClickable(false);
        view.setBackgroundColor(Color.GRAY);
        mCountButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
    }
}