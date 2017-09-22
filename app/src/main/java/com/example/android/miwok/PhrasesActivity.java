package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

       final ArrayList<Words> listOfNumbers = new ArrayList<Words>();


        listOfNumbers.add(new Words("Where are you going?" ,"minto wuksus",R.raw.phrase_where_are_you_going));
        listOfNumbers.add(new Words("What is your name ?" , "tinne oyasse ne ",R.raw.phrase_what_is_your_name));
        listOfNumbers.add(new Words("My name is .. " , "oyaaset...",R.raw.phrase_my_name_is));
        listOfNumbers.add(new Words("How are you Feeling ?" , "michekses ?",R.raw.phrase_how_are_you_feeling));
        listOfNumbers.add(new Words("I am feeling good" , "kuchiachhit",R.raw.phrase_im_feeling_good));
        listOfNumbers.add(new Words("Are you coming ?" , "eenes aa' ",R.raw.phrase_are_you_coming));
        listOfNumbers.add(new Words("Yes I'm coming" , "hee eene'm ",R.raw.phrase_yes_im_coming));
        listOfNumbers.add(new Words("I'm coming" , "eenem",R.raw.phrase_im_coming));
        listOfNumbers.add(new Words("Let's go " , "yoowutis",R.raw.phrase_lets_go));
        listOfNumbers.add(new Words("come here" , "eene  'nem",R.raw.phrase_come_here));

        WordAdapter  adapter = new WordAdapter(this,  listOfNumbers,R.color.category_phrases);


        ListView listView = (ListView) findViewById(R.id.phrases);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(PhrasesActivity.this , "List Item Clicked" , Toast.LENGTH_SHORT).show();
                Words words = listOfNumbers.get(position);
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this,words.getAudioResourceId() );
                mMediaPlayer.start();
            }

        });
    }
}
