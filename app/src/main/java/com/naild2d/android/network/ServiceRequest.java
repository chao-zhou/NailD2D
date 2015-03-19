package com.naild2d.android.network;

import com.naild2d.android.network.http.HttpRequestGenerator;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpUriRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ebread on 2015/3/8.
 */
public class ServiceRequest {

    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_DELETE = "DELETE";

    public static final String TYPE_REQUEST = "REQUEST"; //Get Access Token
    public static final String TYPE_PUBLIC = "PUBLIC";
    public static final String TYPE_ACCESS = "ACCESS";
    public static final String TYPE_NOAUTH = "NOAUTH";

    public static final String siteURL = "http://drk.igalaxy.com.cn/api";
    //public static final String siteURL = "http://10.0.0.13/api";

    private String relativeURI;
    private String method; //"GET", "PUT" ,"POST","DELETE"
    private List<NameValuePair> oAuthValues;
    private List<NameValuePair> headers;
    private List<NameValuePair> params;
    private String type; // "PUBLIC","PERSONAL"

    public ServiceRequest(String uri){
        relativeURI = uri;
        method = METHOD_GET;
        type = TYPE_PUBLIC;
        oAuthValues = new ArrayList<>();
        headers = new ArrayList<>();
        params = new ArrayList<>();
    }

    public HttpUriRequest getHttpRequest(){

        HttpRequestGenerator generator = HttpRequestGenerator.getInstance(this);
        if(generator == null)
            return null;

        return generator.getHttpRequest(this);
    }

    public String getFullURI(){
        return String.format("%s%s", siteURL, relativeURI);
    }

    public String getRelativeURI() {
        return relativeURI;
    }

    public void setRelativeURI(String relativeURI) {
        this.relativeURI = relativeURI;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public  List<NameValuePair> getOAuthValues() {
        return oAuthValues;
    }

    public void setOAuthValues(List<NameValuePair> oAuthValues) {
        this.oAuthValues = oAuthValues;
    }

    public List<NameValuePair> getParams() {
        return params;
    }

    public void setParams( List<NameValuePair> params) {
        this.params = params;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<NameValuePair> getHeaders() {
        return headers;
    }

    public void setHeaders(List<NameValuePair> headers) {
        this.headers = headers;
    }
}
