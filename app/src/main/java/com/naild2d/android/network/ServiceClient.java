package com.naild2d.android.network;

import com.naild2d.android.log.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by ebread on 2015/3/8.
 */
public class ServiceClient {

    public static ServiceClient getClient(){
        return new ServiceClient();
    }

    private HttpClient client = null;

    private ServiceClient(){
        client = new DefaultHttpClient();
    }

    public HttpResponse execute(ServiceRequest request) {
        appendOAuthParams(request);
        return getHttpResponse(request);
    }

    private HttpResponse getHttpResponse(ServiceRequest request) {
        try {
            return client.execute(request.getHttpRequest());

        } catch (Exception e) {
            Logger.e(e);
        }

        return null;
    }

    private void appendOAuthParams(ServiceRequest request) {
        if(request.getType().equals(ServiceRequest.TYPE_REQUEST)){
            OAuthUtil.appendRequestOauthParams(request);
            return;
        }

        if(request.getType().equals(ServiceRequest.TYPE_PUBLIC)){
            OAuthUtil.appendPublicOauthParams(request);
            return;
        }

        if(request.getType().equals(ServiceRequest.TYPE_ACCESS)){
            OAuthUtil.appendAccessOauthParams(request);
        }
    }
}
