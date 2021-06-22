package com.mx.entity;

/**
 * @author MX
 */
public class Employer {
    private Integer employerId;
    private String employerName;
    private String employerPhone;
    private String employerDept;
    private String employerPosition;
    private float employerSalary;

    public Employer() {
    }

    public Employer(Integer employerId, String employerName, String employerPhone, String employerDept, String employerPosition, float employerSalary) {
        this.employerId = employerId;
        this.employerName = employerName;
        this.employerPhone = employerPhone;
        this.employerDept = employerDept;
        this.employerPosition = employerPosition;
        this.employerSalary = employerSalary;
    }


    public Integer getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Integer employerId) {
        this.employerId = employerId;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerPhone() {
        return employerPhone;
    }

    public void setEmployerPhone(String employerPhone) {
        this.employerPhone = employerPhone;
    }

    public String getEmployerDept() {
        return employerDept;
    }

    public void setEmployerDept(String employerDept) {
        this.employerDept = employerDept;
    }

    public String getEmployerPosition() {
        return employerPosition;
    }

    public void setEmployerPosition(String employerPosition) {
        this.employerPosition = employerPosition;
    }

    public float getEmployerSalary() {
        return employerSalary;
    }

    public void setEmployerSalary(float employerSalary) {
        this.employerSalary = employerSalary;
    }

}
