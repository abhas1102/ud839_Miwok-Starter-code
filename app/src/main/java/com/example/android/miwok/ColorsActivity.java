package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        final ArrayList<Words> listOfNumbers = new ArrayList<Words>();


        listOfNumbers.add(new Words("red" , "witetti",R.drawable.color_red,R.raw.color_red));
        listOfNumbers.add(new Words("mustard yellow" , "chiwitta",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        listOfNumbers.add(new Words("dust yellow" , "topisse",R.drawable.color_dusty_yellow,R.raw.color_mustard_yellow));
        listOfNumbers.add(new Words("green" , "chokokki",R.drawable.color_green,R.raw.color_green));
        listOfNumbers.add(new Words("brown" , "takaakki",R.drawable.color_brown,R.raw.color_brown));
        listOfNumbers.add(new Words("gray" , "topappi",R.drawable.color_gray,R.raw.color_gray));
        listOfNumbers.add(new Words("black" , "kululli",R.drawable.color_black,R.raw.color_black));
        listOfNumbers.add(new Words("white" , "kelelli",R.drawable.color_white,R.raw.color_white));


        WordAdapter  adapter = new WordAdapter(this,  listOfNumbers,R.color.category_colors);


        ListView listView = (ListView) findViewById(R.id.colors);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(ColorsActivity.this , "List Item Clicked" , Toast.LENGTH_SHORT).show();
                Words words = listOfNumbers.get(position);
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this,words.getAudioResourceId() );
                mMediaPlayer.start();
            }

        });
    }
    }

