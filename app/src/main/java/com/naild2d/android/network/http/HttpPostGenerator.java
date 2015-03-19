package com.naild2d.android.network.http;

import com.naild2d.android.log.Logger;
import com.naild2d.android.network.ServiceRequest;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
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
public class HttpPostGenerator extends HttpRequestGenerator {
    @Override
    public HttpUriRequest getHttpRequest(ServiceRequest req) {
        HttpPost post = new HttpPost(req.getFullURI());
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        for(NameValuePair pair : req.getParams()){
            params.add(new BasicNameValuePair(pair.getName(),pair.getValue()));
        }

        for (NameValuePair pair : req.getOAuthValues() ){
            params.add(new BasicNameValuePair(pair.getName(),pair.getValue()));
        }

        try {
            post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            return post;
        } catch (UnsupportedEncodingException e) {
            Logger.e(e);
            return null;
        }
    }

    @Override
    protected boolean fit(ServiceRequest req) {
        return req.getMethod() == ServiceRequest.METHOD_POST;
    }
}
