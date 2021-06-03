package com.roudraveergobin.studentinfo.service;

import com.roudraveergobin.studentinfo.domain.StudentsEntity;
import com.roudraveergobin.studentinfo.domain.SubjectsEntity;
import com.roudraveergobin.studentinfo.exception.ResourceNotFoundException;
import com.roudraveergobin.studentinfo.models.Marks;
import com.roudraveergobin.studentinfo.models.Students;
import com.roudraveergobin.studentinfo.models.Teacher;

import java.util.Map;

public interface StudentInfoService {

    Integer getMark(Long studentId);

    Integer getNumberOfStudents(Long teacherId);

    Map<String, Integer> getListOfMarks(Long studentId);

    void addStudent(Students student);

    void addTeacher(Teacher teacher);

    void addMark(Marks mark) throws ResourceNotFoundException;

    void updateStudent(Long studentId, Students student) throws ResourceNotFoundException;

    void updateMark(Marks mark) throws ResourceNotFoundException;

    void deleteStudent(Long studentId) throws ResourceNotFoundException;

    Iterable<StudentsEntity> findAllStudents();

    Iterable<SubjectsEntity> findAllSubjects();

    Students findStudentById(Long studentId) throws ResourceNotFoundException;
}
