package com.naild2d.android.service;

import com.naild2d.android.api.AccountApi;
import com.naild2d.android.api.TokenApi;
import com.naild2d.android.json.IndexJsonObject;
import com.naild2d.android.log.Logger;
import com.naild2d.android.model.UserProfile;
import com.naild2d.android.network.ServiceToken;

/**
 * Created by chaozhou on 3/17/2015.
 */
public class AccountService {

    private TokenApi tokenApi = null;
    private AccountApi accountApi = null;

    public AccountService() {
        tokenApi = new TokenApi();
        accountApi = new AccountApi();
    }

    public boolean getCertCode(String phone) {
        return accountApi.requestNewUser(phone) != null;
    }

    public boolean register(String phone, String pwd, String code, String ref) {
        String res = accountApi.register(phone, pwd, code, ref);
        return res != null;
    }

    public boolean login(String phone, String pwd) {

        if (ServiceToken.ACCESS_TOKEN != null) {
            return true;
        }
        tryGetRequestToken();
        getAccessToken(phone, pwd);

        return ServiceToken.ACCESS_TOKEN != null;
    }

    public UserProfile getProfile(String phone, String pwd) {

        String jString = accountApi.profile(phone, pwd);
        try {
            IndexJsonObject json = new IndexJsonObject(jString);
            return json.getObject(UserProfile.class);
        } catch (Exception e) {
            Logger.e(e);
        }

        return null;
    }

    private void getAccessToken(String phone, String pwd) {
        accountApi.profile(phone, pwd);

        String res = tokenApi.getAccessToken();
        res = res.replace("oauth_token=", "");
        res = res.replace("oauth_token_secret=", "");
        String[] values = res.split("&");

        ServiceToken.ACCESS_TOKEN = values[0];
        ServiceToken.ACCESS_SECRET = values[1];

        ServiceToken.save();
    }

    private void tryGetRequestToken() {
        if (ServiceToken.REQUEST_TOKEN != null)
            return;

        String res = tokenApi.getRequestToken();
        res = res.replace("oauth_token=", "");
        res = res.replace("oauth_token_secret=", "");
        String[] values = res.split("&");

        ServiceToken.REQUEST_TOKEN = values[0];
        ServiceToken.REQUEST_SECRET = values[1];
    }
}
