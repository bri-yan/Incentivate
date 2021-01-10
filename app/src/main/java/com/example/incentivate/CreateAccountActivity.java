package com.example.incentivate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLOutput;

public class CreateAccountActivity extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    boolean loggedIn;

    private EditText mName, mEmail, mCardNumber, mExpiryDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        loggedIn = mPreferences.getBoolean("loGGedIn",false);

        System.out.println("loggedIn: " + loggedIn);

        if (loggedIn) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else {

            Button confirm = (Button) findViewById(R.id.button2);

            mName = (EditText) findViewById(R.id.activityName);
            mEmail = (EditText) findViewById(R.id.email);
            mCardNumber = (EditText) findViewById(R.id.cardNumber);
            mExpiryDate = (EditText) findViewById(R.id.expiryDate);

            mEditor = mPreferences.edit();

            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loggedIn = true;
                    mEditor.putBoolean("loGGedIn", loggedIn);
                    mEditor.apply();
                    System.out.println("SAVED: " + loggedIn);

                    String name = mName.getText().toString();
                    mEditor.putString(getString(R.string.name), name);
                    mEditor.commit();
                    System.out.println("SAVED: " + name);

                    String email = mEmail.getText().toString();
                    mEditor.putString(getString(R.string.email), email);
                    mEditor.commit();
                    System.out.println("SAVED: " + email);

                    String cardNumber = mCardNumber.getText().toString();
                    mEditor.putString(getString(R.string.cardNum), cardNumber);
                    mEditor.commit();
                    System.out.println("SAVED: " + cardNumber);

                    String expiryDate = mExpiryDate.getText().toString();
                    mEditor.putString(getString(R.string.expDate), expiryDate);
                    mEditor.commit();
                    System.out.println("SAVED: " + expiryDate);

                    goHome(v);
                }
            });
        }
    }

    public void goHome(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    /*
    private void checkSharedPreferences() {
        String name = mPreferences.getString(getString(R.string.name),"");
        String email = mPreferences.getString(getString(R.string.name),"");
        String cardNum = mPreferences.getString(getString(R.string.cardNum),"");
        String expDate = mPreferences.getString(getString(R.string.expDate),"");

        mName.setText(name);
        mEmail.setText(email);
        mCardNumber.setText(cardNum);
        mExpiryDate.setText(expDate);
    }

     */
}
