package com.naild2d.android.service_test;

import com.naild2d.android.model.PackageInfo;
import com.naild2d.android.model.PackageScheduleInfo;
import com.naild2d.android.model.ServiceInfo;
import com.naild2d.android.service.PackageService;

/**
 * Created by ebread on 2015/6/25.
 */
public class PackageServiceTestRunner implements ServiceTestRunner {
    PackageService packageService = new PackageService();

    @Override
    public void RunTest(ServiceTestContext context) {
        PackageInfo[] packageInfos = packageService.getPackageInfo(40.070656, 116.410408, 10, 1);
        ServiceInfo[] serviceInfos = packageService.getServiceInfoList("1888", 1, 10);
        ServiceInfo serviceInfo = packageService.getServiceInfo("1930");
        PackageScheduleInfo[] packageScheduleInfos = packageService.getScheduleInfo("1888");
    }
}
