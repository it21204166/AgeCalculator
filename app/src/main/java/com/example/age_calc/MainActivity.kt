package com.example.age_calc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bday_Btn :Button = findViewById(R.id.bday_Btn)



        bday_Btn.setOnClickListener { view ->

            datePicker()
            Toast.makeText(this@MainActivity,
                "Age Calander",Toast.LENGTH_SHORT).show()
             }

        }



}