package com.naild2d.android.service_test;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ebread on 2015/6/24.
 */
public class ServiceTest {

    static List<ServiceTestRunner> testRunnerList = null;

    static {
        testRunnerList = new ArrayList<>();
        testRunnerList.add(new AccountServiceTestRunner());
    }

    public static void RunTest(ServiceTestContext context) {
        for (ServiceTestRunner runner : testRunnerList) {
            try {
                runner.RunTest(context);
            } catch (Exception e) {
                Log.e("naild2d", e.getMessage());
            }
        }
    }
}
