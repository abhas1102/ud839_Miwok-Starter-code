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


        ArrayList<String> listOfNumbers = new ArrayList<String>();
        listOfNumbers.add(0, "one");
        listOfNumbers.add(1, "two");
        listOfNumbers.add(2, "three");
        listOfNumbers.add(3, "four");
        listOfNumbers.add(4, "five");
        listOfNumbers.add(5, "six");
        listOfNumbers.add(6, "seven");
        listOfNumbers.add(7, "eight");
        listOfNumbers.add(8, "nine");
        listOfNumbers.add(9, "ten");

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, R.layout.list_item,R.id.miwok_text_view, listOfNumbers);


        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}



