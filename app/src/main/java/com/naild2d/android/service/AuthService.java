package com.naild2d.android.service;

/**
 * Created by chao_zhou on 15/1/26.
 */
public interface AuthService {

    public boolean Register(String phone, String code, String pwd, String ref);

    public boolean Login(String phone, String pwd);

    public boolean ForgetPassword(String phone);

    public boolean ResetPassword(String phone, String oldPwd, String newPwd);

}
