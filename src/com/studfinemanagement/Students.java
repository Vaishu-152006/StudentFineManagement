package com.studfinemanagement;

public class Students {

    private int studentId;
    private String name;
    private String email;
    private int userId;

    public Students(int studentId, String name, String email, int userId) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.userId = userId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Students{" +"studentId=" + studentId +", name='" + name + '\'' +", email='" + email + '\'' +'}';
    }
}