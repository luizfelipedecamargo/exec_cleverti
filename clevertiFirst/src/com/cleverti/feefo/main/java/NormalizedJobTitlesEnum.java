package com.cleverti.feefo.main.java;

public enum NormalizedJobTitlesEnum{
    ARCHITECT("Architect"),
    SOFTWARE_ENGINEER("Software engineer"),
    QUALITY_SURVEY("Quantity survey"),
    ACCOUNTANT("Accountant");

    private final String jobTitle;

    NormalizedJobTitlesEnum(String jobTitle){
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString(){
        return jobTitle;
    }
}
