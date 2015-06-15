package com.naild2d.android.service;

import com.naild2d.android.api.EvaluationApi;
import com.naild2d.android.api.PackageApi;
import com.naild2d.android.json.IndexJsonObject;
import com.naild2d.android.log.Logger;
import com.naild2d.android.model.Evaluation;

/**
 * Created by ebread on 2015/6/15.
 */
public class EvaluationService {
    private EvaluationApi evaluationApi = null;
    private PackageApi packageApi = null;

    public EvaluationService() {
        evaluationApi = new EvaluationApi();
        packageApi = new PackageApi();
    }

    public Evaluation[] getEvaluations(String pack, int page_size, int page) {
        String jString = packageApi.getEvaluation(pack, page_size, page);
        try {
            IndexJsonObject json = new IndexJsonObject(jString);
            return json.getObjectArray(Evaluation.class);
        } catch (Exception e) {
            Logger.e(e);
        }

        return null;
    }
}
