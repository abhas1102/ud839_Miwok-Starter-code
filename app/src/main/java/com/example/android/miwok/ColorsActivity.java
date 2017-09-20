package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<Words> listOfNumbers = new ArrayList<Words>();


        listOfNumbers.add(new Words("red" , "witetti",R.drawable.color_red));
        listOfNumbers.add(new Words("mustard yellow" , "chiwitta",R.drawable.color_mustard_yellow));
        listOfNumbers.add(new Words("dust yellow" , "topisse",R.drawable.color_dusty_yellow));
        listOfNumbers.add(new Words("green" , "chokokki",R.drawable.color_green));
        listOfNumbers.add(new Words("brown" , "takaakki",R.drawable.color_brown));
        listOfNumbers.add(new Words("gray" , "topappi",R.drawable.color_gray));
        listOfNumbers.add(new Words("black" , "kululli",R.drawable.color_black));
        listOfNumbers.add(new Words("white" , "kelelli",R.drawable.color_white));


        WordAdapter  adapter = new WordAdapter(this,  listOfNumbers,R.color.category_colors);


        ListView listView = (ListView) findViewById(R.id.colors);

        listView.setAdapter(adapter);
    }
    }

