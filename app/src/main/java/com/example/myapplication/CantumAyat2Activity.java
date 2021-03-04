package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CantumAyat2Activity extends AppCompatActivity {
    CustomSwipeAdapter adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantum_ayat2);

        int[][] img = { {R.drawable.sekolah, R.drawable.penulis, R.drawable.buku, R.drawable.ikan},
                        {R.drawable.ros, R.drawable.gol, R.drawable.televisi, R.drawable.kucing},
                        {R.drawable.jam, R.drawable.penjaga, R.drawable.padang, R.drawable.arnab},
                        {R.drawable.stesen_bas, R.drawable.meja, R.drawable.guru, R.drawable.ikan}
        };

        String[][] text = { {"Sekolah", "Penulis", "Buku", "Ikan"},
                            {"Ros", "Gol", "Televisi", "Kucing"},
                            {"Jam", "Penjaga", "Padang", "Arnab"},
                            {"Stesen", "Meja", "Guru", "Ikan"}
        };

        adapter = new CustomSwipeAdapter(this, img, text);
        viewPager = (ViewPager) findViewById(R.id.vPagerAyat2);
        viewPager.setAdapter(adapter);
    }

    class CustomSwipeAdapter extends PagerAdapter{

        int[][] imagesJawaban;
        String[] kategori = {"Benda", "Binatang", "Orang", "Tempat"};
        LayoutInflater layoutInflater;
        Context context;
        String[][] textJawaban;
        int[] jawaban =  {3, 4, 2, 3};
        int pilihJawaban;

        CustomSwipeAdapter(Context ctx, int[][] img, String[][] text){
            this.context = ctx;
            this.imagesJawaban = img;
            this.textJawaban = text;
        }

        @SuppressLint({"WrongConstant", "ResourceAsColor", "WrongViewCast"})
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            View view = layoutInflater.inflate(R.layout.swipe_layout_4_2, container, false);
            CardView card1 = (CardView) view.findViewById(R.id.gambar1);
            CardView card2 = (CardView) view.findViewById(R.id.gambar2);
            CardView card3 = (CardView) view.findViewById(R.id.gambar3);
            CardView card4 = (CardView) view.findViewById(R.id.gambar4);

            TextView txtJudul = (TextView) view.findViewById(R.id.txtJudul);
            TextView textview1 = (TextView) view.findViewById(R.id.tulisan1);
            TextView textview2 = (TextView) view.findViewById(R.id.tulisan2);
            TextView textview3 = (TextView) view.findViewById(R.id.tulisan3);
            TextView textview4 = (TextView) view.findViewById(R.id.tulisan4);

            ImageView ivGambar1 = (ImageView) view.findViewById(R.id.img1);
            ImageView ivGambar2 = (ImageView) view.findViewById(R.id.img2);
            ImageView ivGambar3 = (ImageView) view.findViewById(R.id.img3);
            ImageView ivGambar4 = (ImageView) view.findViewById(R.id.img4);

            Button btncek= (Button) view.findViewById(R.id.btnCheckAyat2);

            txtJudul.setText(kategori[position]);

            ivGambar1.setImageResource(imagesJawaban[position][0]);
            ivGambar2.setImageResource(imagesJawaban[position][1]);
            ivGambar3.setImageResource(imagesJawaban[position][2]);
            ivGambar4.setImageResource(imagesJawaban[position][3]);

            textview1.setText(textJawaban[position][0]);
            textview2.setText(textJawaban[position][1]);
            textview3.setText(textJawaban[position][2]);
            textview4.setText(textJawaban[position][3]);

            card1.setOnClickListener(v -> {
                pilihJawaban = 1;
                card1.setCardBackgroundColor(Color.rgb(153, 255, 204));
                card2.setCardBackgroundColor(Color.rgb(255, 255, 255));
                card3.setCardBackgroundColor(Color.rgb(255, 255, 255));
                card4.setCardBackgroundColor(Color.rgb(255, 255, 255));
            });

            card2.setOnClickListener(v -> {
                pilihJawaban = 2;
                card1.setCardBackgroundColor(Color.rgb(255, 255, 255));
                card2.setCardBackgroundColor(Color.rgb(153, 255, 204));
                card3.setCardBackgroundColor(Color.rgb(255, 255, 255));
                card4.setCardBackgroundColor(Color.rgb(255, 255, 255));
            });

            card3.setOnClickListener(v -> {
                pilihJawaban = 3;
                card1.setCardBackgroundColor(Color.rgb(255, 255, 255));
                card2.setCardBackgroundColor(Color.rgb(255, 255, 255));
                card3.setCardBackgroundColor(Color.rgb(153, 255, 204));
                card4.setCardBackgroundColor(Color.rgb(255, 255, 255));
            });

            card4.setOnClickListener(v -> {
                pilihJawaban = 4;
                card1.setCardBackgroundColor(Color.rgb(255, 255, 255));
                card2.setCardBackgroundColor(Color.rgb(255, 255, 255));
                card3.setCardBackgroundColor(Color.rgb(255, 255, 255));
                card4.setCardBackgroundColor(Color.rgb(153, 255, 204));
            });

            btncek.setOnClickListener(v -> {
                if (pilihJawaban == jawaban[position]){
                    Intent i = new Intent(CantumAyat2Activity.this, PopupActivity.class);
                    i.putExtra("hasil", true);
                    startActivity(i);
                    playAudio(true);
                }
                else {
                    Intent i = new Intent(CantumAyat2Activity.this, PopupActivity.class);
                    i.putExtra("hasil", false);
                    startActivity(i);
                    playAudio(false);
                }
            });

            container. addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((ConstraintLayout) object);
        }

        @Override
        public int getCount() {
            return kategori.length;
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