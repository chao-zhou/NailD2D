package com.naild2d.android.service;

import com.naild2d.android.api.AccountApi;
import com.naild2d.android.api.TokenApi;
import com.naild2d.android.network.ServiceToken;

/**
 * Created by chaozhou on 3/17/2015.
 */
public class AccountService {

    TokenApi tokenApi = null;
    AccountApi accountApi = null;

    public AccountService(){
        tokenApi = new TokenApi();
        accountApi = new AccountApi();
    }

    public boolean login(String phone, String pwd){

        if(ServiceToken.ACCESS_TOKEN != null){
            return true;
        }
        tryGetRequestToken();
        getAccessToken(phone, pwd);

        return ServiceToken.ACCESS_TOKEN != null;
    }

    private void getAccessToken(String phone, String pwd) {
        accountApi.profile(phone,pwd);

        String res = tokenApi.getAccessToken();
        res = res.replace("oauth_token=","");
        res = res.replace("oauth_token_secret=","");
        String[] values = res.split("&");

        ServiceToken.ACCESS_TOKEN = values[0];
        ServiceToken.ACCESS_SECRET = values[1];

        ServiceToken.save();
    }

    private void tryGetRequestToken(){
        if(ServiceToken.REQUEST_TOKEN !=null)
            return;

        String res = tokenApi.getRequestToken();
        res = res.replace("oauth_token=","");
        res = res.replace("oauth_token_secret=","");
        String[] values = res.split("&");

        ServiceToken.REQUEST_TOKEN = values[0];
        ServiceToken.CUSTOMER_SECRET = values[1];
    }
}
