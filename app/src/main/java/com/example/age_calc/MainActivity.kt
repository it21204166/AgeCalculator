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

            datePicker(view)
            Toast.makeText(this@MainActivity,
                "Age Calander",Toast.LENGTH_SHORT).show()
             }

        }

    fun datePicker(view: View){

        val calender = Calendar.getInstance()
        val Year = calender.get(Calendar.YEAR)
        val Month = calender.get(Calendar.MONTH)
        val DayOfMonth = calender.get(Calendar.DAY_OF_MONTH)

        val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            Toast.makeText(this,"$DayOfMonth/${Month+1}/$Year",Toast.LENGTH_SHORT).show()

            val selectedDate = "$dayOfMonth/${month+1}/$year"
            val bday_date_TV:TextView = findViewById(R.id.bday_date_TV)
            bday_date_TV.text = selectedDate

            val simpleDate =SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val date=simpleDate.parse(selectedDate)

            val second = date!!.time/1000

            val todayInSecond = simpleDate.parse(simpleDate.format(System.currentTimeMillis()))!!.time/1000

            val trueSecond = todayInSecond - second

            var inSecondTV:TextView=findViewById(R.id.second_TV)
            inSecondTV.text= "$trueSecond S"

            var inMinute:TextView = findViewById(R.id.minute_TV)
            inMinute.text="${trueSecond/60} M"

            var inhour:TextView = findViewById(R.id.hour_TV)
            inhour.text="${trueSecond/3600} H"

            var inDay:TextView = findViewById(R.id.days_TV)
            inDay.text="${trueSecond/86400} D"



        },Year,Month,DayOfMonth)

        dpd.datePicker.setMaxDate(Date().time-86400000)
        dpd.show()



    }

}