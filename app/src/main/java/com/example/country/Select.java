package com.example.country;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class Select extends AppCompatActivity {

    ImageView flagChoiceView;
    Spinner spinnerCountry;
    ArrayAdapter<CharSequence> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        spinnerCountry = (Spinner)findViewById(R.id.dropdown);
        adapter = ArrayAdapter.createFromResource(this,R.array.country_list,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapter);
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                flagChoiceView = (ImageView) findViewById(R.id.flagChoice);

               switch(position)
               {
                   case 0:

                   flagChoiceView.setImageResource(R.drawable.austriaflag);
                   break;

                   case 1:
                       flagChoiceView.setImageResource(R.drawable.belgiumflag);
                       break;

                   case 2:
                       flagChoiceView.setImageResource(R.drawable.denmarkflag);
                       break;

                   case 3:
                       flagChoiceView.setImageResource(R.drawable.englandflag);
                       break;

                   case 4:
                       flagChoiceView.setImageResource(R.drawable.franceflag);
                       break;

                   case 5:
                       flagChoiceView.setImageResource(R.drawable.germanflag);
                       break;

                   case 6:
                       flagChoiceView.setImageResource(R.drawable.irelandflag);
                       break;

                   case 7:
                       flagChoiceView.setImageResource(R.drawable.italyflag);
                       break;

                   case 8:
                       flagChoiceView.setImageResource(R.drawable.luxembourgeflag);
                       break;

                   case 9:
                       flagChoiceView.setImageResource(R.drawable.portugalflag);
                       break;

                   case 10:
                       flagChoiceView.setImageResource(R.drawable.spainflag);
                       break;

                   case 11:
                       flagChoiceView.setImageResource(R.drawable.swedenflag);
                       break;

                   case 12:
                       flagChoiceView.setImageResource(R.drawable.switzerlandflag);
                       break;

                   case 13:
                       flagChoiceView.setImageResource(R.drawable.walesflag);
                       break;

                   default: flagChoiceView.setImageResource(R.drawable.austriaflag);
                       break;

               }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
