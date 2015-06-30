package com.naild2d.android.service;

import android.content.Context;

import com.naild2d.android.api.AccountApi;
import com.naild2d.android.api.TokenApi;
import com.naild2d.android.json.IndexJSONObject;
import com.naild2d.android.log.Logger;
import com.naild2d.android.model.UserProfile;
import com.naild2d.android.network.ServiceToken;
import com.naild2d.android.network.http.HttpPostBody;

/**
 * Created by chaozhou on 3/17/2015.
 */
public class AccountService extends BaseService {

    private TokenApi tokenApi = null;
    private AccountApi accountApi = null;

    public AccountService(Context context) {
        super(context);

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
        ServiceToken.load(context);
        if (ServiceToken.ACCESS_TOKEN != null) {
            return true;
        }

        tryGetRequestToken();
        getAccessToken(phone, pwd);

        return ServiceToken.ACCESS_TOKEN != null;
    }

    public UserProfile getProfile(String phone, String pwd) {
        if (UserProfile.getUserProfile() != null) {
            return UserProfile.getUserProfile();
        }

        String jString = accountApi.profile(phone, pwd);
        try {
            IndexJSONObject json = new IndexJSONObject(jString);
            UserProfile.setUserProfile(json.getObject(UserProfile.class));
            return UserProfile.getUserProfile();
        } catch (Exception e) {
            Logger.e(e);
        }

        return null;
    }

    private void getAccessToken(String phone, String pwd) {
        getProfile(phone, pwd);

        String res = tokenApi.getAccessToken();
        HttpPostBody postBody = new HttpPostBody(res);

        ServiceToken.ACCESS_TOKEN = postBody.getValue("oauth_token");
        ServiceToken.ACCESS_SECRET = postBody.getValue("oauth_token_secret");

        ServiceToken.save(context);
    }

    private void tryGetRequestToken() {
        if (ServiceToken.REQUEST_TOKEN != null)
            return;

        String res = tokenApi.getRequestToken();
        HttpPostBody postBody = new HttpPostBody(res);

        ServiceToken.REQUEST_TOKEN = postBody.getValue("oauth_token");
        ServiceToken.REQUEST_SECRET = postBody.getValue("oauth_token_secret");
    }
}
