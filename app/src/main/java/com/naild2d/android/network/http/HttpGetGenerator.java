package com.naild2d.android.network.http;

import android.net.Uri;

import com.naild2d.android.network.ServiceRequest;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import java.util.List;

/**
 * Created by chaozhou on 3/9/2015.
 */
public class HttpGetGenerator extends HttpRequestGenerator {

    private static String getQueryURI(ServiceRequest req){
        String indexActionURI = getIndexActionURI(req.getFullURI(), req.getParams());
        Uri.Builder builder = Uri.parse(indexActionURI).buildUpon();

//        for(NameValuePair pair : req.getParams()){
//            builder.appendQueryParameter(pair.getName(),pair.getValue());
//        }

        for (NameValuePair pair : req.getOAuthValues() ){
            builder.appendQueryParameter(pair.getName(), pair.getValue());
        }
        return builder.build().toString();
    }

    private static String getIndexActionURI(String uri, List<NameValuePair> params){
        String indexActionURI = uri;
        for(NameValuePair pair : params){
           indexActionURI += "/"+pair.getName()+"/"+pair.getValue();
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
        return new HttpGet(queryURI);
    }

    @Override
    protected boolean fit(ServiceRequest req) {
        return req.getMethod().equals(ServiceRequest.METHOD_GET);
    }
}
