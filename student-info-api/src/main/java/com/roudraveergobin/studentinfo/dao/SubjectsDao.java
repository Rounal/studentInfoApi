package com.roudraveergobin.studentinfo.dao;

import com.roudraveergobin.studentinfo.domain.SubjectsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SubjectsDao extends CrudRepository<SubjectsEntity, Long> {

    @Query("from SubjectsEntity s where s.subjectId = :id")
    SubjectsEntity findSubjectById(@Param("id") Long id);

    @Query("select s.subjectId from SubjectsEntity s where s.title = :subjectTitle")
    Long findIdByTitle(@Param("subjectTitle") String subjectTitle);
}
