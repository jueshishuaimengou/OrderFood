package com.ccf.feige.orderfood.dao;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.ccf.feige.orderfood.bean.FoodBean;
import com.ccf.feige.orderfood.db.DBUntil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 对食物的增删改查
 */
public class FoodDao {
    public static SQLiteDatabase db= DBUntil.con;
    public static List<FoodBean> getAllFoodList(){

        List<FoodBean> list=new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from d_food",null);
        while (cursor.moveToNext()){
            @SuppressLint("Range") String foodId=cursor.getString(cursor.getColumnIndex("s_food_id"));
            @SuppressLint("Range") String businessId=cursor.getString(cursor.getColumnIndex("s_business_id"));
            @SuppressLint("Range") String foodName=cursor.getString(cursor.getColumnIndex("s_food_name"));
            @SuppressLint("Range") String foodDes=cursor.getString(cursor.getColumnIndex("s_food_des"));
            @SuppressLint("Range") String foodPrice=cursor.getString(cursor.getColumnIndex("s_food_price"));
            @SuppressLint("Range") String foodImg=cursor.getString(cursor.getColumnIndex("s_food_img"));
            FoodBean foodBean=new FoodBean();
            foodBean.setFoodId(foodId);
            foodBean.setFoodDes(foodDes);
            foodBean.setFoodImg(foodImg);
            foodBean.setFoodName(foodName);
            foodBean.setFoodPrice(foodPrice);
            foodBean.setBusinessId(businessId);
            list.add(foodBean);
        }

        return list;
    }


    public static List<FoodBean> getAllFoodListByFoodId(String account){
        String data[]={account};
        List<FoodBean> list=new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from d_food where s_food_id=?",data);
        while (cursor.moveToNext()){
            @SuppressLint("Range") String foodId=cursor.getString(cursor.getColumnIndex("s_food_id"));
            @SuppressLint("Range") String businessId=cursor.getString(cursor.getColumnIndex("s_business_id"));
            @SuppressLint("Range") String foodName=cursor.getString(cursor.getColumnIndex("s_food_name"));
            @SuppressLint("Range") String foodDes=cursor.getString(cursor.getColumnIndex("s_food_des"));
            @SuppressLint("Range") String foodPrice=cursor.getString(cursor.getColumnIndex("s_food_price"));
            @SuppressLint("Range") String foodImg=cursor.getString(cursor.getColumnIndex("s_food_img"));
            FoodBean foodBean=new FoodBean();
            foodBean.setFoodId(foodId);
            foodBean.setFoodDes(foodDes);
            foodBean.setFoodImg(foodImg);
            foodBean.setFoodName(foodName);
            foodBean.setFoodPrice(foodPrice);
            foodBean.setBusinessId(businessId);
            list.add(foodBean);
        }

        return list;
    }


    public static List<FoodBean> getAllFoodListByBusinessId(String account){
        String data[]={account};
        List<FoodBean> list=new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from d_food where s_business_id=?",data);
        while (cursor.moveToNext()){
            @SuppressLint("Range") String foodId=cursor.getString(cursor.getColumnIndex("s_food_id"));
            @SuppressLint("Range") String businessId=cursor.getString(cursor.getColumnIndex("s_business_id"));
            @SuppressLint("Range") String foodName=cursor.getString(cursor.getColumnIndex("s_food_name"));
            @SuppressLint("Range") String foodDes=cursor.getString(cursor.getColumnIndex("s_food_des"));
            @SuppressLint("Range") String foodPrice=cursor.getString(cursor.getColumnIndex("s_food_price"));
            @SuppressLint("Range") String foodImg=cursor.getString(cursor.getColumnIndex("s_food_img"));
            FoodBean foodBean=new FoodBean();
            foodBean.setFoodId(foodId);
            foodBean.setFoodDes(foodDes);
            foodBean.setFoodImg(foodImg);
            foodBean.setFoodName(foodName);
            foodBean.setFoodPrice(foodPrice);
            foodBean.setBusinessId(businessId);
            list.add(foodBean);
        }

        return list;
    }



    public static List<FoodBean> getAllFoodList(String businessIdZ,String title){

        String titleL="%"+title+"%";
        String data[]= {businessIdZ,titleL};


        List<FoodBean> list=new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from d_food where s_business_id=? and s_food_name like ?",data);
        while (cursor.moveToNext()){
            @SuppressLint("Range") String foodId=cursor.getString(cursor.getColumnIndex("s_food_id"));
            @SuppressLint("Range") String businessId=cursor.getString(cursor.getColumnIndex("s_business_id"));
            @SuppressLint("Range") String foodName=cursor.getString(cursor.getColumnIndex("s_food_name"));
            @SuppressLint("Range") String foodDes=cursor.getString(cursor.getColumnIndex("s_food_des"));
            @SuppressLint("Range") String foodPrice=cursor.getString(cursor.getColumnIndex("s_food_price"));
            @SuppressLint("Range") String foodImg=cursor.getString(cursor.getColumnIndex("s_food_img"));
            FoodBean foodBean=new FoodBean();
            foodBean.setFoodId(foodId);
            foodBean.setFoodDes(foodDes);
            foodBean.setFoodImg(foodImg);
            foodBean.setFoodName(foodName);
            foodBean.setFoodPrice(foodPrice);
            foodBean.setBusinessId(businessId);
            list.add(foodBean);
        }

        return list;
    }



    public static List<FoodBean> getAllFoodListUser(String title){

        String titleL="%"+title+"%";
        String data[]= {titleL};


        List<FoodBean> list=new ArrayList<>();
        Cursor cursor=db.rawQuery("select * from d_food where s_food_name like ?",data);
        while (cursor.moveToNext()){
            @SuppressLint("Range") String foodId=cursor.getString(cursor.getColumnIndex("s_food_id"));
            @SuppressLint("Range") String businessId=cursor.getString(cursor.getColumnIndex("s_business_id"));
            @SuppressLint("Range") String foodName=cursor.getString(cursor.getColumnIndex("s_food_name"));
            @SuppressLint("Range") String foodDes=cursor.getString(cursor.getColumnIndex("s_food_des"));
            @SuppressLint("Range") String foodPrice=cursor.getString(cursor.getColumnIndex("s_food_price"));
            @SuppressLint("Range") String foodImg=cursor.getString(cursor.getColumnIndex("s_food_img"));
            FoodBean foodBean=new FoodBean();
            foodBean.setFoodId(foodId);
            foodBean.setFoodDes(foodDes);
            foodBean.setFoodImg(foodImg);
            foodBean.setFoodName(foodName);
            foodBean.setFoodPrice(foodPrice);
            foodBean.setBusinessId(businessId);
            list.add(foodBean);
        }

        return list;
    }

    public static FoodBean getAllFoodById(String id){
        FoodBean foodBean=new FoodBean();
        Cursor cursor=db.rawQuery("select * from d_food where s_food_id=?",new String[]{id});
        if (cursor.moveToNext()){
            @SuppressLint("Range") String foodId=cursor.getString(cursor.getColumnIndex("s_food_id"));
            @SuppressLint("Range") String businessId=cursor.getString(cursor.getColumnIndex("s_business_id"));
            @SuppressLint("Range") String foodName=cursor.getString(cursor.getColumnIndex("s_food_name"));
            @SuppressLint("Range") String foodDes=cursor.getString(cursor.getColumnIndex("s_food_des"));
            @SuppressLint("Range") String foodPrice=cursor.getString(cursor.getColumnIndex("s_food_price"));
            @SuppressLint("Range") String foodImg=cursor.getString(cursor.getColumnIndex("s_food_img"));

            foodBean.setFoodId(foodId);
            foodBean.setFoodDes(foodDes);
            foodBean.setFoodImg(foodImg);
            foodBean.setFoodName(foodName);
            foodBean.setFoodPrice(foodPrice);
            foodBean.setBusinessId(businessId);
            return foodBean;
        }else{
            return null;
        }


    }

    /**
     * 获取当前月的销售数量
     * @param foodId
     * @return
     */
    @SuppressLint("Range")
    public static int getMouSalesNum(String foodId){

        Cursor rs = db.rawQuery("SELECT *   FROM d_orders   " +
                "WHERE s_order_sta='3' and   strftime('%Y-%m', s_order_time) = strftime('%Y-%m', 'now');",null);
        List<String> list=new ArrayList<>();
        while(rs.moveToNext()){
           String temp= rs.getString(rs.getColumnIndex("s_order_details_id"));
           list.add(temp);
        }
        int salNum=0;
        for (String s : list) {
            salNum=salNum+getOrderDetailsByOrderAndFoodId(s,foodId);
        }
        return salNum;
    }


    /**
     * 通过订单ID来获取商品详情内容，商品ID
     * @param orderId
     * @param foodId
     * @return
     */
    @SuppressLint("Range")
    public static int getOrderDetailsByOrderAndFoodId(String orderId,String foodId){

        String data[]={orderId,foodId};
        Cursor rs = db.rawQuery("select * from d_order_details where s_details_id=? and s_food_id=?",data);
        List<String> list=new ArrayList<>();
        while(rs.moveToNext()){
            int tm = rs.getInt(rs.getColumnIndex("s_food_num"));
            return tm;
        }
        return 0;
    }


    /**
     * 实现添加商品
     * @param businessId
     * @param foodName
     * @param des
     * @param foodPrice
     * @param img
     * @return
     */
    public static int addFood(String businessId,String foodName,String des,String foodPrice,String img){
        String id= UUID.randomUUID().toString().replace("-","");


        String data[]={id,businessId,foodName,des,foodPrice,img};
        try {
            db.execSQL("INSERT INTO d_food (s_food_id, s_business_id, s_food_name,s_food_des, s_food_price, s_food_img) " +
                            "VALUES (?, ?, ?,?,  ?, ?)",
                    data);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    /**
     * 实现删除食物
     * @param foodId
     * @return
     */
    public static int delFoodById(String foodId){
        String data[]={ foodId};
        try {
            db.execSQL("delete from  d_food  where s_food_id=?",
                    data);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    /**
     * 实现更改食物
     * @param foodId
     * @param foodName
     * @param des
     * @param foodPrice
     * @param img
     * @return
     */

    public static int updateFood(String foodId,String foodName,String des,String foodPrice,String img){
        String data[]={foodName,des,foodPrice,img,foodId};
        try {
            db.execSQL("update  d_food set s_food_name=?, s_food_des=?,s_food_price=?,s_food_img=? where s_food_id=?" ,

                    data);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }


//    // 根据ID查询食品信息
//    public FoodBean getFoodBeanById(String FoodBeanId) {
//        Cursor cursor = db.query("d_FoodBean", new String[]{"s_FoodBean_id", "s_business_id", "s_FoodBean_name", "s_FoodBean_des", "s_FoodBean_price", "s_FoodBean_img"}, "s_FoodBean_id = ?", new String[]{FoodBeanId}, null, null, null);
//        if (cursor != null && cursor.moveToFirst()) {
//            FoodBean FoodBean = new FoodBean(cursor.getString(cursor.getColumnIndex("s_FoodBean_id")),
//                    cursor.getString(cursor.getColumnIndex("s_business_id")),
//                    cursor.getString(cursor.getColumnIndex("s_FoodBean_name")),
//                    cursor.getString(cursor.getColumnIndex("s_FoodBean_des")),
//                    cursor.getString(cursor.getColumnIndex("s_FoodBean_price")),
//                    cursor.getString(cursor.getColumnIndex("s_FoodBean_img")));
//            cursor.close();
//            return FoodBean;
//        }
//        return null;
//    }

}
