package com.example.hello_world.models;

public class Employee {
private String username;
private String password;

private String name ;

private String position;

private int leaveNumber;

private int incidentNumber;

private int undercapacity_display;
    private String activeNum;

    public int getUndercapacity_display() {
        return undercapacity_display;
    }

    public void setUndercapacity_display(int undercapacity_display) {
        this.undercapacity_display = undercapacity_display;
    }

    public String getActiveNum() {
        return activeNum;
    }

    public void setActiveNum(String activeNum) {
        this.activeNum = activeNum;
    }

    public byte[] imageByte;




    private String empId;
private String STATUS;

    private String DEPARTMENT;



    public String getDEPARTMENT() {
        return DEPARTMENT;
    }

    public void setDEPARTMENT(String DEPARTMENT) {
        this.DEPARTMENT = DEPARTMENT;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }




    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public int getIncidentNumber() {
        return incidentNumber;
    }

    public void setIncidentNumber(int incidentNumber) {
        this.incidentNumber = incidentNumber;
    }

    public int getLeaveNumber() {
        return leaveNumber;
    }

    public void setLeaveNumber(int leaveNumber) {
        this.leaveNumber = leaveNumber;
    }





    public byte[] getImageByte() {
        return imageByte;
    }

    public void setImageByte(byte[] imageByte) {
        this.imageByte = imageByte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
