package com.example.android.miwok;

import android.media.AudioManager;
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

    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        mAudioManager = (AudioManager) getSystemService(this.AUDIO_SERVICE);

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
                Toast.makeText(PhrasesActivity.this, "List Item Clicked", Toast.LENGTH_SHORT).show();
                releaseMediaPlayer();
                Words words = listOfNumbers.get(position);

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, words.getAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }

        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
