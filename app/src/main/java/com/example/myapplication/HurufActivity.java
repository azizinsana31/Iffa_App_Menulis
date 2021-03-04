package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adapters.ItemAdapter;
import adapters.ItemModel;

public class HurufActivity extends AppCompatActivity {
    GridView hurufView;
    TextView txtMode;
    List<ItemModel> items = new ArrayList<>();
    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huruf);
        Bundle intent = getIntent().getExtras();
        final String strMode = intent.getString("Mode");
        txtMode = (TextView) findViewById(R.id.txt_mode);
        txtMode.setText(strMode.toUpperCase());

        int[] hurufKecil = {
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

        int[] hurufBesar = {
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

        int[] hurufVokal = {
                            R.drawable.a_besar, R.drawable.a_kecil, R.drawable.i_besar,
                            R.drawable.i_kecil, R.drawable.u_besar, R.drawable.u_kecil,
                            R.drawable.e_besar, R.drawable.e_kecil, R.drawable.o_besar,
                            R.drawable.o_kecil
        };


        int[] hurufKonsonan = {
                            R.drawable.b_besar, R.drawable.b_kecil, R.drawable.c_besar, R.drawable.c_kecil,
                            R.drawable.d_besar, R.drawable.d_kecil, R.drawable.f_besar, R.drawable.f_kecil,
                            R.drawable.g_besar, R.drawable.g_kecil, R.drawable.h_besar, R.drawable.h_kecil,
                            R.drawable.j_besar, R.drawable.j_kecil,
                            R.drawable.k_besar, R.drawable.k_kecil, R.drawable.l_besar, R.drawable.l_kecil,
                            R.drawable.m_besar, R.drawable.m_kecil, R.drawable.n_besar, R.drawable.n_kecil,
                            R.drawable.p_besar, R.drawable.p_kecil, R.drawable.q_besar, R.drawable.q_kecil,
                            R.drawable.r_besar, R.drawable.r_kecil, R.drawable.s_besar, R.drawable.s_kecil,
                            R.drawable.t_besar, R.drawable.t_kecil, R.drawable.v_besar, R.drawable.v_kecil,
                            R.drawable.w_besar, R.drawable.w_kecil, R.drawable.x_besar, R.drawable.x_kecil,
                            R.drawable.y_besar, R.drawable.y_kecil, R.drawable.z_besar, R.drawable.z_kecil
        };

        hurufView = (GridView) findViewById(R.id.huruf_gridView);

        switch (strMode){
            case "huruf kecil": // Load Huruf Besar
                for (int item : hurufKecil){
                    items.add(new ItemModel(item));
                }
                break;
            case  "huruf besar": // Load Huruf Kecil
                for (int item : hurufBesar){
                    items.add(new ItemModel(item));
                }
                break;
            case "huruf vokal" : // Load Huruf Vokal
                for (int item : hurufVokal){
                    items.add(new ItemModel(item));
                }
                break;
            case "huruf konsonan" : // Load Huruf Konsonan
                for (int item : hurufKonsonan){
                    items.add(new ItemModel(item));
                }
                break;
            default:
                break;
        }

        hurufView.setAdapter(new ItemAdapter(this, R.layout.item_view, items));
        hurufView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(HurufActivity.this, SubHurufActivity.class);
                i.putExtra("mode", strMode);
                i.putExtra("index", position);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optons_menu, menu);
        return true;
    }
}