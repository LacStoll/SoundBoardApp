package com.example.soundboardapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Declaring the variables for the soundboard buttons and media player
    ImageButton fail, wow, burgerking, maracas, john, sad, standing, tacobell, spongebob;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigns each ImageButton to the buttons in the layout
        fail = findViewById(R.id.fail);
        wow = findViewById(R.id.wow);
        burgerking = findViewById(R.id.burgerking);
        maracas = findViewById(R.id.maracas);
        john = findViewById(R.id.john);
        sad = findViewById(R.id.sad);
        standing = findViewById(R.id.standing);
        tacobell = findViewById(R.id.tacobell);
        spongebob = findViewById(R.id.spongebob);

        mediaPlayer = new MediaPlayer();

        //Sets the OnClickListeners for each of the buttons to call playSound() so the code isn't repetitive
        fail.setOnClickListener(view -> playSound(R.raw.fail));
        wow.setOnClickListener(view -> playSound(R.raw.animewow));
        burgerking.setOnClickListener(view -> playSound(R.raw.daftwhopper));
        maracas.setOnClickListener(view -> playSound(R.raw.cholamais));
        john.setOnClickListener(view -> playSound(R.raw.john));
        sad.setOnClickListener(view -> playSound(R.raw.sad));
        standing.setOnClickListener(view -> playSound(R.raw.standing));
        tacobell.setOnClickListener(view -> playSound(R.raw.tacobell));
        spongebob.setOnClickListener(view -> playSound(R.raw.spongebobfail));
    }

    // A method that takes the sound ID and plays the audio
    private void playSound(int soundId) {
        //Stops the media player if it's currently playing
        stopMediaPlayer();
        //Starts the media player with the selected sound
        mediaPlayer = MediaPlayer.create(MainActivity.this, soundId);
        mediaPlayer.start();
    }

    // A method that stops the music and releases the media player
    private void stopMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    // onDestroy is called when the activity is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopMediaPlayer();
    }
}