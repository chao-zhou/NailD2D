package com.naild2d.android.network;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ebread on 2015/3/8.
 */
public class ServiceClient {

    public static ServiceClient getClient(){
        return new ServiceClient();
    }

    private HttpClient client = null;

    public ServiceClient(){
        client = new DefaultHttpClient();
    }

    public HttpResponse execute(ServiceRequest request) {
        appendOAuthParams(request);
        return getHttpResponse(request);
    }

    private HttpResponse getHttpResponse(ServiceRequest request) {
        try {
            HttpResponse res =  client.execute(request.getHttpRequest());
            return res;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private void appendOAuthParams(ServiceRequest request) {
        if(request.getType() == ServiceRequest.TYPE_REQUEST){
            OAuthUtil.appendRequestOauthParams(request);
            return;
        }

        if(request.getType() == ServiceRequest.TYPE_PUBLIC){
            OAuthUtil.appendPublicOauthParams(request);
            return;
        }

        if(request.getType() == ServiceRequest.TYPE_ACCESS){
            OAuthUtil.appendAccessOauthParams(request);
            return;
        }
    }
}
