package com.roudraveergobin.studentinfo.dao;

import com.roudraveergobin.studentinfo.domain.MarksEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarksDao extends CrudRepository<MarksEntity, Long> {

    @Query("from MarksEntity m where m.studentId = :id")
    List<MarksEntity> getMarksByStudentId(@Param("id") Long id);

    @Query("from MarksEntity m where m.studentId = :studentId and m.subjectId = :subjectId ")
    Optional<MarksEntity> findByStudentAndSubjectId(@Param("studentId") Long studentId, @Param("subjectId") Long subjectId);
}
