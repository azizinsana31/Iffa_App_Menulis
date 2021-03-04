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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CantumPerkataanActivity extends AppCompatActivity {
    CustomSwipeAdapter adapter;
    ViewPager vPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantum_perkataan);

        String[][] soalan = {{"Adam menggunakan","untuk"}, {"Adam menggunakan", "untuk"}, {"Adam menggunakan", "untuk"}};
        String[][] jawaban = {{"brush gigi", "gosok gigi"}, {"sabun", "mencuci badannya"}, {"syampu", "mencuci rambutnya"}};
        Integer[] gambar1 = {R.drawable.brush_gigi, R.drawable.sabun, R.drawable.sampo};
        Integer[] gambar2 = {R.drawable.sikat_gigi_bersih, R.drawable.orang_cuci_tangan, R.drawable.orang_sampo};
        Integer[] suara = {R.raw.adam_gosok_gigi, R.raw.adam_cuci_tangan, R.raw.adam_mandi_syampu};

        vPager = (ViewPager) findViewById(R.id.vPagerPerkataan);
        adapter = new CustomSwipeAdapter(this, soalan, jawaban, gambar1, gambar2, suara);
        vPager.setAdapter(adapter);
    }

    class CustomSwipeAdapter extends PagerAdapter {
        String[][] soal;
        String[][] jawaban;
        Integer[] img1;
        Integer[] img2;
        Integer[] suara;
        LayoutInflater inflater;
        Context mContext;

        CustomSwipeAdapter(Context ctx, String[][] soal, String[][] jawaban, Integer[] gambar1, Integer[] gambar2, Integer[] suara){
            this.mContext = ctx;
            this.soal = soal;
            this.jawaban = jawaban;
            this.img1 = gambar1;
            this.img2 = gambar2;
            this.suara = suara;
        }

        @SuppressLint("WrongConstant")
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            this.inflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            View item_view = this.inflater.inflate(R.layout.swipe_layout_3, container, false);
            ImageView iv1 = (ImageView) item_view.findViewById(R.id.iv1_perkataan);
            ImageView iv2 = (ImageView) item_view.findViewById(R.id.iv2_perkataan);
            TextView tv1 = (TextView) item_view.findViewById(R.id.tvPerkataan1);
            TextView tv2 = (TextView) item_view.findViewById(R.id.tvPerkataan2);
            Button btnSuara = (Button) item_view.findViewById(R.id.btnSuara);
            Button btnCheck = (Button) item_view.findViewById(R.id.btnCheckCantumPerkataan);

            iv1.setImageResource(img1[position]);
            iv2.setImageResource(img2[position]);
            tv1.setText(soal[position][0]);

            btnSuara.setOnClickListener(v -> {
                MediaPlayer mp = MediaPlayer.create(CantumPerkataanActivity.this, suara[position]);
                mp.start();
            });

            container.addView(item_view);
            return item_view;
        }

        @Override
        public int getCount() {
            return this.soal.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((LinearLayout) object);
        }
    }
}