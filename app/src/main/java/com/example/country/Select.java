package com.example.country;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class Select extends AppCompatActivity {

    ImageView flagChoiceView;
    Spinner spinnerCountry;
    ArrayAdapter<CharSequence> adapter;
    public static Button next2;
    int elementPosition;

    //Declaring all objects of type country
    country Austria = new country("Austria");
    country Belgium = new country("Belgium");
    country Denmark = new country("Denmark");
    country England = new country("England");
    country France = new country("France");
    country Germany = new country("Germany");
    country Ireland = new country("Ireland");
    country Italy = new country("Italy");
    country Luxembourg = new country("Luxembourg");
    country Portugal = new country("Portugal");
    country Spain = new country("Spain");
    country Sweden = new country("Sweden");
    country Switzerland = new country("Switzerland");
    country Wales = new country("Wales");

    //Creating an array of type country in preparation for sorting
    country[] countryList = {Austria, Belgium, Denmark,England,France,
            Germany,Ireland,Italy,Luxembourg,Portugal,Spain,Sweden,Switzerland,Wales};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        afterSecondClick();




        //sortFunction(countryList);
        spinnerCountry = (Spinner)findViewById(R.id.dropdown);
        adapter = ArrayAdapter.createFromResource(this,R.array.country_list,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapter);
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {

                elementPosition = position;

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

                   default:
                       flagChoiceView.setImageResource(R.drawable.austriaflag);
                       break;

               }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    //Linking the second activity to the third with a button click
    public void afterSecondClick()
    {
        next2 = (Button)findViewById(R.id.button);
        next2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v){

                        EditText inputFrequency = (EditText) findViewById(R.id.inputFrequency);


                        Spinner spinner = (Spinner)findViewById(R.id.dropdown);
                        String text = spinner.getSelectedItem().toString();


                        int count = 0;
                        while(count < countryList.length)
                        {
                            if((countryList[count]).getName().equals(text))
                            {
                                try
                                {
                                    countryList[count].setFrequency(Integer.parseInt(inputFrequency.toString()));
                                }
                                catch(NumberFormatException e)
                                {
                                    countryList[count].setFrequency(0);
                                }
                            }
                            count++;
                        }

                        sortFunction(countryList);
                        Intent proceedAgain = new Intent("com.example.country.Results");
                        proceedAgain.putExtra("firstCountry", countryList[13].getName());
                        proceedAgain.putExtra("secondCountry", countryList[12].getName());
                        proceedAgain.putExtra("thirdCountry", countryList[11].getName());
                        proceedAgain.putExtra("firstFrequency", countryList[13].getFrequency());
                        proceedAgain.putExtra("secondFrequency", countryList[12].getFrequency());
                        proceedAgain.putExtra("thirdFrequency", countryList[11].getFrequency());
                        startActivity(proceedAgain);
                    }
                }
        );
    }

    //Declaring a new inner class known as country
    private class country
    {
        private String name;
        private int frequency;

        public country(String Name){
            this.name = Name;
            this.frequency = 0;
        }

        public country(){
            this.name = "";
            this.frequency = 0;
        }

        public void setFrequency(int freq){
            this.frequency = freq;
        }

        public int getFrequency(){
            return frequency;
        }

        public String getName(){
            return name;
        }
    }

    //Sorting algorithm from lowest frequency to highest
    void sortFunction(country[] List){
        int count = 0;
        while(count < List.length){
            for(int n = 0; n < List.length - 1; n++){
                if(List[n].getFrequency() > List[n+1].getFrequency())
                    swapFunction(List, n);
            }
            count++;
        }
    }

    //Counterpart Method to sortFunction
    void swapFunction(country[] List, int m){
        country a, b, c;
        a = List[m];
        b = List[m+1];
        c = a;
        List[m+1] = c;
        List[m] = b;
    }
}
