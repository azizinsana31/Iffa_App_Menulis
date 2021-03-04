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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import javax.crypto.BadPaddingException;

public class PadaanHurufActivity extends AppCompatActivity {
    CustomSwipeAdapter adapter;
    ViewPager vPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_padaan_huruf);

        Bundle i = getIntent().getExtras();
        final String strMode = i.getString("Mode");

        /* Pilihan Jawaban
         * Ada 3 huruf jawaban yang akan tampil setiap 1 huruf dan ada 1 sebagai jawaban
         * hurufJawaban1 untuk jawaban yang di sebelah kiri
         * hurufJawaban2 untuk jawaban yang di tengah
         * hurufJawaban3 untuk jawaban yang di kanan
         * */
                                        //A                                        //B                                        //C                                        //D                                        //E                                        //F                                         //G                                       //H                                        //I                                        //J                                        //K                                        //L                                        //M                                        //N                                        //O                                        //P                                        //Q                                        //R                                        //S                                        //T                                        //U                                        //V                                        //W                                        //X                                        //Y                                        //Z
        Integer[] hurufBesarJawaban1 = {Integer.valueOf((int) R.drawable.a_besar), Integer.valueOf((int) R.drawable.d_besar), Integer.valueOf((int) R.drawable.a_besar), Integer.valueOf((int) R.drawable.f_besar), Integer.valueOf((int) R.drawable.e_besar), Integer.valueOf((int) R.drawable.a_besar), Integer.valueOf((int) R.drawable.h_besar), Integer.valueOf((int) R.drawable.j_besar), Integer.valueOf((int) R.drawable.i_besar), Integer.valueOf((int) R.drawable.j_besar), Integer.valueOf((int) R.drawable.a_besar), Integer.valueOf((int) R.drawable.q_besar), Integer.valueOf((int) R.drawable.k_besar), Integer.valueOf((int) R.drawable.n_besar), Integer.valueOf((int) R.drawable.a_besar), Integer.valueOf((int) R.drawable.p_besar), Integer.valueOf((int) R.drawable.q_besar), Integer.valueOf((int) R.drawable.a_besar), Integer.valueOf((int) R.drawable.s_besar), Integer.valueOf((int) R.drawable.u_besar), Integer.valueOf((int) R.drawable.w_besar), Integer.valueOf((int) R.drawable.v_besar), Integer.valueOf((int) R.drawable.e_besar), Integer.valueOf((int) R.drawable.x_besar), Integer.valueOf((int) R.drawable.d_besar), Integer.valueOf((int) R.drawable.y_besar)};
        Integer[] hurufBesarJawaban2 = {Integer.valueOf((int) R.drawable.b_besar), Integer.valueOf((int) R.drawable.c_besar), Integer.valueOf((int) R.drawable.c_besar), Integer.valueOf((int) R.drawable.d_besar), Integer.valueOf((int) R.drawable.x_besar), Integer.valueOf((int) R.drawable.c_besar), Integer.valueOf((int) R.drawable.u_besar), Integer.valueOf((int) R.drawable.l_besar), Integer.valueOf((int) R.drawable.w_besar), Integer.valueOf((int) R.drawable.q_besar), Integer.valueOf((int) R.drawable.z_besar), Integer.valueOf((int) R.drawable.u_besar), Integer.valueOf((int) R.drawable.p_besar), Integer.valueOf((int) R.drawable.o_besar), Integer.valueOf((int) R.drawable.o_besar), Integer.valueOf((int) R.drawable.w_besar), Integer.valueOf((int) R.drawable.r_besar), Integer.valueOf((int) R.drawable.z_besar), Integer.valueOf((int) R.drawable.y_besar), Integer.valueOf((int) R.drawable.s_besar), Integer.valueOf((int) R.drawable.u_besar), Integer.valueOf((int) R.drawable.g_besar), Integer.valueOf((int) R.drawable.q_besar), Integer.valueOf((int) R.drawable.s_besar), Integer.valueOf((int) R.drawable.f_besar), Integer.valueOf((int) R.drawable.z_besar)};
        Integer[] hurufBesarJawaban3 = {Integer.valueOf((int) R.drawable.e_besar), Integer.valueOf((int) R.drawable.b_besar), Integer.valueOf((int) R.drawable.u_besar), Integer.valueOf((int) R.drawable.g_besar), Integer.valueOf((int) R.drawable.z_besar), Integer.valueOf((int) R.drawable.f_besar), Integer.valueOf((int) R.drawable.g_besar), Integer.valueOf((int) R.drawable.h_besar), Integer.valueOf((int) R.drawable.z_besar), Integer.valueOf((int) R.drawable.c_besar), Integer.valueOf((int) R.drawable.k_besar), Integer.valueOf((int) R.drawable.l_besar), Integer.valueOf((int) R.drawable.m_besar), Integer.valueOf((int) R.drawable.t_besar), Integer.valueOf((int) R.drawable.x_besar), Integer.valueOf((int) R.drawable.z_besar), Integer.valueOf((int) R.drawable.u_besar), Integer.valueOf((int) R.drawable.r_besar), Integer.valueOf((int) R.drawable.a_besar), Integer.valueOf((int) R.drawable.t_besar), Integer.valueOf((int) R.drawable.z_besar), Integer.valueOf((int) R.drawable.e_besar), Integer.valueOf((int) R.drawable.w_besar), Integer.valueOf((int) R.drawable.l_besar), Integer.valueOf((int) R.drawable.y_besar), Integer.valueOf((int) R.drawable.f_besar)};

                                        //a                                        //b                                        //c                                        //d                                        //e                                        //f                                        //g                                        //h                                        //i                                        //j                                        //k                                        //l                                        //m                                        //n                                        //o                                        //p                                        //q                                        //r                                        //s                                        //t                                        //u                                        //v                                        //w                                        //x                                        //y                                        //z
        Integer[] hurufKecilJawaban1 = {Integer.valueOf((int) R.drawable.a_kecil), Integer.valueOf((int) R.drawable.d_kecil), Integer.valueOf((int) R.drawable.a_kecil), Integer.valueOf((int) R.drawable.f_kecil), Integer.valueOf((int) R.drawable.e_kecil), Integer.valueOf((int) R.drawable.a_kecil), Integer.valueOf((int) R.drawable.h_kecil), Integer.valueOf((int) R.drawable.j_kecil), Integer.valueOf((int) R.drawable.i_kecil), Integer.valueOf((int) R.drawable.j_kecil), Integer.valueOf((int) R.drawable.a_kecil), Integer.valueOf((int) R.drawable.q_kecil), Integer.valueOf((int) R.drawable.k_kecil), Integer.valueOf((int) R.drawable.n_kecil), Integer.valueOf((int) R.drawable.a_kecil), Integer.valueOf((int) R.drawable.p_kecil), Integer.valueOf((int) R.drawable.q_kecil), Integer.valueOf((int) R.drawable.a_kecil), Integer.valueOf((int) R.drawable.s_kecil), Integer.valueOf((int) R.drawable.u_kecil), Integer.valueOf((int) R.drawable.w_kecil), Integer.valueOf((int) R.drawable.v_kecil), Integer.valueOf((int) R.drawable.e_kecil), Integer.valueOf((int) R.drawable.x_kecil), Integer.valueOf((int) R.drawable.d_kecil), Integer.valueOf((int) R.drawable.y_kecil)};
        Integer[] hurufKecilJawaban2 = {Integer.valueOf((int) R.drawable.b_kecil), Integer.valueOf((int) R.drawable.c_kecil), Integer.valueOf((int) R.drawable.c_kecil), Integer.valueOf((int) R.drawable.d_kecil), Integer.valueOf((int) R.drawable.x_kecil), Integer.valueOf((int) R.drawable.c_kecil), Integer.valueOf((int) R.drawable.u_kecil), Integer.valueOf((int) R.drawable.l_kecil), Integer.valueOf((int) R.drawable.w_kecil), Integer.valueOf((int) R.drawable.q_kecil), Integer.valueOf((int) R.drawable.z_kecil), Integer.valueOf((int) R.drawable.u_kecil), Integer.valueOf((int) R.drawable.p_kecil), Integer.valueOf((int) R.drawable.o_kecil), Integer.valueOf((int) R.drawable.o_kecil), Integer.valueOf((int) R.drawable.w_kecil), Integer.valueOf((int) R.drawable.r_kecil), Integer.valueOf((int) R.drawable.z_kecil), Integer.valueOf((int) R.drawable.y_kecil), Integer.valueOf((int) R.drawable.s_kecil), Integer.valueOf((int) R.drawable.u_kecil), Integer.valueOf((int) R.drawable.g_kecil), Integer.valueOf((int) R.drawable.q_kecil), Integer.valueOf((int) R.drawable.s_kecil), Integer.valueOf((int) R.drawable.f_kecil), Integer.valueOf((int) R.drawable.z_kecil)};
        Integer[] hurufKecilJawaban3 = {Integer.valueOf((int) R.drawable.e_kecil), Integer.valueOf((int) R.drawable.b_kecil), Integer.valueOf((int) R.drawable.u_kecil), Integer.valueOf((int) R.drawable.g_kecil), Integer.valueOf((int) R.drawable.z_kecil), Integer.valueOf((int) R.drawable.f_kecil), Integer.valueOf((int) R.drawable.g_kecil), Integer.valueOf((int) R.drawable.h_kecil), Integer.valueOf((int) R.drawable.z_kecil), Integer.valueOf((int) R.drawable.c_kecil), Integer.valueOf((int) R.drawable.k_kecil), Integer.valueOf((int) R.drawable.l_kecil), Integer.valueOf((int) R.drawable.m_kecil), Integer.valueOf((int) R.drawable.t_kecil), Integer.valueOf((int) R.drawable.x_kecil), Integer.valueOf((int) R.drawable.z_kecil), Integer.valueOf((int) R.drawable.u_kecil), Integer.valueOf((int) R.drawable.r_kecil), Integer.valueOf((int) R.drawable.a_kecil), Integer.valueOf((int) R.drawable.t_kecil), Integer.valueOf((int) R.drawable.z_kecil), Integer.valueOf((int) R.drawable.e_kecil), Integer.valueOf((int) R.drawable.w_kecil), Integer.valueOf((int) R.drawable.l_kecil), Integer.valueOf((int) R.drawable.y_kecil), Integer.valueOf((int) R.drawable.f_kecil)};

        // Load Semua Jawaban
        Integer[][] jawaban = new Integer[3][];

        /* Mengatur Posisi Jawaban
         * 1 = jawaban terletak di sebelah kiri
         * 2 = jawaban terletak di tengah
         * 3 = jawaban terletak di sebelah kanan
         */
//        int[] posJawabanHurufBesar = {0, 2, 1, 1, 0, 2, 2, 2, 0, 0,
//                                      2, 2, 2, 0, 1, 0, 0, 2, 0, 2,
//                                      1, 0, 2, 0, 2, 1
//        };
        int[] posJawaban = {0, 2, 1, 1, 0, 2, 2, 2, 0, 0,
                          2, 2, 2, 0, 1, 0, 0, 2, 0, 2,
                          1, 0, 2, 0, 2, 1
        };

        //  Alfabet yang dijadikan soal untuk di padankan
        Integer[] soal1 = {
                                R.drawable.a_besar, R.drawable.b_besar, R.drawable.c_besar,
                                R.drawable.d_besar, R.drawable.e_besar, R.drawable.f_besar,
                                R.drawable.g_besar, R.drawable.h_besar, R.drawable.i_besar,
                                R.drawable.j_besar, R.drawable.k_besar, R.drawable.l_besar,
                                R.drawable.m_besar, R.drawable.n_besar, R.drawable.o_besar,
                                R.drawable.p_besar, R.drawable.q_besar, R.drawable.r_besar,
                                R.drawable.s_besar, R.drawable.t_besar, R.drawable.u_besar,
                                R.drawable.v_besar, R.drawable.w_besar, R.drawable.x_besar,
                                R.drawable.y_besar, R.drawable.z_besar
        };

        Integer[] soal2 = {
                                R.drawable.a_kecil, R.drawable.b_kecil, R.drawable.c_kecil,
                                R.drawable.d_kecil, R.drawable.e_kecil, R.drawable.f_kecil,
                                R.drawable.g_kecil, R.drawable.h_kecil, R.drawable.i_kecil,
                                R.drawable.j_kecil, R.drawable.k_kecil, R.drawable.l_kecil,
                                R.drawable.m_kecil, R.drawable.n_kecil, R.drawable.o_kecil,
                                R.drawable.p_kecil, R.drawable.q_kecil, R.drawable.r_kecil,
                                R.drawable.s_kecil, R.drawable.t_kecil, R.drawable.u_kecil,
                                R.drawable.v_kecil, R.drawable.w_kecil, R.drawable.x_kecil,
                                R.drawable.y_kecil, R.drawable.z_kecil
        };

        Integer[] hurufSoal = null;
        String[] value = null;

        if(strMode.equals("padaan huruf kecil")){
            hurufSoal = soal2; // Apabila mode padaan huruf kecil
            value = new String[] {
                                   "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                                   "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                                   "u", "v", "w", "x", "y", "z"
            };
            jawaban[0] = hurufBesarJawaban1;
            jawaban[1] = hurufBesarJawaban2;
            jawaban[2] = hurufBesarJawaban3;

        }
        else if(strMode.equals("padaan huruf besar")){
            hurufSoal = soal1; // Apabila mode padaan huruf besar.
            value = new String[] {
                                  "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                                  "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                                  "U", "V", "W", "X", "Y", "Z"
            };
            jawaban[0] = hurufKecilJawaban1;
            jawaban[1] = hurufKecilJawaban2;
            jawaban[2] = hurufKecilJawaban3;
        }
        else{
            System.exit(0);
        }

        // Eksekusi View Pager
        try{
            vPager = (ViewPager) findViewById(R.id.viewPager);
            adapter = new CustomSwipeAdapter(this, hurufSoal, value, jawaban, posJawaban);
            vPager.setAdapter(adapter);
        }
        catch (Exception ex){
            Log.e("Error" , String.valueOf(ex.getStackTrace()));
        }

    }

    public class CustomSwipeAdapter extends PagerAdapter {
        Integer[][] hurufJawabanImage;
        Integer[] imageSource;
        LayoutInflater layoutInflater;
        Context mContext;
        int[] pos_jwb;
        int jawaban;
        String[] val;

        CustomSwipeAdapter(Context ctx, Integer[] imageSource2,String[] value, Integer[][] hurufJawaban , int[] posisi_jawaban) {
            this.mContext = ctx;
            this.imageSource = imageSource2;
            this.hurufJawabanImage = hurufJawaban;
            this.pos_jwb = posisi_jawaban;
            this.val = value;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.imageSource.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == ((ConstraintLayout) object);
        }

        @SuppressLint("WrongConstant")
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            this.layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            View item_view = this.layoutInflater.inflate(R.layout.swipe_layout, container, false);
            final ImageView iv2 = (ImageView) item_view.findViewById(R.id.iv2);
            ImageView img3 = (ImageView) item_view.findViewById(R.id.iv3);
            ImageView img4 = (ImageView) item_view.findViewById(R.id.iv4);
            ImageView img5 = (ImageView) item_view.findViewById(R.id.iv5);

            ((ImageView) item_view.findViewById(R.id.iv1)).setImageResource(this.imageSource[position].intValue());
            img3.setImageResource(this.hurufJawabanImage[0][position].intValue());
            img4.setImageResource(this.hurufJawabanImage[1][position].intValue());
            img5.setImageResource(this.hurufJawabanImage[2][position].intValue());

            img3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iv2.setImageResource(CustomSwipeAdapter.this.hurufJawabanImage[0][position].intValue());
                    CustomSwipeAdapter.this.jawaban = 0;
                }
            });

            img4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iv2.setImageResource(CustomSwipeAdapter.this.hurufJawabanImage[1][position].intValue());
                    CustomSwipeAdapter.this.jawaban = 1;
                }
            });

            img5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iv2.setImageResource(CustomSwipeAdapter.this.hurufJawabanImage[2][position].intValue());
                    CustomSwipeAdapter.this.jawaban = 2;
                }
            });

            ((Button) item_view.findViewById(R.id.buttonCheck)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (CustomSwipeAdapter.this.pos_jwb[position] == CustomSwipeAdapter.this.jawaban){
                        Intent i = new Intent(PadaanHurufActivity.this, PopupActivity.class);
                        i.putExtra("hasil", true);
                        startActivity(i);
                        playAudio(true);
                    }
                    else {
                        Intent i = new Intent(PadaanHurufActivity.this, PopupActivity.class);
                        i.putExtra("hasil", false);
                        startActivity(i);
                        playAudio(false);
                    }
                }
            });
            container.addView(item_view);
            return item_view;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((ConstraintLayout) object);
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