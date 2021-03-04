package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {
    String[] arr = null;
    Context context;
    Class destinationClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        ListView lvSubMenu = findViewById(R.id.list_view_sub_menu);
        Bundle intent = getIntent().getExtras();
        final String strMenu = intent.getString("sub_menu");

        switch (strMenu){
            case "kenal_huruf":
                arr = getResources().getStringArray(R.array.kenal_huruf);
                destinationClass = HurufActivity.class;
                break;
            case  "padaan_huruf":
                arr = getResources().getStringArray(R.array.padaan_huruf);
                destinationClass = PadaanHurufActivity.class;
                break;
            case "cantum_suku_kata":
                arr = getResources().getStringArray(R.array.cantum_suku_kata);
                destinationClass = SukuKataTerbukaActivity.class;
                break;
            case "cantum_perkataan":
                arr = getResources().getStringArray(R.array.cantum_perkataan);
                destinationClass = CantumPerkataanActivity.class;
                break;
            case "cantum_ayat":
                arr = getResources().getStringArray(R.array.cantum_ayat);
                destinationClass = CantumAyatActivity.class;
                break;
            default:
                break;
        }

        ArrayAdapter listMenu = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, arr);
        lvSubMenu.setAdapter(listMenu);
        lvSubMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(arr[position].toLowerCase().equals("suku kata tertutup")){
                    destinationClass = SukuKataTertutupActivity.class;
                }
                else if(arr[position].toLowerCase().equals("cantum perkataan 2")){
                    destinationClass = CantumPerkataan2Activity.class;
                }
                else if(arr[position].toLowerCase().equals("cantum ayat 2")){
                    destinationClass = CantumAyat2Activity.class;
                }
                else if(arr[position].toLowerCase().equals("cantum ayat 3")) {
                    destinationClass = CantumAyat3Activity.class;
                }
                else if(arr[position].toLowerCase().equals("cantum ayat 4")){
                        destinationClass = CantumAyat4Activity.class;
                }

                Intent i = new Intent(SubActivity.this, destinationClass);
                i.putExtra("Mode", arr[position].toLowerCase());
                startActivity(i);

                //Toast.makeText(SubActivity.this, arr[position], Toast.LENGTH_SHORT).show();
            }
        });


    }
}