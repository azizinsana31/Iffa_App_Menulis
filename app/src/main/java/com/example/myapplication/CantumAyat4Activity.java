package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CantumAyat4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantum_ayat4);
        TextView soal = (TextView)  findViewById(R.id.textViewAyat4);
        EditText jawaban =(EditText) findViewById(R.id.textJawabanAyat4);
        EditText jawaban2 =(EditText) findViewById(R.id.textJawaban2Ayat4);
        EditText jawaban3 =(EditText) findViewById(R.id.textJawaban3Ayat4);
        Button btnCheck = (Button) findViewById(R.id.btnCekAyat4);
        btnCheck.setOnClickListener(v -> {
            String jwb = jawaban.getText().toString()+"\n"+jawaban2.getText().toString()+"\n"+jawaban3.getText().toString();
            String jawab = soal.getText().toString().toLowerCase();

            if (jwb.toLowerCase().equals(soal.getText().toString().toLowerCase())){
                Intent i = new Intent(CantumAyat4Activity.this, PopupActivity.class);
                i.putExtra("hasil", true);
                startActivity(i);
                playAudio(true);
            }
            else {
                Intent i = new Intent(CantumAyat4Activity.this, PopupActivity.class);
                i.putExtra("hasil", false);
                startActivity(i);
                playAudio(false);
            }

        });
    }
    public void playAudio(boolean value){
        if (value){
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.pandainya);
            mediaPlayer.start();
        }
        else{
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.cuba_lagi2);
            mediaPlayer.start();
        }
    }
}