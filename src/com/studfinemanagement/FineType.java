package com.studfinemanagement;

public class FineType {

    private int fineId;
    private String fineName;

    public FineType(int fineId, String fineName) {
        this.fineId = fineId;
        this.fineName = fineName;
    }

    public int getFineId() {
        return fineId;
    }

    public String getFineName() {
        return fineName;
    }

    @Override
    public String toString() {
        return "FineType{" +
                "fineId=" + fineId +
                ", fineName='" + fineName + '\'' +
                '}';
    }
}