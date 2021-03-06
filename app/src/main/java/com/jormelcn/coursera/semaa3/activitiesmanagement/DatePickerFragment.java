package com.jormelcn.coursera.semaa3.activitiesmanagement;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.widget.DatePicker;
import android.view.View;

import java.util.Calendar;

/**
 * Created by jormelcn on 22/05/16.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {


    static MainActivity root;

    public static void setActivity(MainActivity _root){
        root = _root;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day){
        TextInputEditText fechaView = (TextInputEditText) root.findViewById(R.id.tiFecha);
        fechaView.setText(day + "/" + month + "/" + year);
    }
}
