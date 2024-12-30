package com.ccf.feige.orderfood.bean;

import com.ccf.feige.orderfood.dao.AdminDao;
import com.ccf.feige.orderfood.dao.OrderDao;

import java.util.List;

public class OrderBean {

    private String orderId;
    private String orderTime;
    private String businessId;
    private String userId;
    private String orderDetailsId;
    private String orderStatus;
    private String orderAddress;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<OrderDetailBean> getOrderDetailBeanList() {
        return orderDetailBeanList;
    }

    public void setOrderDetailBeanList(List<OrderDetailBean> orderDetailBeanList) {
        this.orderDetailBeanList = orderDetailBeanList;
    }

    private List<OrderDetailBean> orderDetailBeanList;


    @Override
    public String toString() {
        return "OrderBean{" +
                "orderId='" + orderId + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", businessId='" + businessId + '\'' +
                ", userId='" + userId + '\'' +
                ", orderDetailsId='" + orderDetailsId + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(String orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public OrderBean(String orderId, String orderTime, String businessId, String userId, String orderDetailsId, String orderStatus, String orderAddress) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.businessId = businessId;
        this.userId = userId;
        this.orderDetailsId = orderDetailsId;
        this.orderStatus = orderStatus;
        this.orderAddress = orderAddress;
        this.orderDetailBeanList = OrderDao.getAllOrderDetail(orderDetailsId);
        String uname=AdminDao.getCommonUser(userId).getsName();//用户账号昵称
        this.userName=uname;
    }

    public OrderBean() {
    }
}
