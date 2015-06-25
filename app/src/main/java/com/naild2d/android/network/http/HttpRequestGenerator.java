package com.naild2d.android.network.http;

import com.naild2d.android.network.ServiceRequest;

import org.apache.http.client.methods.HttpUriRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaozhou on 3/9/2015.
 */
public abstract class HttpRequestGenerator {

    private static List<HttpRequestGenerator> instances = null;

    public static HttpRequestGenerator getInstance(ServiceRequest req){

        if(instances == null){
            instances = new ArrayList<>();
            instances.add(new HttpGetGenerator());
            instances.add(new HttpPostGenerator());
            instances.add(new HttpPutGenerator());
        }

        for(HttpRequestGenerator instance : instances){
            if(instance.fit(req))
                return instance;
        }

        return null;
    }

    public String getRelativeParamURI(ServiceRequest req) {
        return req.getRelativeURI();
    }

    public abstract HttpUriRequest getHttpRequest(ServiceRequest req);
    protected abstract boolean fit(ServiceRequest req);


}
