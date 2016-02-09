package com.example.artem.streamv;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;

import java.io.File;

/**
 * Created by artem on 08.02.16.
 */
public class SecondActivity extends AppCompatActivity {
    String streamerName;
    MediaPlayer mPlayer = new MediaPlayer();
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Intent intent = getIntent();

        int a = 3;
       streamerName  = intent.getStringExtra("streamerName");
//        ImageButton button = (ImageButton) findViewById(R.id.button1);
        //button.getBackground().setAlpha(64);
      /*  button.setBackground(this.getResources().getDrawable( this.getResources().getIdentifier(streamerName, "drawable", this.getPackageName())));
        button = (Button) findViewById(R.id.button2);
        button.setBackground(this.getResources().getDrawable( this.getResources().getIdentifier(streamerName, "drawable", this.getPackageName())));
        button = (Button) findViewById(R.id.button3);
        button.setBackground(this.getResources().getDrawable( this.getResources().getIdentifier(streamerName, "drawable", this.getPackageName())));
        button = (Button) findViewById(R.id.button4);
        button.setBackground(this.getResources().getDrawable( this.getResources().getIdentifier(streamerName, "drawable", this.getPackageName())));
        button = (Button) findViewById(R.id.button5);
        button.setBackground(this.getResources().getDrawable( this.getResources().getIdentifier(streamerName, "drawable", this.getPackageName())));
        button = (Button) findViewById(R.id.button6);
        button.setBackground(this.getResources().getDrawable( this.getResources().getIdentifier(streamerName, "drawable", this.getPackageName())));
        button = (Button) findViewById(R.id.button7);
        button.setBackground(this.getResources().getDrawable( this.getResources().getIdentifier(streamerName, "drawable", this.getPackageName())));
        button = (Button) findViewById(R.id.button8);
        button.setBackground(this.getResources().getDrawable( this.getResources().getIdentifier(streamerName, "drawable", this.getPackageName())));
        button = (Button) findViewById(R.id.button9);
        button.setBackground(this.getResources().getDrawable( this.getResources().getIdentifier(streamerName, "drawable", this.getPackageName())));*/
        //EditText editText = (EditText) findViewById(R.id.textEditor);
        //editText.setText(streamerName);


    }
    public void HandleClick(View view) {
        Log.w("pressed button", String.valueOf((view.getId())));
        startNTrack(view.getId() - 2131558481);
    }

    public void startNTrack(int n){
        int id = this.getResources().getIdentifier(streamerName + n, "raw", this.getPackageName());
        mPlayer.stop();
        mPlayer.release();
        mPlayer= MediaPlayer.create(this, id);
        mPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
        mPlayer.stop();
    }
    @Override
    protected void onStop() {
        super.onStop();
        getDelegate().onStop();
        mPlayer.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mPlayer.start();
    }
}
