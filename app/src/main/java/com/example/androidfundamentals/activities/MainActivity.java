package com.example.androidfundamentals.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.androidfundamentals.R;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startConstraintActivity(View view) {
        Intent transitionIntent = new Intent(this, ConstraintActivity.class);
        startActivity(transitionIntent);
    }

    public void startLinearActivity(View view) {
        Intent transitionIntent = new Intent(this, LinearLayout.class);
        startActivity(transitionIntent);
    }

    public void startRelativeActivity(View view) {
        Intent transitionIntent = new Intent(this, RelativeActivity.class);
        startActivity(transitionIntent);
    }

    public void startScrollingViewActivity(View view) {
        Intent transitionIntent = new Intent(this, ScrollingViewsActivity.class);
        startActivity(transitionIntent);
    }

    public void startAddressActivity(View view) {
        Intent transitionIntent = new Intent(this, AddressActivity.class);
        startActivity(transitionIntent);
    }

}
