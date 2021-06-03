package com.roudraveergobin.studentinfo.domain;

import javax.persistence.*;

@Entity
@Table(name = "SUBJECTS")
public class SubjectsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SUBJECT_ID", unique = true, updatable = false)
    private Long subjectId;

    @Column(name = "TITLE", unique = true)
    private String title;

    public SubjectsEntity() {
        super();
    }

    public SubjectsEntity(Long subjectId, String title) {
        this.subjectId = subjectId;
        this.title = title;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
