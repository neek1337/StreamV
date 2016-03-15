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
                intent.putExtra("streamerName", "Karina");
                break;
            case R.id.button_versuta:
                intent.putExtra("streamerName", "Versuta");
                break;
            case R.id.button_altaoda:
                intent.putExtra("streamerName", "Altaoda");
                break;
            case R.id.button_dread:
                intent.putExtra("streamerName", "Dread");
                break;
            case R.id.button_vitysha:
                intent.putExtra("streamerName", "Vitysha");
                break;
            case R.id.button_vjlink:
                intent.putExtra("streamerName", "Vjlink");
                break;
            case R.id.button_xboct:
                intent.putExtra("streamerName", "Xboct");
                break;
            case R.id.button_papich:
                intent.putExtra("streamerName", "Papich");
                break;
            case R.id.button_sing_sing:
                intent.putExtra("streamerName", "Sing_sing");
                break;
            case R.id.button_big_daddy:
                intent.putExtra("streamerName", "Big_daddy");
                break;
            case R.id.button_solo:
                intent.putExtra("streamerName", "Solo");
                break;
            case R.id.button_cheat_banned:
                intent.putExtra("streamerName", "Cheat_banned");
                break;
        }
        startActivity(intent);
    }


}
