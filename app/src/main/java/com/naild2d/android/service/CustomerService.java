package com.naild2d.android.service;

import com.naild2d.android.api.CustomerServiceApi;
import com.naild2d.android.json.IndexJSONObject;
import com.naild2d.android.log.Logger;
import com.naild2d.android.model.customer.CustomerServiceInfo;

import org.json.JSONObject;

/**
 * Created by ebread on 2015/6/18.
 */
public class CustomerService {
    private CustomerServiceApi customerServiceApi = null;

    public CustomerService() {
        customerServiceApi = new CustomerServiceApi();
    }

    public CustomerServiceInfo[] getOrderItemArray(int page, int pageSize) {
        String jString = customerServiceApi.getOrderList(pageSize, page);
        try {
            IndexJSONObject json = new IndexJSONObject(jString);
            return json.getObjectArray(CustomerServiceInfo.class);
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }

    public String getOrderItemCode(int orderItemId) {
        String jString = customerServiceApi.getCustomerServiceCode(String.valueOf(orderItemId));
        try {
            JSONObject json = new JSONObject(jString);
            return json.getString("code");
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }
}
