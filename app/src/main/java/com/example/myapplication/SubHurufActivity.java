package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

public class SubHurufActivity extends AppCompatActivity {
    TextView textView;
    ImageView ivAnimasi;
    EditText txtJawaban;
    String[] huruf;
    Button btnSuara, btnCheckHuruf;
    int[] animasi, bunyi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_huruf);
        int[] anim_huruf_besar = {
                R.drawable.anim_a_besar, R.drawable.anim_b_besar, R.drawable.anim_c_besar,
                R.drawable.anim_d_besar, R.drawable.anim_e_besar, R.drawable.anim_f_besar,
                R.drawable.anim_g_besar, R.drawable.anim_h_besar, R.drawable.anim_i_besar,
                R.drawable.anim_j_besar, R.drawable.anim_k_besar, R.drawable.anim_l_besar,
                R.drawable.anim_m_besar, R.drawable.anim_n_besar, R.drawable.anim_o_besar,
                R.drawable.anim_p_besar, R.drawable.anim_q_besar, R.drawable.anim_r_besar,
                R.drawable.anim_s_besar, R.drawable.anim_t_besar, R.drawable.anim_u_besar,
                R.drawable.anim_v_besar, R.drawable.anim_w_besar, R.drawable.anim_x_besar,
                R.drawable.anim_y_besar, R.drawable.anim_z_besar
        };

        int[] anim_huruf_kecil = {
                R.drawable.anim_a_kecil, R.drawable.anim_b_kecil, R.drawable.anim_c_kecil,
                R.drawable.anim_d_kecil, R.drawable.anim_e_kecil, R.drawable.anim_f_kecil,
                R.drawable.anim_g_kecil, R.drawable.anim_h_kecil, R.drawable.anim_i_kecil,
                R.drawable.anim_j_kecil, R.drawable.anim_k_kecil, R.drawable.anim_l_kecil,
                R.drawable.anim_m_besar, R.drawable.anim_n_kecil, R.drawable.anim_o_kecil,
                R.drawable.anim_p_kecil, R.drawable.anim_q_kecil, R.drawable.anim_r_kecil,
                R.drawable.anim_s_kecil, R.drawable.anim_t_kecil, R.drawable.anim_u_kecil,
                R.drawable.anim_v_kecil, R.drawable.anim_w_kecil, R.drawable.anim_x_kecil,
                R.drawable.anim_y_kecil, R.drawable.anim_z_kecil
        };

        int[] bunyi_huruf = {
                R.raw.bunyi_a, R.raw.bunyi_b, R.raw.bunyi_c, R.raw.bunyi_d, R.raw.bunyi_e,
                R.raw.bunyi_f, R.raw.bunyi_g, R.raw.bunyi_h, R.raw.bunyi_i, R.raw.bunyi_j,
                R.raw.buyi_k,  R.raw.buyi_l,  R.raw.buyi_m,  R.raw.buyi_n,  R.raw.buyi_o,
                R.raw.buyi_p,  R.raw.buyi_q,  R.raw.buyi_r,  R.raw.buyi_s,  R.raw.buyi_t,
                R.raw.buyi_u,  R.raw.buyi_v,  R.raw.buyi_w,  R.raw.buyi_x,  R.raw.buyi_y,
                R.raw.buyi_z
        };

        int[] bunyi_huruf_vokal = {
                R.raw.bunyi_a,  R.raw.bunyi_a,  R.raw.bunyi_i,  R.raw.bunyi_i, R.raw.buyi_u, R.raw.buyi_u,
                R.raw.bunyi_e, R.raw.bunyi_e, R.raw.buyi_o, R.raw.buyi_o
        };

        int[] bunyi_huruf_konsonan = {
                R.raw.bunyi_b, R.raw.bunyi_b, R.raw.bunyi_c, R.raw.bunyi_c, R.raw.bunyi_d, R.raw.bunyi_d,
                R.raw.bunyi_f, R.raw.bunyi_f, R.raw.bunyi_g, R.raw.bunyi_g, R.raw.bunyi_h, R.raw.bunyi_h,
                R.raw.bunyi_j, R.raw.bunyi_j, R.raw.buyi_k, R.raw.buyi_k, R.raw.buyi_l, R.raw.buyi_l,
                R.raw.buyi_m, R.raw.buyi_m, R.raw.buyi_n, R.raw.buyi_n, R.raw.buyi_p, R.raw.buyi_p,
                R.raw.buyi_q, R.raw.buyi_q,  R.raw.buyi_r, R.raw.buyi_r, R.raw.buyi_s,  R.raw.buyi_s,
                R.raw.buyi_t, R.raw.buyi_t, R.raw.buyi_v, R.raw.buyi_v, R.raw.buyi_w,  R.raw.buyi_w,
                R.raw.buyi_x, R.raw.buyi_x, R.raw.buyi_y,  R.raw.buyi_y, R.raw.buyi_z, R.raw.buyi_z
        };

        int[] anim_huruf_vokal = {
                R.drawable.anim_a_besar, R.drawable.anim_a_kecil, R.drawable.anim_i_besar,
                R.drawable.anim_i_kecil, R.drawable.anim_u_besar, R.drawable.anim_u_kecil,
                R.drawable.anim_e_besar, R.drawable.anim_e_kecil, R.drawable.anim_o_besar,
                R.drawable.anim_o_kecil
        };

        int[] anim_huruf_konsonan = {
                R.drawable.anim_b_besar, R.drawable.anim_b_kecil, R.drawable.anim_c_besar, R.drawable.anim_c_kecil,
                R.drawable.anim_d_besar, R.drawable.anim_d_kecil, R.drawable.anim_f_besar, R.drawable.anim_f_kecil,
                R.drawable.anim_g_besar, R.drawable.anim_g_kecil, R.drawable.anim_h_besar, R.drawable.anim_h_kecil,
                R.drawable.anim_j_besar, R.drawable.anim_j_kecil,
                R.drawable.anim_k_besar, R.drawable.anim_k_kecil, R.drawable.anim_l_besar, R.drawable.anim_l_kecil,
                R.drawable.anim_m_besar, R.drawable.anim_m_kecil, R.drawable.anim_n_besar, R.drawable.anim_n_kecil,
                R.drawable.anim_p_besar, R.drawable.anim_p_kecil, R.drawable.anim_q_besar, R.drawable.anim_q_kecil,
                R.drawable.anim_r_besar, R.drawable.anim_r_kecil, R.drawable.anim_s_besar, R.drawable.anim_s_kecil,
                R.drawable.anim_t_besar, R.drawable.anim_t_kecil, R.drawable.anim_v_besar, R.drawable.anim_v_kecil,
                R.drawable.anim_w_besar, R.drawable.anim_w_kecil, R.drawable.anim_x_besar, R.drawable.anim_x_kecil,
                R.drawable.anim_y_besar, R.drawable.anim_y_kecil, R.drawable.anim_z_besar, R.drawable.anim_z_kecil
        };


        // int[] anim_huruf_vokal = {R.drawable.a_besar, R.d};
       // int[] anim_huruf_konsonan

        textView = (TextView) findViewById(R.id.txtHuruf);
        ivAnimasi = (ImageView) findViewById(R.id.animasiHuruf);
        btnSuara = (Button) findViewById(R.id.btn_suara);
        txtJawaban = (EditText) findViewById(R.id.txtJawabanHuruf);
        btnCheckHuruf = (Button) findViewById(R.id.btn_check_huruf);
        Bundle bundle = getIntent().getExtras();
        String mode = bundle.getString("mode");
        int index = bundle.getInt("index");

        switch (mode){
            case "huruf kecil": // Load Huruf Besar
                huruf = getResources().getStringArray(R.array.huruf_kecil);
                animasi = anim_huruf_kecil;
                bunyi = bunyi_huruf;
                break;
            case "huruf besar": // Load Huruf Kecil
                huruf = getResources().getStringArray(R.array.huruf_besar);
                animasi = anim_huruf_besar;
                bunyi = bunyi_huruf;
                break;
            case "huruf vokal": // Load Huruf Vokal
                huruf = getResources().getStringArray(R.array.huruf_vokal);
                animasi = anim_huruf_vokal;
                bunyi= bunyi_huruf_vokal;
                break;
            case "huruf konsonan": // Load Huruf Konsonan
                huruf = getResources().getStringArray(R.array.huruf_konsonan);
                animasi = anim_huruf_konsonan;
                bunyi= bunyi_huruf_konsonan;
                break;
            default:
                break;
        }
        textView.setText(huruf[index]);

        //if is mode huruf vokal

        Glide.with(SubHurufActivity.this).load(animasi[index]).into(new DrawableImageViewTarget(ivAnimasi));
        MediaPlayer mp =  MediaPlayer.create(SubHurufActivity.this, bunyi[index]);
        btnSuara.setOnClickListener(v -> mp.start());

        btnCheckHuruf.setOnClickListener(v -> {
            Toast.makeText(SubHurufActivity.this, txtJawaban.getText().toString(), Toast.LENGTH_SHORT).show();
            if(huruf[index].equals(txtJawaban.getText().toString())){
                Intent i = new Intent(SubHurufActivity.this, PopupActivity.class);
                i.putExtra("hasil", true);
                startActivity(i);
                playAudio(true);
            }
            else{
                Intent i = new Intent(SubHurufActivity.this, PopupActivity.class);
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