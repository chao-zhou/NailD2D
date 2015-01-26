package com.naild2d.android.service;

/**
 * Created by chao_zhou on 15/1/26.
 */
public interface PackageService extends Service {

    public PackageInfo[] getPackages(String lat, String lon, int pageSize, int pageNumber);

    public ServiceInfo[] getService(int packageId, int pageSize, int pageNumber);

    public EvaluationInfo[] getEvaluation(int packageId, int pageSize, int pageNumber);


}
