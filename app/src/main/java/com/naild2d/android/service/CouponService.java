package com.naild2d.android.service;

import android.content.Context;

import com.naild2d.android.api.CouponApi;
import com.naild2d.android.json.IndexJSONObject;
import com.naild2d.android.log.Logger;
import com.naild2d.android.model.CouponInfo;

/**
 * Created by ebread on 2015/6/16.
 */
public class CouponService extends BaseService {
    private CouponApi couponApi = null;

    public CouponService(Context context) {
        super(context);
        couponApi = new CouponApi();
    }

    public CouponInfo[] getOnDoorCoupons(int page, int pageSize) {
        String jString = couponApi.getOnDoorCoupon(pageSize, page);
        try {
            IndexJSONObject json = new IndexJSONObject(jString);
            return json.getObjectArray(CouponInfo.class);
        } catch (Exception e) {
            Logger.e(e);
        }
        return null;
    }
}
