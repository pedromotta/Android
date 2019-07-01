package com.motta.android.activities

import android.content.Intent
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.motta.android.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        constraintButton.setOnClickListener { startAddressActivity() }
    }

    fun startConstraintActivity() {
        val transitionIntent = Intent(activity, ConstraintActivity::class.java)
        startActivity(transitionIntent)
    }

    fun startLinearActivity() {
        val transitionIntent = Intent(activity, LinearLayout::class.java)
        startActivity(transitionIntent)
    }

    fun startRelativeActivity() {
        val transitionIntent = Intent(activity, RelativeActivity::class.java)
        startActivity(transitionIntent)
    }

    fun startScrollingViewActivity() {
        val transitionIntent = Intent(activity, ScrollingViewsActivity::class.java)
        startActivity(transitionIntent)
    }

    private fun startAddressActivity() {
        val transitionIntent = Intent(activity, AddressActivity::class.java)
        startActivity(transitionIntent)
    }

}
