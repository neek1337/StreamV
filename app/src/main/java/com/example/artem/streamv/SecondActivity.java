package com.example.artem.streamv;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by artem on 08.02.16.
 */
public class SecondActivity extends AppCompatActivity {

    Boolean isSDPresent;

    String streamerName;
    MediaPlayer mPlayer = new MediaPlayer();
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Intent intent = getIntent();
        isSDPresent = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);

        int a = 3;
       streamerName  = intent.getStringExtra("streamerName");
        LinearLayout ll = (LinearLayout) findViewById(R.id.background);
        int id = this.getResources().getIdentifier(streamerName + "_background", "drawable", this.getPackageName());
        ll.setBackground(ContextCompat.getDrawable(this, id));
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

    public void OnSave(View view) throws IOException {

        Log.w("pressed button", String.valueOf((view.getId())));
        File folder = new File("sdcard/vtic");
        folder.mkdir();
        Log.w("testDir", folder.getAbsolutePath());


        int n = (view.getId() - 2131558511) / 2 + 1;
        Log.w("n", String.valueOf(n));
        int id = this.getResources().getIdentifier(streamerName + n, "raw", this.getPackageName());
        InputStream in = getResources().openRawResource(id);
        Log.w("path", folder.getAbsolutePath());

        FileOutputStream out = new FileOutputStream(folder.getAbsolutePath() + "/" + streamerName + n + ".mp3");
        byte[] buff = new byte[1024];

        int read = 0;

        try {
            while ((read = in.read(buff)) > 0) {
                out.write(buff, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
            out.close();
        }
    }
}
