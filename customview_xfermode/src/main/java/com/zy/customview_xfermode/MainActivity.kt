package com.zy.customview_xfermode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.ActionBarContextView

class MainActivity : AppCompatActivity() {
    lateinit var view: ActionBarContextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
