package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.google.firebase.database.FirebaseDatabase;

public class DetailViewActivity extends Activity {

    private EditText nameField, numberField, addressField, jobField, provinceField;
    Business receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Business)getIntent().getSerializableExtra("Contact");

        MyApplicationData appData = (MyApplicationData)getApplication();
        appState = ((MyApplicationData) getApplicationContext());

        appData.firebaseDBInstance = FirebaseDatabase.getInstance();
        appData.firebaseReference = appData.firebaseDBInstance.getReference("Businesses");

        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);
        jobField = (EditText) findViewById(R.id.job);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            numberField.setText(receivedPersonInfo.number);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
            jobField.setText(receivedPersonInfo.job);
        }
    }

    /**
     * This function updates the business in the database.
     */
    public void updateBusiness(View v) {
        //TODO: Update contact functionality

        String name = nameField.getText().toString();
        String number = numberField.getText().toString();
        String address = addressField.getText().toString();
        String job= jobField.getText().toString();
        String province = provinceField.getText().toString();




        appState.firebaseReference.child(receivedPersonInfo.id).setValue(receivedPersonInfo);

        finish();


    }


    /**
     * This function remove the considered business from the database.
     */
    public void eraseBusiness(View v) {
        //TODO: Erase contact functionality
        appState.firebaseReference.child(receivedPersonInfo.id).removeValue();

        finish();

    }
}
