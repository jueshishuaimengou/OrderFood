package com.ccf.feige.orderfood.dao;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ccf.feige.orderfood.bean.UserBean;
import com.ccf.feige.orderfood.bean.UserCommonBean;
import com.ccf.feige.orderfood.db.DBUntil;

/**
 * 操作数据库
 */
public class AdminDao {

    public static SQLiteDatabase  db=DBUntil.con;

    /**
     * 实现保存商家
     * @param id
     * @param pwd
     * @param name
     * @param des
     * @param type
     * @param tx
     * @return
     */
    public static int saveBusinessUser(String id,String pwd,String name,String des,String type,String tx){
        String data[]={id,pwd, name, des,type,tx};

        try {
            db.execSQL("INSERT INTO d_business (s_id, s_pwd, s_name, s_describe, s_type, s_img) " +
                            "VALUES (?, ?, ?, ?, ?, ?)",
                    data);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }


    /**
     * 更改商家用户
     * @param id
     * @param name
     * @param des
     * @param type
     * @param tx
     * @return
     */
    public static int updateBusinessUser(String id,String name,String des,String type,String tx){
        String data[]={name, des,type,tx,id};

        try {
            db.execSQL("update d_business  set s_name=? ,s_describe=? ,s_type=?, s_img=? where  s_id=? ",
                    data);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    public static int updateBusinessUserPwd(String id,String pwd){
        String data[]={pwd,id};

        try {
            db.execSQL("update d_business  set s_pwd=?  where  s_id=? ",
                    data);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    /**
     * 修改普通用户密码
     * @param id
     * @param pwd
     * @return
     */
    public static int updateCommentUserPwd(String id,String pwd){
        String data[]={pwd,id};

        try {
            db.execSQL("update d_user   set s_pwd=?  where  s_id=? ",
                    data);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }



    /**
     * 这个是保存普通用户
     * @param id
     * @param pwd
     * @param name
     * @param sex
     * @param address
     * @param phone
     * @param tx
     * @return
     */

    public static int saveCommonUser(String id,String pwd,String name,String sex,String address,String phone,String tx){
        String data[]={id,pwd, name, sex,address,phone,tx};

        try {
            db.execSQL("INSERT INTO d_user (s_id, s_pwd, s_name,s_sex, s_address, s_phone, s_img) " +
                            "VALUES (?, ?, ?, ?, ?, ?,?)",
                    data);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    /**
     * 更改普通用户
     * @param id
     * @param name
     * @param sex
     * @param address
     * @param phone
     * @param tx
     * @return
     */
    public static int updateCommonUser(String id,String name,String sex,String address,String phone,String tx){
        String data[]={name, sex,address,phone,tx,id};

        try {
            db.execSQL("update  d_user set s_name=?,s_sex=?, s_address=?, s_phone=?, s_img=? where s_id=?",
                    data);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }



    /**
     * 登录商家账号
     * @param account
     * @param pwd
     * @return
     */
    public static int loginBusiness(String account,String pwd){
            String data[]={account,pwd};
            String sql="select * from d_business where s_id=? and s_pwd=?";
            Cursor result = db.rawQuery(sql,data);
            while(result.moveToNext()){
                return 1;
            }
            return 0;

    }


    /**
     * 登录普通用户
     * @param account
     * @param pwd
     * @return
     */
    public static int loginUser(String account,String pwd){
        String data[]={account,pwd};
        String sql="select * from d_user where s_id=? and s_pwd=?";
        Cursor result = db.rawQuery(sql,data);
        while(result.moveToNext()){
            return 1;
        }
        return 0;
    }


    /**
     * 获取用户账号信息内容
     * @param account
     * @return
     */
    @SuppressLint("Range")
    public static UserBean getBusinessUser(String account){
        String data[]={account};
        String sql="select * from d_business where s_id=?";
        Cursor result = db.rawQuery(sql,data);
        while(result.moveToNext()){
             String id=result.getString(result.getColumnIndex("s_id"));
              String pwd=result.getString(result.getColumnIndex("s_pwd"));
            String name=result.getString(result.getColumnIndex("s_name"));
            String des=result.getString(result.getColumnIndex("s_describe"));
            String type=result.getString(result.getColumnIndex("s_type"));
            String img=result.getString(result.getColumnIndex("s_img"));
            UserBean userBean=new UserBean(id,pwd,name,des,type,img);

            return  userBean;
        }
        return null;
    }




    /**
     * 获取用户账号信息内容
     * @param account
     * @return
     */
    @SuppressLint("Range")
    public static UserCommonBean getCommonUser(String account){
        String data[]={account};
        String sql="select * from d_user where s_id=?";
        Cursor result = db.rawQuery(sql,data);
        while(result.moveToNext()){
            String id=result.getString(result.getColumnIndex("s_id"));
            String pwd=result.getString(result.getColumnIndex("s_pwd"));
            String name=result.getString(result.getColumnIndex("s_name"));
            String sex=result.getString(result.getColumnIndex("s_sex"));
            String address=result.getString(result.getColumnIndex("s_address"));
            String phone=result.getString(result.getColumnIndex("s_phone"));


            String img=result.getString(result.getColumnIndex("s_img"));

            UserCommonBean userCommonBean=new UserCommonBean(id,pwd,name,sex,address,phone,img);



            return  userCommonBean;
        }
        return null;
    }
}
