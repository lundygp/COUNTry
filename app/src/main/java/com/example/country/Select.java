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

    //Declaring general variables
    ImageView flagChoiceView;
    Spinner spinnerCountry;
    ArrayAdapter<CharSequence> adapter;
    public static Button next2;
    int elementPosition;

    //Instantiating objects of type country. Constructor @ line 202
    country Austria = new country("Austria", 0);
    country Belgium = new country("Belgium", 1);
    country Denmark = new country("Denmark", 2);
    country England = new country("England", 3);
    country France = new country("France", 4);
    country Germany = new country("Germany", 5);
    country Ireland = new country("Ireland", 6);
    country Italy = new country("Italy", 7);
    country Luxembourg = new country("Luxembourg", 8);
    country Portugal = new country("Portugal", 9);
    country Spain = new country("Spain", 10);
    country Sweden = new country("Sweden", 11);
    country Switzerland = new country("Switzerland", 12);
    country Wales = new country("Wales", 13);

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

        //Setting protocols for entering values into the text field

        final TextWatcher numberInput = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    countryList[elementPosition].setFrequency(Integer.parseInt(s.toString()));
                }
                catch(NumberFormatException e)
                {
                    countryList[elementPosition].setFrequency(0);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        };


        //Creating a listener for the input field
        EditText inputFrequency = (EditText)findViewById(R.id.inputFrequency);
        inputFrequency.addTextChangedListener(numberInput);


        /* Interpreting the date from the spinner drop down menu, passing it through an adapter so that the position
          of the selected item can be gathered. */
        spinnerCountry = (Spinner)findViewById(R.id.dropdown);
        adapter = ArrayAdapter.createFromResource(this,R.array.country_list,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapter);
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {

                /* Using a switch statement and the .setImageResource method to change the image input into the
                   "flagChoiceView" image view so that the correct flag is displayed depending on the position of
                   the selected country in the spinner drop down. */

                flagChoiceView = (ImageView) findViewById(R.id.flagChoice);
                elementPosition = position;

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

    /* Sorting the array into frequency order, setting the objects to be used in the next activity,
       then sorting the names into alphabetical order and proceeding to the next activity. */
    public void afterSecondClick()
    {
        next2 = (Button)findViewById(R.id.button);
        next2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v){

                        sortFunction(countryList, "Freq");
                        Intent proceedAgain = new Intent("com.example.country.Results");
                        proceedAgain.putExtra("firstCountry", countryList[13].getName());
                        proceedAgain.putExtra("secondCountry", countryList[12].getName());
                        proceedAgain.putExtra("thirdCountry", countryList[11].getName());
                        proceedAgain.putExtra("firstFrequency", countryList[13].getFrequency());
                        proceedAgain.putExtra("secondFrequency", countryList[12].getFrequency());
                        proceedAgain.putExtra("thirdFrequency", countryList[11].getFrequency());
                        sortFunction(countryList, "Position");
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
        private int initialPosition;

        public country(String Name, int initial){
            this.name = Name;
            this.initialPosition = initial;
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

        public int getInitialPosition() {
            return initialPosition;
        }

        public String getName(){
            return name;
        }
    }

    //Sorting algorithm for elements of the countryList array
    void sortFunction(country[] List, String type){
        int count = 0;
        while(count < List.length){
            for(int n = 0; n < List.length - 1; n++){
                if(type == "Freq") {                        //This sorts the elements in order of frequency
                    if (List[n].getFrequency() > List[n + 1].getFrequency())
                        swapFunction(List, n);
                }
                else{                                       //This sorts the elements in alphabetical order
                    if (List[n].getInitialPosition() > List[n + 1].getInitialPosition())
                        swapFunction(List, n);
                }
            }
            count++;
        }
    }

    //Counterpart Method to sortFunction which swaps the objects if needed.
    void swapFunction(country[] List, int m){
        country a, b, c;
        a = List[m];
        b = List[m+1];
        c = a;
        List[m+1] = c;
        List[m] = b;
    }
}
