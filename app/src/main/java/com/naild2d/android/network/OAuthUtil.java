package com.naild2d.android.network;

import android.util.Base64;

import com.naild2d.android.crypto.HmacCrpto;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

/**
 * Created by ebread on 2015/3/8.
 */
public class OAuthUtil {
   private static final String HEADER_CONSUMER_NAME = "oauth_consumer_key";
   private static final String HEADER_NONCE_NAME = "oauth_nonce";
   private static final String HEADER_SIGNATURE_METHOD_NAME = "oauth_signature_method";
   private static final String HEADER_TIMESTAMP_NAME = "oauth_timestamp";
   private static final String HEADER_VERSION_NAME = "oauth_version";
   private static final String HEADER_SIGNATURE_NAME = "oauth_signature";
   private static final String HEADER_TOKEN = "oauth_token";

   private static final String HEADER_SIGNATURE_METHOD_VALUE = "HMAC-SHA1";
   private static final String HEADER_VERSION_VALUE = "1.0";

    public static void appendRequestOauthParams(ServiceRequest request){
        appendBasicOauthParams(request);
        request.getOAuthValues().add( new BasicNameValuePair(HEADER_TOKEN,ServiceToken.REQUEST_TOKEN));
        signatureRequest(request,ServiceToken.CUSTOMER_SECRET+"&"+ServiceToken.REQUEST_SECRET);
    }

    public static void appendPublicOauthParams(ServiceRequest request){
        appendBasicOauthParams(request);
        signatureRequest(request, ServiceToken.CUSTOMER_SECRET + "&");
    }

   public static void appendAccessOauthParams(ServiceRequest request){
       appendBasicOauthParams(request);
       request.getOAuthValues().add( new BasicNameValuePair(HEADER_TOKEN,ServiceToken.ACCESS_TOKEN));
       signatureRequest(request,ServiceToken.CUSTOMER_SECRET+"&"+ServiceToken.ACCESS_SECRET);
   }

   private static void appendBasicOauthParams(ServiceRequest request){

       request.getOAuthValues().add( new BasicNameValuePair(HEADER_CONSUMER_NAME,ServiceToken.CUSTOMER_ID));
       request.getOAuthValues().add( new BasicNameValuePair(HEADER_NONCE_NAME, UUID.randomUUID().toString().replaceAll("-","")));
       request.getOAuthValues().add( new BasicNameValuePair(HEADER_SIGNATURE_METHOD_NAME, HEADER_SIGNATURE_METHOD_VALUE));
       request.getOAuthValues().add( new BasicNameValuePair(HEADER_TIMESTAMP_NAME, String.valueOf(new Date().getTime())));
       request.getOAuthValues().add( new BasicNameValuePair(HEADER_VERSION_NAME, HEADER_VERSION_VALUE));
   }

   private static void  signatureRequest(ServiceRequest request, String key){
       String signature = generateSignatureString(request,key);
       request.getOAuthValues().add( new BasicNameValuePair(HEADER_SIGNATURE_NAME, signature));
   }



   private static String generateSignatureString(ServiceRequest request, String key){
       String baseString = getPostSignaturePlainString(request);
       byte[] buffer = HmacCrpto.digestSHA1ToBytes(baseString,key);
       return Base64.encodeToString( buffer, Base64.NO_WRAP);
   }

   private static String getPostSignaturePlainString(ServiceRequest req){
       String q1 = req.getMethod();
       String q2 = req.getFullURI();
       String q3 = "";

       SortedMap<String,String> sortedMap = new TreeMap<String,String>();
       for(NameValuePair pair : req.getParams()){
           sortedMap.put(pair.getName(),pair.getValue());
       }
       for (NameValuePair pair : req.getOAuthValues() )
           sortedMap.put(pair.getName(), pair.getValue());

       Iterator it =  sortedMap.keySet().iterator();
       while (it.hasNext())
       {
           Object key = it.next();
           q3 += key + "=" + sortedMap.get(key) + "&";
       }
       q3 = q3.substring(0,q3.length()-1);

       return URLEncoder(q1)+ "&"
             + URLEncoder(q2)+ "&"
             + URLEncoder(q3);
   }

    public static String URLEncoder(String s){
       return URLEncoder.encode(s);
    }
}
