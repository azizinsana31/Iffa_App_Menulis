package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

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

public class SukuKataTertutupActivity extends AppCompatActivity {
    ViewPager vPager;
    CustomSwipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suku_kata_tertutup);

        String[] soal = {"bab", "cab", "dab"};

        vPager = (ViewPager) findViewById(R.id.vPagerSukuKataTertutup);
        adapter = new CustomSwipeAdapter(soal,this);
        vPager.setAdapter(adapter);
    }

    class CustomSwipeAdapter extends PagerAdapter{
        String[] soalSukuKataTertutup;
        String[] jawabanSoal;
        LayoutInflater inlLayoutInflater;
        Context ctx;

        TextView tvSoal;

        CustomSwipeAdapter(String[] soal, Context context){
            this.soalSukuKataTertutup = soal;
            this.jawabanSoal = soal;
            this.ctx = context;
        }

        @SuppressLint("WrongConstant")
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            this.inlLayoutInflater = (LayoutInflater) this.ctx.getSystemService("layout_inflater");
            View view = this.inlLayoutInflater.inflate(R.layout.swipe_layout_2_2, container, false);
            tvSoal = (TextView) view.findViewById(R.id.txtSoalSukuKataTertutup);
            EditText editTextJawaban1 = (EditText) view.findViewById(R.id.jawaban1);
            EditText editTextJawaban2 = (EditText) view.findViewById(R.id.jawaban2);
            EditText editTextJawaban3 = (EditText) view.findViewById(R.id.jawaban3);
            Button btnCheck = (Button) view.findViewById(R.id.btn_check_suku_kata_tertutup);

            tvSoal.setText(soalSukuKataTertutup[position]);
            btnCheck.setOnClickListener(v -> {
                String jawaban = editTextJawaban1.getText().toString() + editTextJawaban2.getText().toString() + editTextJawaban3.getText().toString();
                if(jawaban.equals(jawabanSoal[position])){
                    Intent i = new Intent(SukuKataTertutupActivity.this, PopupActivity.class);
                    i.putExtra("hasil", true);
                    startActivity(i);
                    playAudio(true);
                }
                else{
                    Intent i = new Intent(SukuKataTertutupActivity.this, PopupActivity.class);
                    i.putExtra("hasil", false);
                    startActivity(i);
                    playAudio(false);
                }
            });

            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((ConstraintLayout) object);
        }

        @Override
        public int getCount() {
            return this.soalSukuKataTertutup.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == (ConstraintLayout) object;
        }
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