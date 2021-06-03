package com.roudraveergobin.studentinfo.domain;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table( name = "TEACHER" )
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TEACHER_ID", unique = true, updatable = false)
    private Long teacherId;

    @Column(name = "SUBJECT_ID")
    private Long subjectId;

    @Column(name = "GROUP_ID")
    private Long groupId;

    public TeacherEntity(Long teacherId, Long subjectId, Long groupId) {
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.groupId = groupId;
    }

    public TeacherEntity() {
        super();
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
