package com.studfinemanagement;

public class Balance {

    private int id;
    private int studentId;
    private int totalBalance;

    public Balance(int id, int studentId, int totalBalance) {
        this.id = id;
        this.studentId = studentId;
        this.totalBalance = totalBalance;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(int totalBalance) {
        this.totalBalance = totalBalance;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "studentId=" + studentId +
                ", totalBalance=" + totalBalance +
                '}';
    }
}