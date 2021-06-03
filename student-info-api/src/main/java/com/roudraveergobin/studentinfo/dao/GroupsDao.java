package com.roudraveergobin.studentinfo.dao;

import com.roudraveergobin.studentinfo.domain.GroupsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GroupsDao extends CrudRepository<GroupsEntity, Long> {

    @Query("select g.groupId from GroupsEntity g where g.name = :name")
    Long findIdByName(@Param("name") String name);

    @Query("select g.name from GroupsEntity g where g.groupId = :groupId")
    String findNameById(@Param("groupId") Long groupId);
}
