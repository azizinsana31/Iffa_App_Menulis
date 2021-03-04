package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView cv1, cv2, cv3, cv4, cv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv1 = findViewById(R.id.menu1);
        cv2 = findViewById(R.id.menu2);
        cv3 = findViewById(R.id.menu3);
        cv4 = findViewById(R.id.menu4);
        cv5 = findViewById(R.id.menu5);

        // OnClick events With Lambda Expression
        cv1.setOnClickListener((v) -> { moveToSubActivity("kenal_huruf"); });
        cv2.setOnClickListener((v) -> { moveToSubActivity("padaan_huruf"); });
        cv3.setOnClickListener((v) -> { moveToSubActivity("cantum_suku_kata"); });
        cv4.setOnClickListener((v) -> { moveToSubActivity("cantum_perkataan"); });
        cv5.setOnClickListener((v) -> { moveToSubActivity("cantum_ayat"); });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optons_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_keluar:
                this.finishAffinity();
                System.exit(0);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void moveToSubActivity(String sub_menu_list){
        Intent i = new Intent(MainActivity.this, SubActivity.class);
        i.putExtra("sub_menu", sub_menu_list);
        startActivity(i);
    }
}