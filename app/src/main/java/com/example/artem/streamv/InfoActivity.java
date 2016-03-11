package com.example.artem.streamv;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.net.URI;

/**
 * Created by neek on 16.02.16.
 */
public class InfoActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_layout);
        Intent intent = getIntent();
        String streamerName = intent.getStringExtra("streamerName") + "_main";
        ImageView img = (ImageView) findViewById(R.id.streamer_info_image);
        int id = this.getResources().getIdentifier(streamerName, "drawable", this.getPackageName());
        img.setBackgroundResource(id);
    }

    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


    public void onVKClick(View view) {
        Log.w("vk", " clicked");
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.twitch.tv/versuta"));
        startActivity(intent);
    }



}
