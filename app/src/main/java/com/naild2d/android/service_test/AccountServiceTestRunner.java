package com.naild2d.android.service_test;

import com.naild2d.android.model.UserProfile;
import com.naild2d.android.service.AccountService;

/**
 * Created by ebread on 2015/6/24.
 */
public class AccountServiceTestRunner implements ServiceTestRunner {
    private AccountService service = new AccountService();

    @Override
    public void RunTest(ServiceTestContext context) {
        boolean loginResult = service.login("18600406362", "123456");
        UserProfile userProfile = service.getProfile("18600406362", "123456");
        boolean code = service.getCertCode("18600406362");
    }
}
