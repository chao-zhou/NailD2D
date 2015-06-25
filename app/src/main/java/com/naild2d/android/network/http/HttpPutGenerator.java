package com.naild2d.android.network.http;

import android.net.Uri;

import com.naild2d.android.log.Logger;
import com.naild2d.android.network.ServiceRequest;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaozhou on 3/9/2015.
 */
public class HttpPutGenerator extends HttpRequestGenerator {

    private static String getQueryURI(ServiceRequest req) {
        Uri.Builder builder = Uri.parse(req.getFullURI()).buildUpon();

        for (NameValuePair pair : req.getParams()) {
            builder.appendQueryParameter(pair.getName(), pair.getValue());
        }

        for (NameValuePair pair : req.getOAuthValues()) {
            builder.appendQueryParameter(pair.getName(), pair.getValue());
        }
        return builder.build().toString();
    }

    private static String getIndexActionURI(String uri, List<NameValuePair> params) {
        String indexActionURI = uri;
        for (NameValuePair pair : params) {
            indexActionURI += "/" + pair.getName() + "/" + pair.getValue();
        }

        return indexActionURI;
    }

    @Override
    public String getRelativeParamURI(ServiceRequest req) {
        return getIndexActionURI(req.getRelativeURI(), req.getParams());
    }

    @Override
    public HttpUriRequest getHttpRequest(ServiceRequest req) {
        String queryURI = getQueryURI(req);
        HttpPut  put = new HttpPut(queryURI);

        List<NameValuePair> params = new ArrayList<>();
        for(NameValuePair pair : req.getParams()){
            params.add(new BasicNameValuePair(pair.getName(), pair.getValue()));
        }

        try {
            put.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            return put;
        } catch (UnsupportedEncodingException e) {
            Logger.e(e);
            return null;
        }
    }

    @Override
    protected boolean fit(ServiceRequest req) {
        return req.getMethod().equals(ServiceRequest.METHOD_PUT);
    }
}