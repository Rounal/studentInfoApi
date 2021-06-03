package com.roudraveergobin.studentinfo.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table( name = "MARKS" )
public class MarksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MARK_ID", unique = true, updatable = false)
    private Long markId;

    @Column(name = "STUDENT_ID")
    private Long studentId;

    @Column(name = "SUBJECT_ID")
    private Long subjectId;

    @UpdateTimestamp
    @Column(name = "DATE")
    private LocalDateTime date;

    @Column(name = "MARK")
    private Integer mark;

    public MarksEntity() {
        super();
    }

    public MarksEntity(Long markId, Long studentId, Long subjectId, LocalDateTime date, Integer mark) {
        this.markId = markId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.date = date;
        this.mark = mark;
    }

    public Long getMarkId() {
        return markId;
    }

    public void setMarkId(long markId) {
        this.markId = markId;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
