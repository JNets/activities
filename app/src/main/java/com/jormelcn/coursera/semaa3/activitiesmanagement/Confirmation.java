package com.jormelcn.coursera.semaa3.activitiesmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Confirmation extends AppCompatActivity {

    private String nameStr;
    private String dateStr;
    private String telStr;
    private String mailStr;
    private String descStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        TextView name = (TextView) findViewById(R.id.tvName);
        TextView date = (TextView) findViewById(R.id.tvFecha);
        TextView tel = (TextView) findViewById(R.id.tvTel);
        TextView email = (TextView) findViewById(R.id.tvEmail);
        TextView desc = (TextView) findViewById(R.id.tvDescripcion);

        Bundle extras = getIntent().getExtras();
        nameStr = extras.getString("name");
        dateStr = extras.getString("date");
        telStr = extras.getString("tel");
        mailStr = extras.getString("email");
        descStr = extras.getString("description");

        name.setText(nameStr);
        date.setText( "Fecha de Nacimiento: " + dateStr);
        tel.setText("Telefono: " + telStr);
        email.setText("Email: " + mailStr);
        desc.setText(descStr);
    }

    public void editar(View v) {
        Intent intent = new Intent(Confirmation.this, MainActivity.class);
        intent.putExtra("name", nameStr);
        intent.putExtra("date", dateStr);
        intent.putExtra("tel", telStr);
        intent.putExtra("email", mailStr);
        intent.putExtra("description", descStr);
        startActivity(intent);
    }

}
