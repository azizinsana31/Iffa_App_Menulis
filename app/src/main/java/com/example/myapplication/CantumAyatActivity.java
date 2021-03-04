package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CantumAyatActivity extends AppCompatActivity {
    CustomSwipeAdapter adapter;
    ViewPager vPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantum_ayat);

        String[] soal = {"Kasut sekolah Adam telah", "Adam memotong kukunya supaya",
                "Emak memilih tuala yang"};
        Integer[] img1 = {R.drawable.sepatu_hitam, R.drawable.adam_memotong_kuku, R.drawable.mama_memilih_handuk};
        Integer[] suara = {R.raw.kasut_sekolah_adam_telah_ketat, R.raw.adam_memotong_kukunya_supaya_pendek, R.raw.emak_memilih_tuala_yang_lembut};
        String[][] jawaban = {{"Longgar", "Ketat", "Lebar"}, {"Pendek", "Panjang", "Kecil"}, {"Kesat", "Kasar", "Lembut"}};
        int[] posisi_jawaban = {1,0,2 };

        vPager = (ViewPager) findViewById(R.id.vPagerAyat);
        adapter = new CustomSwipeAdapter(this, soal, img1, jawaban, suara, posisi_jawaban);
        vPager.setAdapter(adapter);
    }

    class CustomSwipeAdapter extends PagerAdapter{
        String[] soal;
        Integer[] img1;
        Integer[] suara;
        String[][] jawaban;
        LayoutInflater inflater;
        Context mContext;
        int[] posisi_jawaban;
        int pilihan;

        public CustomSwipeAdapter(Context mContext,String[] soal, Integer[] img1,  String[][] jawaban, Integer[] suara, int[] pos) {
            this.soal = soal;
            this.img1 = img1;
            this.suara = suara;
            this.jawaban = jawaban;
            this.mContext = mContext;
            this.posisi_jawaban= pos;
        }

        @Override
        public int getCount() {
            return this.soal.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == ((LinearLayout) object);
        }

        @SuppressLint("WrongConstant")
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            this.inflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            View item_view = this.inflater.inflate(R.layout.swipe_layout_4, container, false);
            ImageView iv1= (ImageView) item_view.findViewById(R.id.iv1_ayat);
            TextView soalan= (TextView) item_view.findViewById(R.id.soalan);
            EditText jawabanAyat= (EditText) item_view.findViewById(R.id.jawabanAyat);
            Button jawaban1= (Button) item_view.findViewById(R.id.btnJawaban1);
            Button jawaban2= (Button) item_view.findViewById(R.id.btnJawaban2);
            Button jawaban3= (Button) item_view.findViewById(R.id.btnJawaban3);
            Button btncekayat= (Button) item_view.findViewById(R.id.btnCheckAyat);
            Button btnsuarakayat= (Button) item_view.findViewById(R.id.btnSuarakAyat);
            iv1.setImageResource(img1[position]);
            soalan.setText(soal[position]);
            jawaban1.setText(jawaban[position][0]);
            jawaban2.setText(jawaban[position][1]);
            jawaban3.setText(jawaban[position][2]);

            jawaban1.setOnClickListener(v -> {
                jawabanAyat.setText(jawaban[position][0]);
                pilihan=0;
            });
            jawaban2.setOnClickListener(v -> {
                jawabanAyat.setText(jawaban[position][1]);
                pilihan=1;
            });
            jawaban3.setOnClickListener(v -> {
                jawabanAyat.setText(jawaban[position][2]);
                pilihan=2;
            });
            btncekayat.setOnClickListener(v -> {
                if (pilihan == posisi_jawaban [position]){
                    Toast.makeText(CantumAyatActivity.this,"Betul", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(CantumAyatActivity.this,"Salah", Toast.LENGTH_SHORT).show();
                }
            });
            btnsuarakayat.setOnClickListener(v -> {
                MediaPlayer mediaPlayer = MediaPlayer.create(CantumAyatActivity.this, suara[position]);
                mediaPlayer.start(); // no need to call prepare(); create() does that for you

            });

            container.addView(item_view);
            return item_view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((LinearLayout) object);
        }
    }
}