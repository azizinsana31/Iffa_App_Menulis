package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
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

import org.w3c.dom.Text;

public class CantumPerkataan2Activity extends AppCompatActivity {
    CustomSwipeAdapter adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantum_perkataan2);

        int[] img = {R.drawable.bas, R.drawable.beg, R.drawable.pen, R.drawable.jam, R.drawable.kek, R.drawable.tin, R.drawable.jet, R.drawable. gol, R.drawable.ros};
        String[][] hurufAcak = {{"a", "s", "b"}, {"e", "g", "b"}, {"e", "p", "n"}, {"j", "m", "a"}, {"e", "k", "k"}, {"n", "t", "i"}, {"t", "j", "e"}, {"o", "g", "l"}, {"s", "r", "o"}};
        String[][] jawaban =   {{"b", "a", "s"}, {"b", "e", "g"}, {"p", "e", "n"}, {"j", "a", "m"}, {"k", "e", "k"}, {"t", "i", "n"}, {"j", "e", "t"}, {"g", "o", "l"}, {"r", "o", "s"}};

        adapter = new CustomSwipeAdapter(this, img, hurufAcak, jawaban);
        viewPager = (ViewPager) findViewById(R.id.vPagerPerkataan2);
        viewPager.setAdapter(adapter);
    }

    class CustomSwipeAdapter extends PagerAdapter{
        int[] images;
        String[][] hurufAcak;
        String[][] jawaban;
        Context context;
        LayoutInflater inflater;

        public CustomSwipeAdapter(Context ctx, int[] img, String[][] huruf, String[][] jawaban) {
            this.context = ctx;
            this.images = img;
            this.hurufAcak = huruf;
            this.jawaban = jawaban;
        }

        @SuppressLint("WrongConstant")
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            this.inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            View v = this.inflater.inflate(R.layout.swipe_layout_3_2, container, false);
            ImageView ivSoal = (ImageView) v.findViewById(R.id.ivSoalSusunKata);
            TextView txtHuruf1 = (TextView) v.findViewById(R.id.txtPerkataan2_1);
            TextView txtHuruf2 = (TextView) v.findViewById(R.id.txtPerkataan2_2);
            TextView txtHuruf3 = (TextView) v.findViewById(R.id.txtPerkataan2_3);
            EditText txtJawaban = (EditText) v.findViewById(R.id.txtJawabanPerkataan2);
            Button btnCheck = (Button) v.findViewById(R.id.btnCheckPerkataan2);
            Button btnReset = (Button) v.findViewById(R.id.btnResetPerkataan2);

            ivSoal.setImageResource(images[position]);
            txtHuruf1.setText(hurufAcak[position][0]);
            txtHuruf2.setText(hurufAcak[position][1]);
            txtHuruf3.setText(hurufAcak[position][2]);

            txtHuruf1.setOnClickListener(v1 -> {
                txtJawaban.append(hurufAcak[position][0]);
            });

            txtHuruf2.setOnClickListener(v1 -> {
                txtJawaban.append(hurufAcak[position][1]);
            });

            txtHuruf3.setOnClickListener(v1 -> {
                txtJawaban.append(hurufAcak[position][2]);
            });

            btnCheck.setOnClickListener(v1 -> {
                String answ = jawaban[position][0] + jawaban[position][1] + jawaban[position][2];
                Toast.makeText(CantumPerkataan2Activity.this, jawaban + "\n" + txtJawaban.getText().toString(), Toast.LENGTH_LONG).show();
                if (txtJawaban.getText().toString().equals(answ)){
                    Intent i = new Intent(CantumPerkataan2Activity.this, PopupActivity.class);
                    i.putExtra("hasil", true);
                    startActivity(i);
                    playAudio(true);
                }
                else{
                    Intent i = new Intent(CantumPerkataan2Activity.this, PopupActivity.class);
                    i.putExtra("hasil", false);
                    startActivity(i);
                    playAudio(false);
                }
            });

            btnReset.setOnClickListener(v1 -> {
                txtJawaban.setText("");
            });

            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((ConstraintLayout) object);
        }

        @Override
        public int getCount() {
            return this.images.length;
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