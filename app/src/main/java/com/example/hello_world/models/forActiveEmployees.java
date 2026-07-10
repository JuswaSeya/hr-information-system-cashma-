package com.example.hello_world.models;

public class forActiveEmployees {
    private String EMP_ID;
    private String EMP_NAME;
    private String POSITION;
    private String DEPARTMENT;
    private String STATUS;

    public forActiveEmployees(String EMP_ID, String EMP_NAME, String POSITION, String DEPARTMENT, String STATUS) {
        this.EMP_ID = EMP_ID;
        this.EMP_NAME = EMP_NAME;
        this.POSITION = POSITION;
        this.DEPARTMENT = DEPARTMENT;
        this.STATUS = STATUS;
    }

    public String getEMP_ID() {
        return EMP_ID;
    }

    public void setEMP_ID(String EMP_ID) {
        this.EMP_ID = EMP_ID;
    }

    public String getEMP_NAME() {
        return EMP_NAME;
    }

    public void setEMP_NAME(String EMP_NAME) {
        this.EMP_NAME = EMP_NAME;
    }

    public String getPOSITION() {
        return POSITION;
    }

    public void setPOSITION(String POSITION) {
        this.POSITION = POSITION;
    }

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
}
