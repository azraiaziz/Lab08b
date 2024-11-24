package com.example.lab08b

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab08b.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val pizzaSize = arrayListOf("Small", "Medium", "Large", "Extra Large")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.dateButton.setOnClickListener {
            //dapatkan tarikh hari ini
            val c = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)
            val myDatePicker = DatePickerDialog(this,
                android.R.style.ThemeOverlay_Material_Dialog,
                //listener - bila date dipilih
                //i3 - day, i2, month, i - year
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    // letakkan tarikh yang dipilih pada dateTextView
                    binding.dateTextView.text = "$i3 / ${i2+1} / $i"
                },year, month, day)//default date untuk diset pada datepicker bila ia dibuka
            myDatePicker.show()
            }

        //timeButton

        binding.timeButton.setOnClickListener {
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)
            val myTimePicker = TimePickerDialog(this,
                TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                    //$i = jam
                    //$i2 = menit
                    binding.timeTextView.text = "$i : $i2"
                    },hour, minute, false)
            myTimePicker.show()
        }

        binding.seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            //bila seekbar diubah
            //code ini akan dipanggil
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                //update nilai sizeTextView dengan nilai Small, Medium atau large
                //pw = position user dari seekbar
                binding.sizeTextView.text = pizzaSize[p1]
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                print("Start tracking")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                print("Stop tracking")
            }

        })

        binding.scheduleBtn.setOnClickListener {

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name",binding.nameEditText.text.toString())
            intent.putExtra("phone",binding.phoneEditText.text.toString())
            intent.putExtra("size",binding.sizeTextView.text.toString())
            intent.putExtra("date",binding.dateTextView.text.toString())
            intent.putExtra("time",binding.timeTextView.text.toString())
            //above is to send data to the next activity

            startActivity(intent)
        }
    }

}