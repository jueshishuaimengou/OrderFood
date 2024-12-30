package com.ccf.feige.orderfood.activity.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.ccf.feige.orderfood.R;
import com.ccf.feige.orderfood.activity.man.ManageManAddFoodActivity;
import com.ccf.feige.orderfood.activity.man.frament.ManageMyFragment;
import com.ccf.feige.orderfood.activity.user.frament.ManageUserMyFragment;
import com.ccf.feige.orderfood.activity.user.frament.UserFinishOrderFragment;
import com.ccf.feige.orderfood.activity.user.frament.UserHomeFragment;
import com.ccf.feige.orderfood.activity.user.frament.UserNoFinishOrderFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ManageUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_user);


        FragmentManager fragment_container=getSupportFragmentManager();
        FragmentTransaction transaction= fragment_container.beginTransaction();

        //实现第一次访问加载的的界面
        //后续 zaichuli------------------------------------
        Intent intent = getIntent();
        String sta = intent.getStringExtra("sta");
        if(sta==null){
            transaction.replace(R.id.user_manage_frame,new UserHomeFragment());
            transaction.commit();
        }else{
            transaction.replace(R.id.user_manage_frame,new ManageUserMyFragment());
            transaction.commit();
        }




        BottomNavigationView bottomNavigationView=findViewById(R.id.user_manage_bottom_menu);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager f=getSupportFragmentManager();
                FragmentTransaction transaction1= f.beginTransaction();
                int id=item.getItemId();
                if(id==R.id.user_manage_bottom_menu_home){
                    transaction1.replace(R.id.user_manage_frame,new UserHomeFragment());
                }
                //打开一个新的界面显示所有带出来的订单
                if(id==R.id.user_manage_bottom_menu_noFinish){
                    //是跳转到新的界面
                    transaction1.replace(R.id.user_manage_frame,new UserNoFinishOrderFragment());
                }
                if(id==R.id.user_manage_bottom_menu_my){
                    transaction1.replace(R.id.user_manage_frame,new ManageUserMyFragment());
                }
                transaction1.commit();

                return true;
            }
        });

        //实现搜索功能






    }


    public void showOrder(){
        FragmentManager fragment_container=this.getSupportFragmentManager();
        FragmentTransaction transaction= fragment_container.beginTransaction();
        transaction.replace(R.id.user_manage_frame,new UserFinishOrderFragment());
        transaction.commit();
    }

    public void showMy(){
        FragmentManager fragment_container=this.getSupportFragmentManager();
        FragmentTransaction transaction= fragment_container.beginTransaction();
        transaction.replace(R.id.user_manage_frame,new ManageUserMyFragment());
        transaction.commit();
    }
}