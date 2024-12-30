package com.ccf.feige.orderfood.activity.man;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.ccf.feige.orderfood.R;
import com.ccf.feige.orderfood.activity.man.frament.ManageHomeFragment;
import com.ccf.feige.orderfood.activity.man.frament.ManageMyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ManageManActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_man);


        FragmentManager fragment_container=getSupportFragmentManager();
        FragmentTransaction transaction= fragment_container.beginTransaction();

        //实现第一次访问加载的的界面
        //后续 zaichuli------------------------------------
        Intent intent = getIntent();
        String sta = intent.getStringExtra("sta");
        if(sta==null){
            transaction.replace(R.id.man_manage_frame,new ManageHomeFragment());
            transaction.commit();
        }else{
            transaction.replace(R.id.man_manage_frame,new ManageMyFragment());
            transaction.commit();
        }




        BottomNavigationView bottomNavigationView=findViewById(R.id.man_manage_bottom_menu);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager f=getSupportFragmentManager();
                FragmentTransaction transaction1= f.beginTransaction();
                int id=item.getItemId();
                if(id==R.id.man_manage_bottom_menu_home){
                    transaction1.replace(R.id.man_manage_frame,new ManageHomeFragment());
                }
                if(id==R.id.man_manage_bottom_menu_add){
                    //是跳转到新的界面
                    Intent intent=new Intent(ManageManActivity.this,ManageManAddFoodActivity.class);
                    startActivity(intent);
                    return true;
                }
                if(id==R.id.man_manage_bottom_menu_my){
                    transaction1.replace(R.id.man_manage_frame,new ManageMyFragment());
                }
                transaction1.commit();

                return true;
            }
        });

        //实现搜索功能













    }
}