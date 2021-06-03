package com.roudraveergobin.studentinfo.models;

public class Teacher {

    // Teacher teaches a subject
    private String subjectTitle;

    // Teacher works with a group
    private String groupName;

    public Teacher() {
    }

    public Teacher(String subjectTitle, String groupName) {
        this.subjectTitle = subjectTitle;
        this.groupName = groupName;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
