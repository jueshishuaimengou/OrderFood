package com.ccf.feige.orderfood.activity.man.frament;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.ccf.feige.orderfood.MainActivity;
import com.ccf.feige.orderfood.R;
import com.ccf.feige.orderfood.activity.man.ManageManActivity;
import com.ccf.feige.orderfood.activity.man.ManageManCommentActivity;
import com.ccf.feige.orderfood.activity.man.ManageManOrderFinishActivity;
import com.ccf.feige.orderfood.activity.man.ManageManOrderNoFinishActivity;
import com.ccf.feige.orderfood.activity.man.ManageManUpdateMesActivity;
import com.ccf.feige.orderfood.activity.man.ManageManUpdatePwdActivity;
import com.ccf.feige.orderfood.activity.man.adapter.FoodLIstAdapter;
import com.ccf.feige.orderfood.bean.FoodBean;
import com.ccf.feige.orderfood.bean.UserBean;
import com.ccf.feige.orderfood.dao.AdminDao;
import com.ccf.feige.orderfood.dao.FoodDao;
import com.ccf.feige.orderfood.until.Tools;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class ManageMyFragment extends Fragment {

    View rootview;//根石头

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_manage_my, container, false);

        //第一步需要实现，管理员信息的加载，信息的加载就必须，要有一个账号
        String account=Tools.getOnAccount(getContext());
        //查询这个账号 的相关信息
        UserBean user = AdminDao.getBusinessUser(account);

        ImageView tx=rootview.findViewById(R.id.man_manage_my_tx);//头像
        Bitmap bitmap = BitmapFactory.decodeFile(user.getsImg());
        tx.setImageBitmap(bitmap);

        TextView accountZ =rootview.findViewById(R.id.man_manage_my_account);//账号
        accountZ.setText(account);

        TextView name =rootview.findViewById(R.id.man_manage_my_name);//账号
        name.setText(user.getsName());


        TextView des =rootview.findViewById(R.id.man_manage_my_des);//账号
        des.setText("店铺简介:"+user.getsDescribe());

        ManageManActivity activity = (ManageManActivity) getActivity();//父亲界面
        /**
         * 推出系统
         */
        TextView exit =rootview.findViewById(R.id.man_manage_my_exit);//账号
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity .finishAffinity();
            }
        });

        //注销
        TextView zx =rootview.findViewById(R.id.man_manage_my_zx);//账号
        zx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(getContext(), MainActivity.class);
               startActivity(intent);
            }
        });

        TextView changePwd =rootview.findViewById(R.id.man_manage_my_changePwd);//账号
        changePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ManageManUpdatePwdActivity.class);
                startActivity(intent);
            }
        });


        TextView changeMes =rootview.findViewById(R.id.man_manage_my_changeMes);//账号
        changeMes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ManageManUpdateMesActivity.class);
                startActivity(intent);
            }
        });


        Button orderMan =rootview.findViewById(R.id.man_manage_my_orderManage);//账号
        orderMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ManageManOrderNoFinishActivity.class);
                startActivity(intent);
            }
        });

        Button comment =rootview.findViewById(R.id.man_manage_my_commentMan);//账号
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ManageManCommentActivity.class);
                startActivity(intent);
            }
        });


        Button finish =rootview.findViewById(R.id.man_manage_my_finish);//账号
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ManageManOrderFinishActivity.class);
                startActivity(intent);
            }
        });



        return rootview;
    }


}