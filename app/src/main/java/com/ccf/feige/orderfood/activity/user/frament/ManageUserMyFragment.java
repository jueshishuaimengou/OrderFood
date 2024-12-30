package com.ccf.feige.orderfood.activity.user.frament;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ccf.feige.orderfood.MainActivity;
import com.ccf.feige.orderfood.R;
import com.ccf.feige.orderfood.activity.man.ManageManActivity;
import com.ccf.feige.orderfood.activity.man.ManageManCommentActivity;
import com.ccf.feige.orderfood.activity.man.ManageManOrderFinishActivity;
import com.ccf.feige.orderfood.activity.man.ManageManOrderNoFinishActivity;
import com.ccf.feige.orderfood.activity.man.ManageManUpdateMesActivity;
import com.ccf.feige.orderfood.activity.man.ManageManUpdatePwdActivity;
import com.ccf.feige.orderfood.activity.user.ManageUserActivity;
import com.ccf.feige.orderfood.activity.user.ManageUserAddressActivity;
import com.ccf.feige.orderfood.activity.user.ManageUserUpdateMesActivity;
import com.ccf.feige.orderfood.activity.user.ManageUserUpdatePwdActivity;
import com.ccf.feige.orderfood.bean.UserBean;
import com.ccf.feige.orderfood.bean.UserCommonBean;
import com.ccf.feige.orderfood.dao.AdminDao;
import com.ccf.feige.orderfood.until.Tools;

public class ManageUserMyFragment extends Fragment {

    View rootview;//根石头

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_manage_user_my, container, false);

        //第一步需要实现，管理员信息的加载，信息的加载就必须，要有一个账号
        String account=Tools.getOnAccount(getContext());

        //查询这个账号 的相关信息
        UserCommonBean user = AdminDao.getCommonUser(account);

        ImageView tx=rootview.findViewById(R.id.user_manage_user_my_tx);//头像
        Bitmap bitmap = BitmapFactory.decodeFile(user.getsImg());
        tx.setImageBitmap(bitmap);



        TextView accountZ =rootview.findViewById(R.id.user_manage_user_my_account);//账号
        accountZ.setText(account);

        TextView name =rootview.findViewById(R.id.user_manage_user_my_name);//账号
        name.setText(user.getsName());


        TextView des =rootview.findViewById(R.id.user_manage_user_my_address);//账号
        des.setText("住址:"+user.getsAddress());

        ManageUserActivity activity = (ManageUserActivity) getActivity();//父亲界面
        /**
         * 推出系统
         */
        TextView exit =rootview.findViewById(R.id.user_manage_user_my_exit);//账号
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity .finishAffinity();
            }
        });

        //注销
        TextView zx =rootview.findViewById(R.id.user_manage_user_my_zx);//账号
        zx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(getContext(), MainActivity.class);
               startActivity(intent);
            }
        });

        TextView changePwd =rootview.findViewById(R.id.user_manage_user_my_changePwd);//账号
        changePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ManageUserUpdatePwdActivity.class);
                startActivity(intent);
            }
        });


        TextView changeMes =rootview.findViewById(R.id.user_manage_user_my_changeMes);//账号
        changeMes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ManageUserUpdateMesActivity.class);
                startActivity(intent);
            }
        });


       TextView orderMan =rootview.findViewById(R.id.user_manage_user_my_order);//账号
        orderMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               activity.showOrder();
            }
        });

        TextView orderManA =rootview.findViewById(R.id.user_manage_user_my_res_address);//账号
        orderManA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ManageUserAddressActivity.class);
                startActivity(intent);
            }
        });

        return rootview;
    }




}