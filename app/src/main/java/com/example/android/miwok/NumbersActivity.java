package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.miwok.R.id.default_text_view;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        final ArrayList<Words> listOfNumbers = new ArrayList<Words>();


        listOfNumbers.add(new Words("one" , "lutti",R.drawable.number_one));
        listOfNumbers.add(new Words("two" , "otiiko",R.drawable.number_two));
        listOfNumbers.add(new Words("three" , "tolookosu",R.drawable.number_three));
        listOfNumbers.add(new Words("four" , "oyyisa",R.drawable.number_four));
        listOfNumbers.add(new Words("five" , "massokka",R.drawable.number_five));
        listOfNumbers.add(new Words("six" , "temmokka",R.drawable.number_six));
        listOfNumbers.add(new Words("seven" , "kenekaku",R.drawable.number_seven));
        listOfNumbers.add(new Words("eight" , "kawinta",R.drawable.number_eight));
        listOfNumbers.add(new Words("nine" , "wo'e",R.drawable.number_nine));
        listOfNumbers.add(new Words("ten" , "na ' aacha",R.drawable.number_ten));

        WordAdapter  adapter = new WordAdapter(this,  listOfNumbers, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}