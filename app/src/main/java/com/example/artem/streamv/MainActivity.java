package com.example.artem.streamv;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import adapters.CustomPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        Helper helper = new Helper(this);

    }

    public void HandleClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        switch (view.getId()) {
            case R.id.button_carina:
                intent.putExtra("streamerName", "karina");
                break;
            case R.id.button_versuta:
                intent.putExtra("streamerName", "versuta");
                break;
            case R.id.button_altaoda:
                intent.putExtra("streamerName", "altaoda");
                break;
            case R.id.button_dread:
                intent.putExtra("streamerName", "dread");
                break;
            case R.id.button_vitysha:
                intent.putExtra("streamerName", "vitysha");
                break;
            case R.id.button_vjlink:
                intent.putExtra("streamerName", "vjlink");
                break;
            case R.id.button_xboct:
                intent.putExtra("streamerName", "xboct");
                break;
            case R.id.button_papich:
                intent.putExtra("streamerName", "papich");
                break;
            case R.id.button_sing_sing:
                intent.putExtra("streamerName", "sing_sing");
                break;
            case R.id.button_big_daddy:
                intent.putExtra("streamerName", "big_daddy");
                break;
            case R.id.button_solo:
                intent.putExtra("streamerName", "solo");
                break;
        }
        startActivity(intent);
    }


}
