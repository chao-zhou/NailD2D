package com.naild2d.android.service;

import com.naild2d.android.api.OrderApi;
import com.naild2d.android.json.IndexJsonObject;
import com.naild2d.android.log.Logger;
import com.naild2d.android.model.ConfirmedOrder;
import com.naild2d.android.service.params.SubmitOrderParam;

import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/16.
 */
public class OrderService {
    private OrderApi orderApi = null;

    public OrderService() {
        orderApi = new OrderApi();
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

    public ConfirmedOrder confirmedOrder(int orderId) {
        String jString = orderApi.confirm(String.valueOf(orderId));
        try {
            IndexJsonObject json = new IndexJsonObject(jString);
            return json.getObject(ConfirmedOrder.class);
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }

    public boolean cancelOrder(int orderId) {
        return orderApi.cancel(String.valueOf(orderId));
    }
}
