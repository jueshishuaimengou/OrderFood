package com.ccf.feige.orderfood.activity.man;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ccf.feige.orderfood.R;
import com.ccf.feige.orderfood.dao.AdminDao;
import com.ccf.feige.orderfood.until.Tools;

public class ManageManUpdatePwdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_man_update_pwd);

        Toolbar toolbar = findViewById(R.id.man_manage_updateBusiness_pwd_bar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ManageManUpdatePwdActivity.this,ManageManActivity.class);
                intent.putExtra("sta","1");
                startActivity(intent);
            }
        });


        EditText pwd = findViewById(R.id.man_manage_updateBusiness_pwd_pwd);
        EditText  confirm = findViewById(R.id.man_manage_updateBusiness_pwd_confirmPwd);

        String account= Tools.getOnAccount(this);
        Button button = findViewById(R.id.man_manage_updateBusiness_pwd_update);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pwdT=pwd.getText().toString().trim();
                String confirmT=confirm.getText().toString().trim();
                if(pwdT.isEmpty()){
                    pwd.setError("请输入密码");
                    pwd.requestFocus(); // 将焦点设置到该EditText上，方便用户立即输入
                }else if(confirmT.isEmpty()){
                    confirm.setError("请输入确认密码");
                    confirm.requestFocus(); // 将焦点设置到该EditText上，方便用户立即输入
                }else if(!pwdT.equals(confirmT)){
                    confirm.setError("两次密码不一致,请重新输入");
                    confirm.requestFocus(); // 将焦点设置到该EditText上，方便用户立即输入
                }else{


                    int a=AdminDao.updateBusinessUserPwd(account,pwdT);
                    if(a==1){
                        Toast.makeText(ManageManUpdatePwdActivity.this, "更改密码成功", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(ManageManUpdatePwdActivity.this, "更改密码失败", Toast.LENGTH_SHORT).show();
                    }




                }

            }
        });




    }
}