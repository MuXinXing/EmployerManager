package com.mx.entity;

/**
 * @author MX
 */
public class EmployerLeave {
    private Integer employerId;
    private String employerName;
    private String employerPhone;
    private String employerDept;
    private String employerPosition;
    private String employerLeave;
    private String employerLeaveStatus;
    private String employerLeaveFile;
    public EmployerLeave() {
    }

    public EmployerLeave(Integer employerId, String employerName, String employerPhone, String employerDept, String employerPosition, String employerLeave, String employerLeaveStatus) {
        this.employerId = employerId;
        this.employerName = employerName;
        this.employerPhone = employerPhone;
        this.employerDept = employerDept;
        this.employerPosition = employerPosition;
        this.employerLeave = employerLeave;
        this.employerLeaveStatus = employerLeaveStatus;
    }

    public EmployerLeave(Integer employerId, String employerName, String employerPhone, String employerDept, String employerPosition, String employerLeave, String employerLeaveStatus, String employerLeaveFile) {
        this.employerId = employerId;
        this.employerName = employerName;
        this.employerPhone = employerPhone;
        this.employerDept = employerDept;
        this.employerPosition = employerPosition;
        this.employerLeave = employerLeave;
        this.employerLeaveStatus = employerLeaveStatus;
        this.employerLeaveFile = employerLeaveFile;
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

    public String getEmployerLeaveStatus() {
        return employerLeaveStatus;
    }

    public void setEmployerPosition(String employerPosition) {
        this.employerPosition = employerPosition;
    }

    public String getEmployerLeave() {
        return employerLeave;
    }

    public void setEmployerLeave(String employerLeave) {
        this.employerLeave = employerLeave;
    }

    public void setEmployerLeaveStatus(String employerLeaveStatus) {
        this.employerLeaveStatus = employerLeaveStatus;
    }

    public void setEmployerLeaveFile(String employerLeaveFile) {
        this.employerLeaveFile = employerLeaveFile;
    }

    public String getEmployerLeaveFile() {
        return employerLeaveFile;
    }
}
