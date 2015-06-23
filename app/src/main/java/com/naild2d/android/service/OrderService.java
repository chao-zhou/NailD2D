package com.naild2d.android.service;

import com.naild2d.android.api.OrderApi;
import com.naild2d.android.api.PaymentApi;
import com.naild2d.android.json.IndexJSONObject;
import com.naild2d.android.log.Logger;
import com.naild2d.android.model.Order;
import com.naild2d.android.model.OrderStatus;
import com.naild2d.android.service.params.SubmitOrderParam;

import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/16.
 */
public class OrderService {
    public final static String ORDER_STATUS_PAID = "Paid";
    public final static String ORDER_STATUS_COMPLETED = "Completed";
    public final static String ORDER_STATUS_CONFIRMED = "Confirmed";
    public final static String ORDER_STATUS_CANCELLED = "Cancelled";


    private OrderApi orderApi = null;
    private PaymentApi paymentApi = null;

    public OrderService() {
        orderApi = new OrderApi();
        paymentApi = new PaymentApi();
    }

    public int submitOrder(SubmitOrderParam param) {
        String jString = orderApi.submit(
                param.getLat(), param.getLon(),
                param.getLocation(), param.getAddress(),
                param.getSchedule(), param.getPack(),
                param.getServicesJString(),
                param.getRemark(), param.getCoupon()
        );

        try {
            JSONObject json = new JSONObject(jString);
            return json.getInt("order");
        } catch (Exception e) {
            Logger.e(e);
        }
        return -1;
    }

    public OrderStatus getOrderStatus(int orderId) {
        String jString = orderApi.status(String.valueOf(orderId));
        try {
            IndexJSONObject json = new IndexJSONObject(jString);
            return json.getObject(OrderStatus.class);
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }

    public boolean cancelOrder(int orderId) {
        return orderApi.cancel(String.valueOf(orderId));
    }

    public boolean confirmOrder(int orderId) {
        return orderApi.confirm(String.valueOf(orderId));
    }

    public String payOrder(int orderId) {
        String jString = paymentApi.pay(String.valueOf(orderId));
        try {
            JSONObject json = new JSONObject(jString);
            return json.getString("orderString");
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }

    public boolean completeOrder(int orderId) {
        return orderApi.complete(String.valueOf(orderId));
    }

    public Order[] listOrders(String status, int page, int page_size) {
        String jString = orderApi.list(status, page_size, page);
        try {
            IndexJSONObject json = new IndexJSONObject(jString);
            return json.getObjectArray(Order.class);
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }

}
