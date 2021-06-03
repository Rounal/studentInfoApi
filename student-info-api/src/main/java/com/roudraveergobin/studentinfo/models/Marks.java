package com.roudraveergobin.studentinfo.models;

public class Marks {

    private Long studentId;
    private Long subjectId;
    private Integer mark;

    public Marks(Long studentId, Long subjectId, Integer mark) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.mark = mark;
    }

    public Marks() {
        super();
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
