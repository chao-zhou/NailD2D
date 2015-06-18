package com.naild2d.android.service;

import com.naild2d.android.api.ShopApi;
import com.naild2d.android.json.IndexJSONObject;
import com.naild2d.android.log.Logger;
import com.naild2d.android.model.ShopInfo;

/**
 * Created by ebread on 2015/6/18.
 */
public class ShopService {
    ShopApi shopApi = null;

    public ShopService() {
        shopApi = new ShopApi();
    }

    public ShopInfo getShopInfoByOrder(int orderId) {
        String jString = shopApi.info(String.valueOf(orderId));
        try {
            IndexJSONObject json = new IndexJSONObject(jString);
            return json.getObject(ShopInfo.class);
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }
}
