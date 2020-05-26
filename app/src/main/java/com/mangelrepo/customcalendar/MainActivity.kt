package com.mangelrepo.customcalendar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import android.widget.TextView
import com.mangelrepo.customcalendar.data.Day

import com.mangelrepo.customcalendar.widget.CustomCalendar

import java.util.Calendar
import java.util.GregorianCalendar


class MainActivity : AppCompatActivity(){
    companion object{
        var TAG = "MainActivity";
    }

    lateinit var customCalendar:CustomCalendar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.elevation = 0f
        window.statusBarColor = resources.getColor(R.color.google_red)
        var relativeLayout = findViewById<ScrollView>(R.id.scrollView)
        var textView = findViewById<TextView>(R.id.tv_date)

        customCalendar = findViewById(R.id.collapsibleCalendarView)
        /*
        collapsibleCalendar.setOnSwipeTouchListener(object:OnSwipeTouchListener(this@MainActivity){
            override fun onSwipeRight() {
                collapsibleCalendar.nextDay()
            }

            override fun onSwipeLeft() {
                collapsibleCalendar.prevDay()
            }

            override fun onSwipeTop() {
                if(collapsibleCalendar.expanded){
                    collapsibleCalendar.collapse(300)
                }
            }

            override fun onSwipeBottom() {
                if(!collapsibleCalendar.expanded){
                    collapsibleCalendar.expand(300)
                }
            }
        });
        */
        //To hide or show expand icon
        customCalendar.setExpandIconVisible(true)
        customCalendar.setTodayIconVisible(true)
        val today = GregorianCalendar()
        customCalendar.addEventTag(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH))
        today.add(Calendar.DATE, 1)
        customCalendar.selectedDay = Day(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH))
        customCalendar.addEventTag(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH), Color.BLUE)
        customCalendar.addEventTag(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH), Color.RED)
        customCalendar.setCalendarListener(object : CustomCalendar.CalendarListener {
            override fun onDayChanged() {

            }

            override fun onClickListener() {
                /*
                if(customCalendar.expanded){
                    customCalendar.collapse(400)
                }
                else{
                    customCalendar.expand(400)
                }

                 */
            }

            override fun onDaySelect() {
                textView.text = customCalendar.selectedDay?.toUnixTime().toString()

            }

            override fun onItemClick(v: View) {
                customCalendar.collapse(400)
            }

            override fun onDataUpdate() {

            }

            override fun onMonthChange() {

            }

            override fun onWeekChange(position: Int) {

            }
        })


    }
}
