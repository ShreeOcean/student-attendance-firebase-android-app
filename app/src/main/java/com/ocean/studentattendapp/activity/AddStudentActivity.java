package com.ocean.studentattendapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;

import com.ocean.studentattendapp.R;
import com.ocean.studentattendapp.databinding.ActivityAddStudentBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddStudentActivity extends AppCompatActivity {

    ActivityAddStudentBinding addStudentBinding;
    Calendar myCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addStudentBinding = ActivityAddStudentBinding.inflate(getLayoutInflater());
        setContentView(addStudentBinding.getRoot());



        //image capture code on click imageview
        addStudentBinding.profileImage.setOnClickListener(view -> {

        });

        //date picker code onclick edittext
        addStudentBinding.textFieldBatchJoinDate.setOnClickListener(view -> {

            myCalendar = Calendar.getInstance();
            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabel();
                }
            };

            new DatePickerDialog(this, date, myCalendar.get(Calendar.YEAR),
                                    myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();

        });

    }
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);

        addStudentBinding.textinputEtBatchJoinDate.setText(sdf.format(myCalendar.getTime()));
        //edittext.setText(sdf.format(myCalendar.getTime()));
    }
}