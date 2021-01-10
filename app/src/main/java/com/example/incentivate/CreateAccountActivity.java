package com.example.incentivate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {
    //private EditText mloggedIn;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText mName, mEmail, mCardNumber, mExpiryDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        Button confirm = (Button) findViewById(R.id.button2);

        mName = (EditText)findViewById(R.id.activityName);
        mEmail = (EditText)findViewById(R.id.email);
        mCardNumber = (EditText)findViewById(R.id.cardNumber);
        mExpiryDate = (EditText)findViewById(R.id.expiryDate);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        confirm.setOnClickListener(this::goHome);
        /*
        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mEditor.putString(getString(R.string.loggedIn), "True");
                mEditor.apply();

                String name = mName.getText().toString();
                mEditor.putString(getString(R.string.name), name);
                mEditor.commit();

                String email = mEmail.getText().toString();
                mEditor.putString(getString(R.string.email), email);
                mEditor.commit();

                String cardNumber = mCardNumber.getText().toString();
                mEditor.putString(getString(R.string.cardNum), cardNumber);
                mEditor.commit();

                String expiryDate = mExpiryDate.getText().toString();
                mEditor.putString(getString(R.string.expDate), expiryDate);
                mEditor.commit();

                goHome(v);
            }
        });
             */
    }

    public void goHome(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    /*
    private void checkSharedPreferences() {
        String loggedIn = mPreferences.getString(getString(R.string.loggedIn),"False");
        String name = mPreferences.getString(getString(R.string.name),"");
        String email = mPreferences.getString(getString(R.string.name),"");
        String cardNum = mPreferences.getString(getString(R.string.cardNum),"");
        String expDate = mPreferences.getString(getString(R.string.expDate),"");

        mName.setText(name);
        mEmail.setText(email);
        mCardNumber.setText(cardNum);
        mExpiryDate.setText(expDate);
        mloggedIn.setText(loggedIn);
    }

     */
}
