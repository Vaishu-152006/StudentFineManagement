package com.studfinemanagement;

import java.time.LocalDate;

public class Payment {

    private int paymentId;
    private int studentId;
    private int fineId;
    private int amount;
    private LocalDate paymentDate;

    public Payment(int paymentId, int studentId, int fineId, int amount, LocalDate paymentDate) {
        this.paymentId = paymentId;
        this.studentId = studentId;
        this.fineId = fineId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getFineId() {
        return fineId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +"paymentId=" + paymentId +", studentId=" + studentId +", fineId=" + fineId +", amount=" + amount +", paymentDate=" + paymentDate +'}';
    }
}