package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    /** Handles playback of all the sound files */
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Words> listOfNumbers = new ArrayList<Words>();
        listOfNumbers.add(new Words("father", "әpә", R.drawable.family_father, R.raw.family_father));
        listOfNumbers.add(new Words("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        listOfNumbers.add(new Words("son", "angsi", R.drawable.family_son, R.raw.family_son));
        listOfNumbers.add(new Words("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        listOfNumbers.add(new Words("older brother", "taachi", R.drawable.family_older_brother,
                R.raw.family_older_brother));
        listOfNumbers.add(new Words("younger brother", "chalitti", R.drawable.family_younger_brother,
                R.raw.family_younger_brother));
        listOfNumbers.add(new Words("older sister", "teṭe", R.drawable.family_older_sister,
                R.raw.family_older_sister));
        listOfNumbers.add(new Words("younger sister", "kolliti", R.drawable.family_younger_sister,
                R.raw.family_younger_sister));
        listOfNumbers.add(new Words("grandmother ", "ama", R.drawable.family_grandmother,
                R.raw.family_grandmother));
        listOfNumbers.add(new Words("grandfather", "paapa", R.drawable.family_grandfather,
                R.raw.family_grandfather));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, listOfNumbers, R.color.category_family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Words word = listOfNumbers.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }
}