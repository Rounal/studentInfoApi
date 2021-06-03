package com.roudraveergobin.studentinfo.models;

public class Students {

    private String firstName;
    private String lastName;
    private String groupName;

    public Students(String firstName, String lastName, String groupName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupName = groupName;
    }

    public Students() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
