package com.naild2d.android.api;

import com.naild2d.android.log.Logger;
import com.naild2d.android.network.ServiceClient;
import com.naild2d.android.network.ServiceRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by chaozhou on 3/9/2015.
 */
abstract class Api {

    String getResponseString(ServiceRequest req){
        HttpResponse res = ServiceClient.getClient().execute(req);
        try {
            //ServiceError.riseError(res.getStatusLine().getStatusCode());
            HttpEntity entity = res.getEntity();
            return EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            Logger.e(e);
            return null;
        }
    }

    byte[] getResponseBytes(ServiceRequest req){
        HttpResponse res = ServiceClient.getClient().execute(req);
        ByteArrayOutputStream s = new ByteArrayOutputStream();
        try {
            res.getEntity().writeTo(s);
            return s.toByteArray();
        } catch (IOException e) {
            Logger.e(e);
        }
        return  null;
    }

    void addParams(ServiceRequest req, String name, String value){
        if(name == null || value == null)
            return;

        req.getParams().add(new BasicNameValuePair(name,value));
    }
}
