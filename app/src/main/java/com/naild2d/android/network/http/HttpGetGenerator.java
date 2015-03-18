package com.naild2d.android.network.http;

import android.net.Uri;

import com.naild2d.android.network.ServiceRequest;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaozhou on 3/9/2015.
 */
public class HttpGetGenerator extends HttpRequestGenerator {
    @Override
    public HttpUriRequest getHttpRequest(ServiceRequest req) {
        String queryURI = getQueryURI(req);
        HttpGet get = new HttpGet(queryURI);
        return get;
    }

    @Override
    protected boolean fit(ServiceRequest req) {
        return req.getMethod() == ServiceRequest.METHOD_GET;
    }

    private static String getQueryURI(ServiceRequest req){
        Uri.Builder builder = Uri.parse(req.getFullURI()).buildUpon();

        for(NameValuePair pair : req.getParams()){
            builder.appendQueryParameter(pair.getName(),pair.getValue());
        }

        for (NameValuePair pair : req.getOAuthValues() ){
            builder.appendQueryParameter(pair.getName(), pair.getValue());
        }
        return builder.build().toString();
    }
}
