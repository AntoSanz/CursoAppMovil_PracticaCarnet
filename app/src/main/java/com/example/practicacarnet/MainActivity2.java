package com.example.practicacarnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView lbText;

        Intent i = getIntent();

        dataValues data = (dataValues) i.getSerializableExtra("data");

        String cdataPartner = convertBooleanToText(data.isPartner());
        String cdataAge = convertBooleanToText(data.isAge());
        String cdataEsp = convertBooleanToText(data.isEsp());

        lbText = findViewById(R.id.lbText);
        lbText.setText(Html.fromHtml(
                "Nombre: " + data.getName() + " " + data.getLastName1() + " " + data.getLastName2() + "<br />"
                        + "<strong>Telefono: </strong>" + data.getPhone() + "<br />"
                        + "<strong>Mail: </strong>" + data.getMail() + "<br />"
                        + "<strong>Socio: </strong>" + cdataPartner + "<br />"
                        + "<strong>Mayor de edad: </strong>" + cdataAge + "<br />"
                        + "<strong>Extrangero: </strong>" + cdataEsp + "<br />"
        ));
    }

    public String convertBooleanToText(boolean data) {
        if (data == true) return "Si";
        else return "No";
    }
}