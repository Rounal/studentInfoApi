package com.roudraveergobin.studentinfo.domain;

import javax.persistence.*;

@Entity
@Table( name = "GROUPS" )
public class GroupsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GROUP_ID", unique = true, updatable = false)
    private Long groupId;

    @Column(name = "NAME", unique = true)
    private String name;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
