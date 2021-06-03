package com.roudraveergobin.studentinfo.dao;

import com.roudraveergobin.studentinfo.domain.StudentsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentsDao extends CrudRepository<StudentsEntity, Long> {

    @Query("select count(*) from StudentsEntity s where s.groupId = :id")
    Integer findByGroupId(@Param("id") Long id);

    @Query("from StudentsEntity s where s.studentId = :id")
    Optional<StudentsEntity> findById(@Param("id") Long id);
}
