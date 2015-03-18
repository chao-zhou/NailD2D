package com.naild2d.android.api;

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
public abstract class Api {

    protected String getResponseString(ServiceRequest req){
        HttpResponse res = ServiceClient.getClient().execute(req);
        HttpEntity entity = res.getEntity();
        try {
            return EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            return null;
        }
    }

    protected byte[] getResponseBytes(ServiceRequest req){
        HttpResponse res = ServiceClient.getClient().execute(req);
        ByteArrayOutputStream s = new ByteArrayOutputStream();
        try {
            res.getEntity().writeTo(s);
            return s.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    protected void addParams(ServiceRequest req, String name,String value){
        if(name == null || value == null)
            return;

        req.getParams().add(new BasicNameValuePair(name,value));
    }
}
