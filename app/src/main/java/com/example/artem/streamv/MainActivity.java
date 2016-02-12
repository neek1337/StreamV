package com.example.artem.streamv;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import adapters.CustomPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Helper helper = new Helper(this);

    }

    public void HandleClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        switch (view.getId()) {
            case R.id.button1:
                intent.putExtra("streamerName", "sing_sing");
                break;
            case R.id.button2:
                intent.putExtra("streamerName", "versuta");
                break;
        }
        startActivity(intent);
    }


}
