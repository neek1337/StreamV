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
import android.widget.TextView;

import java.lang.reflect.Field;
import java.net.URI;

/**
 * Created by neek on 16.02.16.
 */
public class InfoActivity extends AppCompatActivity {
    String streamerName;
    String vkLink;
    String twitchLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_layout);
        Intent intent = getIntent();
        streamerName = intent.getStringExtra("streamerName");
        ImageView img = (ImageView) findViewById(R.id.streamer_info_image);
        int id = this.getResources().getIdentifier(streamerName.toLowerCase() + "_background1", "drawable", this.getPackageName());
        img.setBackgroundResource(id);
        TextView info_text = (TextView) findViewById(R.id.info_text);
        info_text.setText(Helper.infoMap.get(streamerName).get(0));
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
        intent.setData(Uri.parse(Helper.infoMap.get(streamerName).get(2)));
        Log.w("link", Helper.infoMap.get(streamerName).get(2));
        startActivity(intent);
    }

    public void onTwitchClick(View view) {
        Log.w("twitch", " clicked");
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(Helper.infoMap.get(streamerName).get(1)));
        Log.w("link", Helper.infoMap.get(streamerName).get(1));
        startActivity(intent);
    }

}
