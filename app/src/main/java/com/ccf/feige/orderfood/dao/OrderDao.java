package com.ccf.feige.orderfood.dao;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ccf.feige.orderfood.bean.OrderBean;
import com.ccf.feige.orderfood.bean.OrderDetailBean;
import com.ccf.feige.orderfood.db.DBUntil;
import com.ccf.feige.orderfood.until.Tools;

import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public static SQLiteDatabase db= DBUntil.con;


    /**
     * 实现更改订单张图
     * @param orderId
     * @param newStatus
     * @return
     */
    public static int  updateOrderStatus(String orderId, String newStatus) {
        // SQL语句，更新指定订单的状态
        String sql = "UPDATE d_orders SET s_order_sta = ? WHERE s_order_id = ?";
        try {
            db.execSQL(sql, new String[]{newStatus, orderId});
            return 1;
        } catch (SQLException e) {
            return 0;
        }
    }


    /**
     * 实现添加订单
     * @param orderId
     * @param time
     * @param businessId
     * @param userId
     * @param orderDetailID
     * @param sta
     * @param address
     * @return
     */
    public static int  installOrder(String orderId, String time,String businessId,String userId,String orderDetailID,String sta,String address) {


        try {
            // SQL语句，更新指定订单的状态
            db.execSQL("INSERT INTO d_orders (s_order_id, s_order_time, s_business_id,s_user_id, s_order_details_id,s_order_sta, s_order_address) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)",
                    new Object[]{orderId, time, businessId, userId, orderDetailID,sta, address});
            return 1;
        } catch (SQLException e) {
            return 0;
        }
    }

    //查看所有，未完成的订单

    public static List<OrderDetailBean> getAllOrderDetail(String id){

        String sql="select * from d_order_details where s_details_id=?";
        Cursor rs = db.rawQuery(sql, new String[]{id});
        List<OrderDetailBean> orderDetailBeanList=new ArrayList<>();
        while(rs.moveToNext()){

            String detailId=Tools.getResultString(rs,"s_details_id");
            String foodId=Tools.getResultString(rs,"s_food_id");
            String foodName=Tools.getResultString(rs,"s_food_name");
            String foodDes=Tools.getResultString(rs,"s_food_des");
            String foodPrice=Tools.getResultString(rs,"s_food_price");
            String foodNum=Tools.getResultString(rs,"s_food_num");
            String foodImg=Tools.getResultString(rs,"s_food_img");

            OrderDetailBean orderDetailBean=new OrderDetailBean(detailId,foodId,foodName,foodDes, foodPrice,foodNum,foodImg);
            orderDetailBeanList.add(orderDetailBean);

        }

        return orderDetailBeanList;

    }

    //查询订单
    public static List<OrderBean> getAllOrders(){

        String sql="select * from d_orders ORDER BY strftime('%Y-%m-%d %H:%M:%S', s_order_time ) desc";
        Cursor rs = db.rawQuery(sql, null);
        List<OrderBean> orderDetailBeanList=new ArrayList<>();
        while(rs.moveToNext()){

            String orderId=Tools.getResultString(rs,"s_order_id");
            String time=Tools.getResultString(rs,"s_order_time");
            String businessId=Tools.getResultString(rs,"s_business_id");
            String userId=Tools.getResultString(rs,"s_user_id");
            String detailsId=Tools.getResultString(rs,"s_order_details_id");
            String sta=Tools.getResultString(rs,"s_order_sta");
            String address=Tools.getResultString(rs,"s_order_address");
            OrderBean orderDetailBean=new OrderBean(orderId,time,businessId,userId, detailsId,sta,address);
            orderDetailBeanList.add(orderDetailBean);


        }

        return orderDetailBeanList;
    }


    //查询订单 根据订单状态查询
    public static List<OrderBean> getAllOrdersBySta(String account,String staZ){
        String sql="select * from d_orders where s_business_id=? and s_order_sta=? ORDER BY strftime('%Y-%m-%d %H:%M:%S', s_order_time )  DESC ";

        String data[]={account,staZ};
        Cursor rs = db.rawQuery(sql, data);
        List<OrderBean> orderDetailBeanList=new ArrayList<>();
        while(rs.moveToNext()){

            String orderId=Tools.getResultString(rs,"s_order_id");
            String time=Tools.getResultString(rs,"s_order_time");
            String businessId=Tools.getResultString(rs,"s_business_id");
            String userId=Tools.getResultString(rs,"s_user_id");
            String detailsId=Tools.getResultString(rs,"s_order_details_id");
            String sta=Tools.getResultString(rs,"s_order_sta");
            String address=Tools.getResultString(rs,"s_order_address");
            OrderBean orderDetailBean=new OrderBean(orderId,time,businessId,userId, detailsId,sta,address);
            orderDetailBeanList.add(orderDetailBean);


        }

        return orderDetailBeanList;
    }



    public static List<OrderBean> getAllOrdersByStaAndUser(String account,String staZ){
        String sql="select * from d_orders where s_user_id=? and s_order_sta=? ORDER BY strftime('%Y-%m-%d %H:%M:%S', s_order_time )  DESC ";

        String data[]={account,staZ};
        Cursor rs = db.rawQuery(sql, data);
        List<OrderBean> orderDetailBeanList=new ArrayList<>();
        while(rs.moveToNext()){

            String orderId=Tools.getResultString(rs,"s_order_id");
            String time=Tools.getResultString(rs,"s_order_time");
            String businessId=Tools.getResultString(rs,"s_business_id");
            String userId=Tools.getResultString(rs,"s_user_id");
            String detailsId=Tools.getResultString(rs,"s_order_details_id");
            String sta=Tools.getResultString(rs,"s_order_sta");
            String address=Tools.getResultString(rs,"s_order_address");
            OrderBean orderDetailBean=new OrderBean(orderId,time,businessId,userId, detailsId,sta,address);
            orderDetailBeanList.add(orderDetailBean);


        }

        return orderDetailBeanList;
    }


    public static List<OrderBean> getAllOrdersByStaAndUserFinish(String account,String staZ){
        String sql="select * from d_orders where s_user_id=? and s_order_sta!=? ORDER BY strftime('%Y-%m-%d %H:%M:%S', s_order_time )  DESC ";

        String data[]={account,staZ};
        Cursor rs = db.rawQuery(sql, data);
        List<OrderBean> orderDetailBeanList=new ArrayList<>();
        while(rs.moveToNext()){

            String orderId=Tools.getResultString(rs,"s_order_id");
            String time=Tools.getResultString(rs,"s_order_time");
            String businessId=Tools.getResultString(rs,"s_business_id");
            String userId=Tools.getResultString(rs,"s_user_id");
            String detailsId=Tools.getResultString(rs,"s_order_details_id");
            String sta=Tools.getResultString(rs,"s_order_sta");
            String address=Tools.getResultString(rs,"s_order_address");
            OrderBean orderDetailBean=new OrderBean(orderId,time,businessId,userId, detailsId,sta,address);
            orderDetailBeanList.add(orderDetailBean);


        }

        return orderDetailBeanList;
    }

    public static List<OrderBean> getAllOrdersFinish(String account){
        String sql="select * from d_orders where s_business_id=? and s_order_sta!=? ORDER BY strftime('%Y-%m-%d %H:%M:%S', s_order_time )  DESC ";

        String data[]={account,"1"};
        Cursor rs = db.rawQuery(sql, data);
        List<OrderBean> orderDetailBeanList=new ArrayList<>();
        while(rs.moveToNext()){

            String orderId=Tools.getResultString(rs,"s_order_id");
            String time=Tools.getResultString(rs,"s_order_time");
            String businessId=Tools.getResultString(rs,"s_business_id");
            String userId=Tools.getResultString(rs,"s_user_id");
            String detailsId=Tools.getResultString(rs,"s_order_details_id");
            String sta=Tools.getResultString(rs,"s_order_sta");
            String address=Tools.getResultString(rs,"s_order_address");
            OrderBean orderDetailBean=new OrderBean(orderId,time,businessId,userId, detailsId,sta,address);
            orderDetailBeanList.add(orderDetailBean);


        }

        return orderDetailBeanList;
    }


    /**
     *
     * @param orderDetailBean
     * @return
     */
    public  static void savaOrderDetail(OrderDetailBean orderDetailBean){

        db.execSQL("INSERT INTO d_order_details (s_details_id,s_food_id, s_food_name,s_food_des, s_food_price, s_food_num,s_food_img) " +
                        "VALUES (?, ?,?, ?, ?, ?, ?)",
                new Object[]{orderDetailBean.getDetailsId(),  orderDetailBean.getFoodId()
                        , orderDetailBean.getFoodName(), orderDetailBean.getFoodDescription(),
                        orderDetailBean.getFoodPrice(), orderDetailBean.getFoodQuantity(),  orderDetailBean.getFoodImage()});
    }

}
