package com.ccf.feige.orderfood.activity.user;
/**
 * 这个是一个注册的界面
 */



import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;


import com.ccf.feige.orderfood.R;
import com.ccf.feige.orderfood.dao.AdminDao;
import com.ccf.feige.orderfood.until.FileImgUntil;

import java.util.UUID;

public class RegisterUserActivity extends AppCompatActivity {
    private ActivityResultLauncher<String> getContentLauncher;

    Uri uri;
    private String sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);


        //实现一个返回的功能
        Toolbar toolbar = findViewById(R.id.register_user_toolbar);
        setSupportActionBar(toolbar);
        //返回有两种，采用跳转和管理
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();//返回功能
            }
        });
        //初始化一下文件选择求


//                getContentLauncher=registerForActivityResult(new ActivityResultContracts.GetContent(),
//                new ActivityResultCallback(){
//                    @Override
//                    public void onActivityResult(Object result) {
//                        if(result!=null){
//                            Uri uri=(Uri)result;
//                            img.setImageURI(uri);
//
//                        }else{
//                            Toast.makeText(RegisteredBusiness.this, "未选择头像", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

        ImageView imgText=findViewById(R.id.register_user_tx);
        getContentLauncher=registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                if(result!=null){
                    imgText.setImageURI(result);
                    uri =result;

                }else{
                    Toast.makeText(RegisterUserActivity.this, "未选择头像", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //获取某人头像
        Drawable defaultDrawable= ContextCompat.getDrawable(this,R.drawable.upimg);


        EditText idText=findViewById(R.id.register_user_account);
        EditText pwdText=findViewById(R.id.register_user_pwd);
        EditText nameText=findViewById(R.id.register_user_name);

        sex="女";
        RadioButton man=findViewById(R.id.register_user_nan);
        man.setChecked(true);



        EditText addressText=findViewById(R.id.register_user_address);//地址
        EditText phoneText=findViewById(R.id.register_user_phone);

        Button reg= findViewById(R.id.register_user_zcyh);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断密码是否为空，进行实现注册功能
                //需要判断这个人是否选择了头像
                String id=idText.getText().toString();//变化
                String pwd=pwdText.getText().toString();//变化
                String name=nameText.getText().toString();//变化
                String address=addressText.getText().toString();//变化
                String phone=phoneText.getText().toString();//变化

                Drawable drawable=imgText.getDrawable();//获取当前标签的图片
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();//获取这个图片的二进制文件
                Bitmap bitmapDef = ((BitmapDrawable) defaultDrawable).getBitmap();//获取这个图片的二进制文件
                if(bitmap.sameAs(bitmapDef)){//判断是不是默认的图片
                    Toast.makeText(RegisterUserActivity.this, "请点击图片进行添加头像", Toast.LENGTH_SHORT).show();
                }else if(id.isEmpty()){
                    Toast.makeText(RegisterUserActivity.this, "请输入用户账号", Toast.LENGTH_SHORT).show();
                }else if(pwd.isEmpty()){
                    Toast.makeText(RegisterUserActivity.this, "请输入用户密码", Toast.LENGTH_SHORT).show();
                }else if(name.isEmpty()){
                    Toast.makeText(RegisterUserActivity.this, "请输入用户昵称", Toast.LENGTH_SHORT).show();
                }else if( address.isEmpty()){
                    Toast.makeText(RegisterUserActivity.this, "请输入住址", Toast.LENGTH_SHORT).show();
                }else if(phone.isEmpty()){
                    Toast.makeText(RegisterUserActivity.this, "请输入联系方式", Toast.LENGTH_SHORT).show();
                }else{

                    //可以向数据库进行保存数据
                    ///storage/emulated/0/Pictures/111.png
                    //bitmap  我需要将他保存到另一个一个文件当中，并且把保存路径输入进去
                    if(man.isChecked()){
                        sex="男";
                    }else{
                        sex="女";
                    }
                    //得到一个图名字 root/图片文件+"/a.png
                    String path=FileImgUntil.getImgName();//获取一个存储图片的路径名字
                    FileImgUntil.saveImageBitmapToFileImg(uri, RegisterUserActivity.this,path);//保存图片

                    int a=AdminDao.saveCommonUser(id,pwd,name,sex,address,phone,path);
                    if(a==1){
                        Toast.makeText(RegisterUserActivity.this, "注册用户成功", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(RegisterUserActivity.this, "注册用户失败，账号冲突", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });

        //实现选择图片
        imgText.setOnClickListener(new View.OnClickListener() {//实现点击头像进行上传头像
            @Override
            public void onClick(View v) {
                //打开文件选择器
                openGallery(v);
            }
        });



    }

    /**
     * 打开文件选择器
     * @param v
     */

    private void openGallery(View v){
        getContentLauncher.launch("image/*");
    }


}