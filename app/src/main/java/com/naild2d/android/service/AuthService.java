package com.naild2d.android.service;

/**
 * Created by chao_zhou on 15/1/26.
 */
public interface AuthService extends Service {

    public boolean register(String phone, String code, String pwd, String ref);

    public boolean login(String phone, String pwd);

    public boolean forgetPassword(String phone);

    public boolean resetPassword(String phone, String oldPwd, String newPwd);

}
