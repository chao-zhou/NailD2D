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

    private static final Map<Integer,Exception> StatusCodeExceptionMap;

    static {
        StatusCodeExceptionMap = new HashMap<>();
        StatusCodeExceptionMap.put(400,new Exception("Bad Request"));
        StatusCodeExceptionMap.put(404,new Exception("Not Found"));
        StatusCodeExceptionMap.put(204,new Exception("No Content"));
        StatusCodeExceptionMap.put(401,new Exception("Unauthorized"));
        StatusCodeExceptionMap.put(500,new Exception("Server Error "));
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
            ServiceError.riseError( res.getStatusLine().getStatusCode());
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
