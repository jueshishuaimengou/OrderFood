package com.ccf.feige.orderfood.activity.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.ccf.feige.orderfood.R;
import com.ccf.feige.orderfood.activity.man.ManageManActivity;
import com.ccf.feige.orderfood.activity.man.ManageManOrderFinishActivity;
import com.ccf.feige.orderfood.activity.user.adapter.AddressListUserAdapter;
import com.ccf.feige.orderfood.bean.AddressBean;
import com.ccf.feige.orderfood.bean.CommentBean;
import com.ccf.feige.orderfood.dao.AddressDao;
import com.ccf.feige.orderfood.dao.CommentDao;
import com.ccf.feige.orderfood.until.Tools;

import java.util.List;

public class ManageUserAddressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_user_address);


        //实现一个返回的功能
        Toolbar toolbar = findViewById(R.id.user_address_bar);
        setSupportActionBar(toolbar);

        //返回有两种，采用跳转和管理
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ManageUserAddressActivity.this, ManageUserActivity.class);
                intent.putExtra("sta","1");
                startActivity(intent);
            }
        });


        RecyclerView listView = findViewById(R.id.user_address_list);//接下来写一个查询的dao
        listView.setLayoutManager(new LinearLayoutManager(this));


        String account= Tools.getOnAccount(this);
        List<AddressBean> list = AddressDao.getAllAddressByUserId(account);

        AddressListUserAdapter addressListUserAdapter=new AddressListUserAdapter(list);

        if(list==null||list.size()==0){
            listView.setAdapter(null);
        }else{
            listView.setAdapter(addressListUserAdapter);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_address_add_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int a=item.getItemId();
        if(a==R.id.user_manage_addressAdd) {
            Intent intent=new Intent(this, ManageUserAddAddressActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}