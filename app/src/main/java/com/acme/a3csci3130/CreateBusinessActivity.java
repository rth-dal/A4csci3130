package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateBusinessActivity extends Activity {

    private EditText nameField, numberField, addressField;
    private Spinner provinceField, businessField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_business_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (Spinner) findViewById(R.id.province);
        businessField = (Spinner) findViewById(R.id.business);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String id = appState.firebaseReference.push().getKey();
        String number = numberField.getText().toString();
        String name = nameField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getSelectedItem().toString();
        String business = businessField.getSelectedItem().toString();


        Business bs = new Business(id, name, number, address, province, business);

        appState.firebaseReference.child(id).setValue(bs);
        finish();

    }
}
