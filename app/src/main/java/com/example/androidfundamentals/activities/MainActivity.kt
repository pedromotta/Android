package com.example.androidfundamentals.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfundamentals.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, MainFragment())
        fragmentTransaction.commit()
    }
}