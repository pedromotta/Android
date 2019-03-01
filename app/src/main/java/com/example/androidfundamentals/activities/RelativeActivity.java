package com.example.androidfundamentals.activities;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidfundamentals.R;

public class RelativeActivity extends AppCompatActivity {

    private TextView textCounter;
    private Integer counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        textCounter = findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        Button button = (Button) view;
        ++counter;
        updateTextCounter();

        if (counter%2 == 0) {
            button.setBackgroundColor(Color.RED);
        } else {
            button.setBackgroundColor(Color.BLUE);
        }
    }

    public void backToZero(View view) {
        counter = 0;
        updateTextCounter();
    }

    private void updateTextCounter() {
        textCounter.setText(counter.toString());
    }
}
