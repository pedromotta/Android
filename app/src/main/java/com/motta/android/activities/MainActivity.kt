package com.motta.android.activities

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.motta.android.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemReselectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnNavigationItemSelectedListener(this)
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnNavigationItemReselectedListener(this)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, MainFragment())
        fragmentTransaction.commit()
    }

    override fun onNavigationItemReselected(p0: MenuItem) {
        Log.d("EventReselect", p0.itemId.toString())
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        Log.d("EventSelect", p0.toString())
        return true
    }
}