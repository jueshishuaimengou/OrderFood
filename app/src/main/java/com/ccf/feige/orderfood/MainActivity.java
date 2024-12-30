package com.ccf.feige.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.ccf.feige.orderfood.activity.man.ManageManActivity;
import com.ccf.feige.orderfood.activity.man.ManageManCommentActivity;
import com.ccf.feige.orderfood.activity.man.ManageManOrderFinishActivity;
import com.ccf.feige.orderfood.activity.man.ManageManOrderNoFinishActivity;
import com.ccf.feige.orderfood.activity.man.RegisterManActivity;
import com.ccf.feige.orderfood.activity.user.ManageUserActivity;
import com.ccf.feige.orderfood.activity.user.ManageUserAddressActivity;
import com.ccf.feige.orderfood.activity.user.ManageUserCommentActivity;
import com.ccf.feige.orderfood.activity.user.RegisterUserActivity;
import com.ccf.feige.orderfood.dao.AdminDao;
import com.ccf.feige.orderfood.db.DBUntil;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DBUntil dbUntil=new DBUntil(this);
        DBUntil.con= dbUntil.getWritableDatabase();
        //实现跟共享数据
        SharedPreferences sharedPreferences=getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();



        RadioButton sjRadio=findViewById(R.id.login_sj);
        sjRadio.setChecked(true);//让运行时候商家单选按钮默认选择


        Button zcsj=findViewById(R.id.login_zhuceshangjia);
        zcsj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到注册商家界面
                Intent intent=new Intent(MainActivity.this, RegisterManActivity.class);
                startActivity(intent);
            }
        });

        Button zcyh=findViewById(R.id.login_zhuceyonghu);
        zcyh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到注册用户界面
                Intent intent=new Intent(MainActivity.this, RegisterUserActivity.class);
                startActivity(intent);
            }
        });


        //登陆功能

        EditText accountText=findViewById(R.id.login_account);
        EditText pwdText=findViewById(R.id.login_pwd);


        Button denglu=findViewById(R.id.login_denglu);

        RadioButton role=findViewById(R.id.login_sj);

        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account=accountText.getText().toString();
                String pwd=pwdText.getText().toString();
                if( account.isEmpty()){
                    Toast.makeText(MainActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();
                }else if(pwd.isEmpty()){
                    Toast.makeText(MainActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                }else{
                    edit.putString("account",account);
                    edit.apply();
                    if(role.isChecked()){
                        //管理员
                       int a= AdminDao.loginBusiness(account,pwd);
                       if(a==1){
                           Toast.makeText(MainActivity.this, "管理员登录成功", Toast.LENGTH_SHORT).show();
                           Intent intent=new Intent(MainActivity.this, ManageManActivity.class);
                           startActivity(intent);
                       }else{
                           Toast.makeText(MainActivity.this, "管理员账号或密码错误", Toast.LENGTH_SHORT).show();
                       }

                    }else{
                        int a= AdminDao.loginUser(account,pwd);
                        if(a==1){
                            Toast.makeText(MainActivity.this, "用户登录成功", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(MainActivity.this, ManageUserActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this, "用户账号或密码错误", Toast.LENGTH_SHORT).show();
                        }
                    }


                }

            }
        });


    }
}