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

        TextView countryOne = (TextView)findViewById(R.id.firstCountry);
        countryOne.setText(extras.getString("firstCountry"));

        TextView countryTwo = (TextView)findViewById(R.id.secondCountry);
        countryTwo.setText(extras.getString("secondCountry"));

        TextView countryThree = (TextView)findViewById(R.id.thirdCountry);
        countryThree.setText(extras.getString("thirdCountry"));

        TextView freqOne = (TextView)findViewById(R.id.firstFrequency);
        freqOne.setText(String.valueOf(extras.getInt("firstFrequency")));

        TextView freqTwo = (TextView)findViewById(R.id.secondFrequency);
        freqTwo.setText(String.valueOf(extras.getInt("secondFrequency")));

        TextView freqThree = (TextView)findViewById(R.id.thirdFrequency);
        freqThree.setText(String.valueOf(extras.getInt("thirdFrequency")));
    }

}
