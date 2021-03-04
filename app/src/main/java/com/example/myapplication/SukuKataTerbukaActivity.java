package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class SukuKataTerbukaActivity extends AppCompatActivity {
    CustomSwipeAdapter adapter;
    ViewPager vPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suku_kata_terbuka);

        String[] soalHuruf = { "a", "i", "u", "e", "o" };
        String[] soal1 = {"ba", "bi", "bu", "be", "bo"};
        String[] soal2 = {"ca", "ci", "cu", "ce", "co"};
        String[] soal3 = {"da", "di", "du", "de", "do"};

        try{
            vPager = (ViewPager) findViewById(R.id.vPager);
            adapter = new CustomSwipeAdapter(this, soalHuruf, soal1, soal2, soal3);
            vPager.setAdapter(adapter);
        }
        catch(Exception ex){
            Log.e("Error " , ex.getMessage());
        }
    }

    class CustomSwipeAdapter extends PagerAdapter {
        String[] soalHuruf;
        String[] soalSukuKata1;
        String[] soalSukuKata2;
        String[] soalSukuKata3;
        Context mContext;
        LayoutInflater layoutInflater;

        TextView txtSoal1, txtSoal2, txtSoal3;
        TextView txtSoalHuruf;
        Button btnCheck;

        CustomSwipeAdapter(Context ctx, String[] soalHuruf, String[] soalSukuKata1, String[] soalSukuKata2, String[] soalSukuKata3) {
            this.mContext = ctx;
            this.soalHuruf = soalHuruf;
            this.soalSukuKata1 = soalSukuKata1;
            this.soalSukuKata2 = soalSukuKata2;
            this.soalSukuKata3 = soalSukuKata3;
        }

        @Override
        public int getCount() {
            return this.soalHuruf.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == (ConstraintLayout) object;
        }

        @SuppressLint("WrongConstant")
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            this.layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            View item_view = this.layoutInflater.inflate(R.layout.swipe_layout_2, container, false);

            txtSoalHuruf = (TextView) item_view.findViewById(R.id.txtHurufTerbuka);
            txtSoal1 = (TextView) item_view.findViewById(R.id.txtSoal1);
            txtSoal2 = (TextView) item_view.findViewById(R.id.txtSoal2);
            txtSoal3 = (TextView) item_view.findViewById(R.id.txtSoal3);

            EditText txtJwb1 = (EditText) item_view.findViewById(R.id.txtJawaban1);
            EditText txtJwb2 = (EditText) item_view.findViewById(R.id.txtJawaban2);
            EditText txtJwb3 = (EditText) item_view.findViewById(R.id.txtJawaban3);
            btnCheck = (Button) item_view.findViewById(R.id.btn_check_suku_kata_terbuka);

            txtSoalHuruf.setText(soalHuruf[position]);
            txtSoal1.setText(soalSukuKata1[position]);
            txtSoal2.setText(soalSukuKata2[position]);
            txtSoal3.setText(soalSukuKata3[position]);

            btnCheck.setOnClickListener(v -> {
                if (!txtJwb1.getText().toString().equals(soalSukuKata1[position])) {
                    Intent i = new Intent(SukuKataTerbukaActivity.this, PopupActivity.class);
                    i.putExtra("hasil", false);
                    startActivity(i);
                    playAudio(false);
                    txtJwb1.requestFocus();
                    Toast.makeText(SukuKataTerbukaActivity.this, " Nombor 1 Salah !", Toast.LENGTH_LONG).show();
                } else if (!txtJwb2.getText().toString().equals(soalSukuKata2[position])) {
                    Intent i = new Intent(SukuKataTerbukaActivity.this, PopupActivity.class);
                    i.putExtra("hasil", false);
                    startActivity(i);
                    playAudio(false);
                    txtJwb2.requestFocus();
                    Toast.makeText(SukuKataTerbukaActivity.this, " Nombor 2 Salah !", Toast.LENGTH_LONG).show();
                } else if (!txtJwb3.getText().toString().equals(soalSukuKata3[position])) {
                    Intent i = new Intent(SukuKataTerbukaActivity.this, PopupActivity.class);
                    i.putExtra("hasil", false);
                    startActivity(i);
                    playAudio(false);
                    txtJwb3.requestFocus();
                    Toast.makeText(SukuKataTerbukaActivity.this, " Nombor 3 Salah !", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(SukuKataTerbukaActivity.this, PopupActivity.class);
                    i.putExtra("hasil", true);
                    startActivity(i);
                    playAudio(true);

                }
            });

            container.addView(item_view);
            return item_view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((ConstraintLayout) object);
        }


    }
    public void playAudio(boolean value) {
        if (value) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.pandainya);
            mediaPlayer.start();
        } else {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.cuba_lagi2);
            mediaPlayer.start();
        }
    }
}
