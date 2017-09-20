package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<Words> listOfNumbers = new ArrayList<Words>();


        listOfNumbers.add(new Words("Where are you going?" ,"minto wuksus"));
        listOfNumbers.add(new Words("What is your name ?" , "tinne oyasse ne "));
        listOfNumbers.add(new Words("My name is .. " , "oyaaset..."));
        listOfNumbers.add(new Words("How are you Feeling ?" , "michekses ?"));
        listOfNumbers.add(new Words("I am feeling good" , "kuchiachhit"));
        listOfNumbers.add(new Words("Are you coming ?" , "eenes aa' "));
        listOfNumbers.add(new Words("Yes I'm coming" , "hee eene'm "));
        listOfNumbers.add(new Words("I'm coming" , "eenem"));
        listOfNumbers.add(new Words("Let's go " , "yoowutis"));
        listOfNumbers.add(new Words("come here" , "eene  'nem"));

        WordAdapter  adapter = new WordAdapter(this,  listOfNumbers,R.color.category_phrases);


        ListView listView = (ListView) findViewById(R.id.phrases);

        listView.setAdapter(adapter);
    }
}
