package com.example.practicacarnet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.Serializable;

class dataValues implements Serializable {
    private String Name;
    private String LastName1;
    private String LastName2;
    private String Phone;
    private String Mail;
    private boolean Age;
    private boolean Esp;
    private boolean Partner;

    public dataValues(String name, String lastName1, String lastName2, String phone, String mail, boolean age, boolean esp, boolean partner) {
        Name = name;
        LastName1 = lastName1;
        LastName2 = lastName2;
        Phone = phone;
        Mail = mail;
        Age = age;
        Esp = esp;
        Partner = partner;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName1() {
        return LastName1;
    }

    public void setLastName1(String lastName1) {
        LastName1 = lastName1;
    }

    public String getLastName2() {
        return LastName2;
    }

    public void setLastName2(String lastName2) {
        LastName2 = lastName2;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public boolean isAge() {
        return Age;
    }

    public void setAge(boolean age) {
        Age = age;
    }

    public boolean isEsp() {
        return Esp;
    }

    public void setEsp(boolean esp) {
        Esp = esp;
    }

    public boolean isPartner() {
        return Partner;
    }

    public void setPartner(boolean partner) {
        Partner = partner;
    }
}


public class MainActivity extends AppCompatActivity {
    TextView txtName, txtLastName1, txtLastName2, txtPhone, txtMail, txtConfirmMail, lbErrorText;
    RadioGroup rgPartner, rgAge, rgEsp;
    RadioButton rdPartnerY, rdPartnerN, rdAgeY, rdAgeN, rdEspY, rdEspN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getTextAreas();
        getRadioGroups();
        getRadioButtons();
    }

    public void getTextAreas() {
        txtName = findViewById(R.id.txtName);
        txtLastName1 = findViewById(R.id.txtLastName1);
        txtLastName2 = findViewById(R.id.txtLastName2);
        txtPhone = findViewById(R.id.txtPhone);
        txtMail = findViewById(R.id.txtMail);
        txtConfirmMail = findViewById(R.id.txtConfirmMail);
        lbErrorText = findViewById(R.id.lbErrorText);
    }

    public void getRadioGroups() {
        rgPartner = findViewById(R.id.rgPartner);
        rgAge = findViewById(R.id.rgAge18);
        rgEsp = findViewById(R.id.rgEsp);
    }

    public void getRadioButtons() {
        rdPartnerY = findViewById(R.id.rdPartnerYes);
        rdPartnerN = findViewById(R.id.rdPartnerNo);
        rdAgeY = findViewById(R.id.rdAge18Yes);
        rdAgeN = findViewById(R.id.rdAge18No);
        rdEspY = findViewById(R.id.rdEspYes);
        rdEspN = findViewById(R.id.rdEspNo);
    }

    public boolean confirmMail(String mail, String mailConfirm) {
        if (mail == mailConfirm) return true;
        else return false;
    }

    public void sendData(View view) {

        String dataName = txtName.getText().toString();
        String dataLastName1 = txtLastName1.getText().toString();
        String dataLastName2 = txtLastName2.getText().toString();
        String dataPhone = txtPhone.getText().toString();
        String dataMail = txtMail.getText().toString();
        String confirmMail = txtConfirmMail.getText().toString();

        boolean dataPartner = false;
        boolean dataAge = false;
        boolean dataEsp = false;

        int selectedPartner = rgPartner.getCheckedRadioButtonId();
        switch (selectedPartner) {
            case R.id.rdPartnerYes:
                dataPartner = true;
                break;
            case R.id.rdPartnerNo:
                dataPartner = false;
                break;
        }

        int selectedAge = rgAge.getCheckedRadioButtonId();
        switch (selectedAge) {
            case R.id.rdAge18Yes:
                dataAge = true;
                break;
            case R.id.rdAge18No:
                dataAge = false;
                break;
        }

        int selectedEsp = rgEsp.getCheckedRadioButtonId();
        switch (selectedEsp) {
            case R.id.rdEspYes:
                dataEsp = true;
                break;
            case R.id.rdEspNo:
                dataEsp = false;
                break;
        }


        boolean check = confirmMail(dataMail, confirmMail);
        if (check) {
            dataValues db = new dataValues(dataName, dataLastName1, dataLastName2, dataPhone, dataMail, dataAge, dataEsp, dataPartner);

            Intent i = new Intent(this, MainActivity2.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", db);
            i.putExtras(bundle);
            startActivity(i);
        } else {
            lbErrorText.setText("ERROR: El correo no coincide");
        }

    }
}
