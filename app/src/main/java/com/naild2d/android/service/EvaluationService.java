package com.naild2d.android.service;

import com.naild2d.android.api.EvaluationApi;
import com.naild2d.android.api.PackageApi;
import com.naild2d.android.json.IndexJSONObject;
import com.naild2d.android.log.Logger;
import com.naild2d.android.model.Evaluation;
import com.naild2d.android.service.params.EvaluationParam;

import org.json.JSONObject;

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
            IndexJSONObject json = new IndexJSONObject(jString);
            return json.getObjectArray(Evaluation.class);
        } catch (Exception e) {
            Logger.e(e);
        }

        return null;
    }

    public int addEvaluation(EvaluationParam param) {
        String jString = evaluationApi.post(
                String.valueOf(param.getOrderId()),
                param.getPostScore(),
                param.getAttitudeScore(),
                param.getQualityScore(),
                param.getPunctualScore(),
                param.getComment());
        try {
            JSONObject json = new JSONObject(jString);
            return json.getInt("evaluation");
        } catch (Exception e) {
            Logger.e(e);
        }

        return -1;
    }

    public boolean updateEvaluation(EvaluationParam param) {
        try {
            String jString = evaluationApi.update(
                    String.valueOf(param.getEvaluationId()),
                    param.getPostScore(),
                    param.getAttitudeScore(),
                    param.getQualityScore(),
                    param.getPunctualScore(),
                    param.getComment(),
                    param.getPictureId());
            return true;
        } catch (Exception e) {
            Logger.e(e);
        }

        return false;
    }
}
