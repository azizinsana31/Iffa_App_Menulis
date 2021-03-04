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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CantumAyat3Activity extends AppCompatActivity {
    CustomSwipeAdapter adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantum_ayat3);

        int[] soal = {R.drawable.budak_lelaki, R.drawable.budak_perempuan};
        String[] jawabanSoal ={"Saya budak lelaki", "Saya budak perempuan"};

        viewPager = (ViewPager) findViewById(R.id.vPagerAyat3);
        adapter = new CustomSwipeAdapter(this, soal, jawabanSoal);
        viewPager.setAdapter(adapter);
    }

    class CustomSwipeAdapter extends PagerAdapter{
        LayoutInflater inflater;
        int[] soal;
        String[] jawaban;
        Context context;

        public CustomSwipeAdapter(Context context, int[] gambar,String[] jawaban) {
            this.soal=gambar;
            this.jawaban=jawaban;
            this.context=context;
        }

        @SuppressLint({"WrongViewCast", "WrongConstant" } )
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            View view = inflater.inflate(R.layout.swipe_layout_4_3, container, false);
            ImageView ivSoal = (ImageView) view.findViewById(R.id.iv_gambar_soal);
            TextView txtSoal = (TextView) view.findViewById(R.id.txtSoalanAyat3);
            EditText txtJawaban = (EditText) view.findViewById(R.id.txtJawabanAyat3);
            Button btnCheck = (Button) view.findViewById(R.id.btnCheckAyat3);

            ivSoal.setImageResource(soal[position]);
            txtSoal.setText(jawaban[position]);

            btnCheck.setOnClickListener(v -> {
                if (txtJawaban.getText().toString().toLowerCase().equals(jawaban[position].toLowerCase())){
                    Intent i = new Intent(CantumAyat3Activity.this, PopupActivity.class);
                    i.putExtra("hasil", true);
                    startActivity(i);
                    playAudio(true);

                }
                else{
                    Intent i = new Intent(CantumAyat3Activity.this, PopupActivity.class);
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
            return this.soal.length;
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
