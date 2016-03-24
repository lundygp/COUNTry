package com.example.country;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    
    //Inflation of GUI and toolbar for the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();

        /* Displaying the information passed from the previous activity and ensuring no countries with a
           frequency of 0 are shown. */

        TextView countryOne = (TextView)findViewById(R.id.firstCountry);
        TextView freqOne = (TextView)findViewById(R.id.firstFrequency);
        TextView posOne = (TextView)findViewById(R.id.firstPosition);
        if(extras.getInt("firstFrequency") != 0){
            countryOne.setText(extras.getString("firstCountry"));
            freqOne.setText(String.valueOf(extras.getInt("firstFrequency")));
            posOne.setText("1");
        }

        TextView countryTwo = (TextView)findViewById(R.id.secondCountry);
        TextView freqTwo = (TextView)findViewById(R.id.secondFrequency);
        TextView posTwo = (TextView)findViewById(R.id.secondPosition);
        if(extras.getInt("secondFrequency") != 0){
            countryTwo.setText(extras.getString("secondCountry"));
            freqTwo.setText(String.valueOf(extras.getInt("secondFrequency")));
            posTwo.setText("2");
        }

        TextView countryThree = (TextView)findViewById(R.id.thirdCountry);
        TextView freqThree = (TextView)findViewById(R.id.thirdFrequency);
        TextView posThree = (TextView)findViewById(R.id.thirdPosition);
        if(extras.getInt("thirdFrequency") != 0){
            countryThree.setText(extras.getString("thirdCountry"));
            freqThree.setText(String.valueOf(extras.getInt("thirdFrequency")));
            posThree.setText("3");
        }
    }

}
