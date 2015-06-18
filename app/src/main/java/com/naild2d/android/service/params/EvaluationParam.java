package com.naild2d.android.service.params;

/**
 * Created by ebread on 2015/6/18.
 */
public class EvaluationParam {
    private int evaluationId;
    private int orderId;
    private double postScore;
    private double attitudeScore;
    private double qualityScore;
    private double punctualScore;
    private String comment;
    private int pictureId;

    public int getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getPostScore() {
        return postScore;
    }

    public void setPostScore(double postScore) {
        this.postScore = postScore;
    }

    public double getAttitudeScore() {
        return attitudeScore;
    }

    public void setAttitudeScore(double attitudeScore) {
        this.attitudeScore = attitudeScore;
    }

    public double getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(double qualityScore) {
        this.qualityScore = qualityScore;
    }

    public double getPunctualScore() {
        return punctualScore;
    }

    public void setPunctualScore(double punctualScore) {
        this.punctualScore = punctualScore;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
}
