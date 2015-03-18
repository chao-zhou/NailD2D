package com.naild2d.android.network.http;

import android.net.Uri;

import com.naild2d.android.network.ServiceRequest;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;

/**
 * Created by chaozhou on 3/9/2015.
 */
public class HttpPutGenerator extends HttpRequestGenerator {

    @Override
    public HttpUriRequest getHttpRequest(ServiceRequest req) {
        String queryURI = getQueryURI(req);
        HttpPut  put = new HttpPut(queryURI);
        return put;
    }

    @Override
    protected boolean fit(ServiceRequest req) {
        return req.getMethod() == ServiceRequest.METHOD_PUT;
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