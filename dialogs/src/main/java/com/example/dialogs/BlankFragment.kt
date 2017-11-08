package com.example.dialogs


import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.widget.Toast
import kotlinx.android.synthetic.main.custom_layout.view.*


/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return when(tag){
            "alert" -> alert()
            "datepicker" -> datePicker()
            "timepicker" -> timePicker()
            else -> custom()
        }
    }

    private fun alert():Dialog{
        return AlertDialog.Builder(activity)
                .setTitle("Title")
                .setIcon(R.drawable.ic_launcher_background)
                .setMessage("Message")
                .setPositiveButton("yes",{dialogInterface, btn -> dialogInterface.dismiss()
                })
                .show()
    }


    private fun datePicker():Dialog{
        return DatePickerDialog(
                activity,
                {
                    _,year,month,date->
                    Toast.makeText(activity,"""$date - ${month+1} - $year""",Toast.LENGTH_SHORT).show()
                },
                2017,0,11
        )
    }

    private fun timePicker():Dialog{
        return TimePickerDialog(
                activity,
                {
                    _,hh,mm ->
                    Toast.makeText(activity,"""$hh : $mm""",Toast.LENGTH_SHORT).show()
                },
                12,10,true
        )
    }

    private fun custom():Dialog{
        val vw=LayoutInflater.from(activity).inflate(R.layout.custom_layout,null,false)
        val txt=vw.txtHeader
        return AlertDialog.Builder(activity).setView(vw).create()
    }


}// Required empty public constructor
