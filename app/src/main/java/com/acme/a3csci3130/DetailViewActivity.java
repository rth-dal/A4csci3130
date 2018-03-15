package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DetailViewActivity extends Activity {

    private EditText nameField, numberField, addressField;
    private Spinner businessField, provinceField;
    Business receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Business)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (Spinner) findViewById(R.id.province);
        businessField = (Spinner) findViewById(R.id.business);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            numberField.setText(receivedPersonInfo.number);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setSelection(getIndex(provinceField, receivedPersonInfo.province));
            businessField.setSelection(getIndex(businessField, receivedPersonInfo.business));
        }
    }

    /**
     * This function updates the business in the database.
     */
    public void updateBusiness(View v) {
        //TODO: Update contact functionality
        appState = ((MyApplicationData) getApplicationContext());

        String name = nameField.getText().toString();
        String number = numberField.getText().toString();
        String address = addressField.getText().toString();
        String business= businessField.getSelectedItem().toString();
        String province = provinceField.getSelectedItem().toString();


        Business company = new Business(receivedPersonInfo.id, name, number, province, address, business);

        appState.firebaseReference.child(receivedPersonInfo.id).setValue(company);

        finish();


    }


    /**
     * This function remove the considered business from the database.
     */
    public void eraseBusiness(View v) {
        //TODO: Erase contact functionality

        appState = ((MyApplicationData) getApplicationContext());
        appState.firebaseReference.child(receivedPersonInfo.id).removeValue();

        finish();

    }

    /**
     * This function gets the index of a Spinner for a given string.
     */
    public int getIndex(Spinner spinner, String myString)
    {
        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                index = i;
                break;
            }
        }
        return index;
    }
}
