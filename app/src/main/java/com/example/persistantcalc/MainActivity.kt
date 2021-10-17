package com.example.persistantcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var ed1: EditText
    lateinit var ed2: EditText
    lateinit var tv1: TextView
    lateinit var but: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ed1 = findViewById(R.id.ed1)
        ed2 = findViewById(R.id.ed2)
        tv1 = findViewById(R.id.tvres)
        but = findViewById(R.id.but)
        but.setOnClickListener{
            if(ed1.text.isNotEmpty()&&ed1.text.isNotEmpty()){
                tv1.text=((ed1.text.toString().toDouble())*(ed2.text.toString().toFloat())).toString()
            }
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        ed1.setText(savedInstanceState.getString("ed1"))
        ed2.setText(savedInstanceState.getString("ed2"))
        tv1.text=savedInstanceState.getString("tv1")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("ed1",ed1.text.toString())
        outState.putString("ed2",ed2.text.toString())
        outState.putString("tv1",tv1.text.toString())
    }
}