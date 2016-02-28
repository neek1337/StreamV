package com.example.artem.streamv;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {

    Boolean isSDPresent;

    String streamerName;
    MediaPlayer mPlayer = new MediaPlayer();
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zaebalsya_uzhe_layout);
        Intent intent = getIntent();
        streamerName = intent.getStringExtra("streamerName");
        Log.w("streamer name is", streamerName);
        isSDPresent = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
        int id = this.getResources().getIdentifier(streamerName + "_background1", "drawable", this.getPackageName());
        Log.w("id_true", String.valueOf(id));
        int a = 3;
        ScrollView ll = (ScrollView) findViewById(R.id.background);
        ll.setBackgroundResource(id);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, InfoActivity.class);
        switch (item.getItemId()) {
            case R.id.acion_info:
                intent.putExtra("streamerName", streamerName);
        }
        startActivity(intent);
        return true;
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

    public void onTextClick(View view) {
        Log.w("textId", String.valueOf(view.getId()));
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
