package com.jormelcn.coursera.semaa3.activitiesmanagement;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText nameView = (TextInputEditText) findViewById(R.id.tiName);
        TextInputEditText fechaView = (TextInputEditText) findViewById(R.id.tiFecha);
        TextInputEditText telView = (TextInputEditText) findViewById(R.id.tiTel);
        TextInputEditText emailView = (TextInputEditText) findViewById(R.id.tiEmail);
        TextInputEditText descriptionView = (TextInputEditText) findViewById(R.id.tiDescription);

        try {

            Bundle extras = getIntent().getExtras();
            String nameStr = extras.getString("name");
            String dateStr = extras.getString("date");
            String telStr = extras.getString("tel");
            String mailStr = extras.getString("email");
            String descStr = extras.getString("description");

            nameView.setText(nameStr);
            fechaView.setText(dateStr);
            telView.setText(telStr);
            emailView.setText(mailStr);
            descriptionView.setText(descStr);
        }
        catch(Exception e){

        }

    }

    public void showDatePicker(View v) {

        DatePickerFragment newFragment = new DatePickerFragment();
        DatePickerFragment.setActivity(this);
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void nextActivity(View v){
        TextInputEditText nameView = (TextInputEditText) findViewById(R.id.tiName);
        TextInputEditText fechaView = (TextInputEditText) findViewById(R.id.tiFecha);
        TextInputEditText telView = (TextInputEditText) findViewById(R.id.tiTel);
        TextInputEditText emailView = (TextInputEditText) findViewById(R.id.tiEmail);
        TextInputEditText descriptionView = (TextInputEditText) findViewById(R.id.tiDescription);

        Intent intent = new Intent(MainActivity.this, Confirmation.class);
        intent.putExtra("name", nameView.getText().toString());
        intent.putExtra("date", fechaView.getText().toString());
        intent.putExtra("tel", telView.getText().toString());
        intent.putExtra("email", emailView.getText().toString());
        intent.putExtra("description", descriptionView.getText().toString());
        startActivity(intent);
    }

}
