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
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

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
        setContentView(R.layout.zbs);
        Intent intent = getIntent();
        streamerName = intent.getStringExtra("streamerName");

        modifyLayout(streamerName);

        //Log.w("streamer name is", streamerName);
        isSDPresent = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);

        // Log.w("id_true", String.valueOf(id));
        int a = 3;

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
        setTitle(streamerName);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.acion_info:
                goInfo();
                break;
        }

        return true;
    }

    public void goInfo() {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("streamerName", streamerName);
        Log.w("asasdasdasd", streamerName);
        startActivity(intent);
    }

    public void HandleClick(View view) {
        Log.w("pressed button", String.valueOf((view.getId())));
        Log.w("calc", String.valueOf((calc(view.getId()))));
        startNTrack(calc(view.getId()));
    }

    public int calc(int n){
        return n - 2131558568;
    }


    public void startNTrack(int n){
        int id = this.getResources().getIdentifier(streamerName.toLowerCase() + "_" + n, "raw", this.getPackageName());
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

    public void modifyLayout(String streamerName) {

        Button play1 = (Button) findViewById(R.id.play1);
        play1.setText(Helper.phrases.get(streamerName.toLowerCase()).get(0));
        Button play2 = (Button) findViewById(R.id.play2);
        play2.setText(Helper.phrases.get(streamerName.toLowerCase()).get(1));
        Button play3 = (Button) findViewById(R.id.play3);
        play3.setText(Helper.phrases.get(streamerName.toLowerCase()).get(2));
        Button play4 = (Button) findViewById(R.id.play4);
        play4.setText(Helper.phrases.get(streamerName.toLowerCase()).get(3));
        Button play5 = (Button) findViewById(R.id.play5);
        play5.setText(Helper.phrases.get(streamerName.toLowerCase()).get(4));
        Button play6 = (Button) findViewById(R.id.play6);
        play6.setText(Helper.phrases.get(streamerName.toLowerCase()).get(5));
        Button play7 = (Button) findViewById(R.id.play7);
        play7.setText(Helper.phrases.get(streamerName.toLowerCase()).get(6));
        Button play8 = (Button) findViewById(R.id.play8);
        play8.setText(Helper.phrases.get(streamerName.toLowerCase()).get(7));
        Button play9 = (Button) findViewById(R.id.play9);
        play9.setText(Helper.phrases.get(streamerName.toLowerCase()).get(8));
        Button play10 = (Button) findViewById(R.id.play10);
        play10.setText(Helper.phrases.get(streamerName.toLowerCase()).get(9));
        Button play11 = (Button) findViewById(R.id.play11);
        play11.setText(Helper.phrases.get(streamerName.toLowerCase()).get(10));
        Button play12 = (Button) findViewById(R.id.play12);
        play12.setText(Helper.phrases.get(streamerName.toLowerCase()).get(11));
        Button play13 = (Button) findViewById(R.id.play13);
        play13.setText(Helper.phrases.get(streamerName.toLowerCase()).get(12));
        Button play14 = (Button) findViewById(R.id.play14);
        play14.setText(Helper.phrases.get(streamerName.toLowerCase()).get(13));
        Button play15 = (Button) findViewById(R.id.play15);
        play15.setText(Helper.phrases.get(streamerName.toLowerCase()).get(14));
        Button play16 = (Button) findViewById(R.id.play16);
        play16.setText(Helper.phrases.get(streamerName.toLowerCase()).get(15));
        Button play17 = (Button) findViewById(R.id.play17);
        play17.setText(Helper.phrases.get(streamerName.toLowerCase()).get(16));
        Button play18 = (Button) findViewById(R.id.play18);
        play18.setText(Helper.phrases.get(streamerName.toLowerCase()).get(17));
//        Button play19 = (Button) findViewById(R.id.play19);
//        play19.setText(Helper.phrases.get(streamerName.toLowerCase()).get(18));
//        Button play20 = (Button) findViewById(R.id.play20);
//        play20.setText(Helper.phrases.get(streamerName.toLowerCase()).get(19));
        int id = this.getResources().getIdentifier(streamerName.toLowerCase() + "_background1", "drawable", this.getPackageName());
        //ScrollView ll = (ScrollView) findViewById(R.id.background);
        //ll.setBackgroundResource(id);

        LinearLayout ll = (LinearLayout) findViewById(R.id.background);
        ll.setBackgroundResource(id);
        switch (streamerName) {
            case "xboct":
                TableRow tb8 = (TableRow) findViewById(R.id.raw8);
                tb8.setVisibility(View.GONE);
                TableRow tb9 = (TableRow) findViewById(R.id.raw9);
                tb9.setVisibility(View.GONE);
                break;
//            case "cheat_banned":
//                TableRow tb8 = (TableRow) findViewById(R.id.raw8);
//                tb8.setVisibility(View.GONE);
//                TableRow tb9 = (TableRow) findViewById(R.id.raw9);
//                tb9.setVisibility(View.GONE);
        }

    }

    public void deleteRows(int i) {
        switch (i) {
            case 1:
                TableRow tb9 = (TableRow) findViewById(R.id.raw9);
                tb9.setVisibility(View.GONE);
                break;
            case 2:
                TableRow tb8 = (TableRow) findViewById(R.id.raw8);
                tb8.setVisibility(View.GONE);
//                TableRow tb9 = (TableRow) findViewById(R.id.raw9);
//                tb9.setVisibility(View.GONE);
                break;
        }

    }


    public void onSave(View view) throws IOException {

        Log.w("pressed button", String.valueOf((view.getId())));
        File folder = new File("sdcard/streamSounds");
        folder.mkdir();
        Log.w("testDir", folder.getAbsolutePath());


        int n = view.getId() - 2131558569;
        Log.w("n", String.valueOf(n));
        int id = this.getResources().getIdentifier(streamerName.toLowerCase() + "_" + n, "raw", this.getPackageName());
        InputStream in = getResources().openRawResource(id);
        Log.w("path", folder.getAbsolutePath());

        Button b = (Button) findViewById(view.getId() - 1);
        String text = (String) b.getText();
        FileOutputStream out = new FileOutputStream(folder.getAbsolutePath() + "/" + streamerName + "_" + text + ".mp3");
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

        Toast toast = Toast.makeText(getApplicationContext(),
                "Файл " + streamerName.toLowerCase() + "_" + text + ".mp3 сохранен в папке streamSounds", Toast.LENGTH_SHORT);
        toast.show();
    }
}
