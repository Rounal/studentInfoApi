package com.roudraveergobin.studentinfo.dao;

import com.roudraveergobin.studentinfo.domain.TeacherEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TeacherDao extends CrudRepository<TeacherEntity, Long> {

    @Query("select t.groupId from TeacherEntity t where t.teacherId = :id")
    Long getGroupId(@Param("id") Long id);
}
