package com.ccf.feige.orderfood.activity.user;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.ccf.feige.orderfood.MainActivity;
import com.ccf.feige.orderfood.R;
import com.ccf.feige.orderfood.activity.man.ManageManAddFoodActivity;
import com.ccf.feige.orderfood.activity.user.listen.StartListen;
import com.ccf.feige.orderfood.dao.CommentDao;
import com.ccf.feige.orderfood.until.FileImgUntil;
import com.ccf.feige.orderfood.until.Tools;

public class ManageUserCommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_user_comment);


       Toolbar toolbar= findViewById(R.id.user_manage_comment_bar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


       EditText text= findViewById(R.id.user_manage_comment_text);
        ImageView one=findViewById(R.id.user_comment_one);
        ImageView two=findViewById(R.id.user_comment_two);
        ImageView three=findViewById(R.id.user_comment_three);
        ImageView four=findViewById(R.id.user_comment_four);
        ImageView five=findViewById(R.id.user_comment_five);
        TextView con= this.findViewById(R.id.user_comment_con);

        one.setOnClickListener(new StartListen(ManageUserCommentActivity.this));
        two.setOnClickListener(new StartListen(ManageUserCommentActivity.this));
        three.setOnClickListener(new StartListen(ManageUserCommentActivity.this));
        four.setOnClickListener(new StartListen(ManageUserCommentActivity.this));
        five.setOnClickListener(new StartListen(ManageUserCommentActivity.this));
        //con.setOnClickListener(new StartListen(ManageUserCommentActivity.this));

        //实现拍照功能，以及获取相册功能


        ImageView  img = findViewById(R.id.user_manage_comment_img);
        Button bz = findViewById(R.id.user_manage_comment_pz);
        Button xc = findViewById(R.id.user_manage_comment_xc);
        bz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paiZhao();
            }
        });
        xc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               xiangCe();
            }
        });

        String account= Tools.getOnAccount(this);
        Intent intent=getIntent();
        String businessId=intent.getStringExtra("businessId");

        Button commentButton =this. findViewById(R.id.user_manage_comment_fbpl);
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textT=text.getText().toString();
                if(textT.isEmpty()){
                    Toast.makeText(ManageUserCommentActivity.this, "请输入评论", Toast.LENGTH_SHORT).show();
                }else{



                    String path= FileImgUntil.getImgName();//获取一个存储图片的路径名字

                    Drawable drawable = img.getDrawable();//获取当前标签的图片
                    //获取这个图片的二进制文件
                    if(drawable==null){
                        path="";
                    }else{
                        Bitmap   bitmap = ((BitmapDrawable) drawable).getBitmap();
                        FileImgUntil.saveSystemImgToPath(bitmap,path);
                    }

                    String score=con.getText().toString();
                    String conA[]={"非常差","差","一般","满意","非常满意"};//代笔5个内容
                    int sc=1;
                    for(int i=0;i<conA.length;i++){
                       if(conA[i].equals(score)) {
                           sc=i+1;
                           break;
                       }
                    }

//                    String path= FileImgUntil.getImgName();//获取一个存储图片的路径名字
//                    FileImgUntil.saveImageBitmapToFileImg(uri, ManageManAddFoodActivity.this,path);//保存图片
//                    String foodImg1= FileImgUntil.getImgName();//获取一个存储图片的路径名字
                    int a=CommentDao.insertComment( account,businessId,textT,String.valueOf(sc),path);



                    if(a==1){
                        Toast.makeText(ManageUserCommentActivity.this, "评论成功", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(ManageUserCommentActivity.this, "评论失败", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });


        cameraLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {
                if(result.getResultCode()== Activity.RESULT_OK){
                    Intent data=result.getData();
                    if(data!=null){
                        Bundle extras=data.getExtras();
                        if(extras!=null&& extras.containsKey("data")){
                            Bitmap bitMap = (Bitmap) extras.get("data");
                            img.setImageBitmap(bitMap);
                        }else{
                            //选择相册
                            Uri selectImg = data.getData();
                            img.setImageURI(selectImg);

                        }
                    }
                }

        });


    }


    private ActivityResultLauncher<Intent> cameraLauncher;


    /**
     * 照片
     */

    private void paiZhao(){
        Intent pic=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraLauncher.launch(pic);
    }

    private void xiangCe(){
        Intent pic=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        cameraLauncher.launch(pic);
    }



}