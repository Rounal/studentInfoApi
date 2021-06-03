package com.roudraveergobin.studentinfo.controller;

import com.roudraveergobin.studentinfo.domain.StudentsEntity;
import com.roudraveergobin.studentinfo.domain.SubjectsEntity;
import com.roudraveergobin.studentinfo.exception.ResourceNotFoundException;
import com.roudraveergobin.studentinfo.models.Marks;
import com.roudraveergobin.studentinfo.models.Students;
import com.roudraveergobin.studentinfo.models.Teacher;
import com.roudraveergobin.studentinfo.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;

    @GetMapping("/getMark/studentId={studentId}")
    public Integer getMark(@PathVariable Long studentId) {
        return studentInfoService.getMark(studentId);
    }

    @GetMapping("/getNumberOfStudentsForTeacher/teacherId={teacherId}")
    public Integer getNumberOfStudentsForTeacher(@PathVariable Long teacherId) {
        return studentInfoService.getNumberOfStudents(teacherId);
    }

    @GetMapping("/getListOfMarks/studentId={studentId}")
    public Map<String, Integer> getListOfMarks(@PathVariable Long studentId) {
        return studentInfoService.getListOfMarks(studentId);
    }

    @GetMapping("/findAllStudents")
    public Iterable<StudentsEntity> findAllStudents() {
        return studentInfoService.findAllStudents();
    }

    @GetMapping("/findAllSubjects")
    public Iterable<SubjectsEntity> findAllSubjects() {
        return studentInfoService.findAllSubjects();
    }

    @GetMapping("/findStudentById/{studentId}")
    public Students findStudentById(@PathVariable long studentId) throws ResourceNotFoundException {
        return studentInfoService.findStudentById(studentId);
    }

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Students student) {
        studentInfoService.addStudent(student);
    }

    @PostMapping("/addTeacher")
    public void addTeacher(@RequestBody Teacher teacher) {
        studentInfoService.addTeacher(teacher);
    }

    @PostMapping("/addMark")
    public void addMark(@RequestBody Marks mark) throws ResourceNotFoundException {
        studentInfoService.addMark(mark);
    }

    @PutMapping("/updateStudent/{studentId}")
    public void updateStudent(@PathVariable Long studentId, @RequestBody Students student) throws ResourceNotFoundException {
        studentInfoService.updateStudent(studentId, student);
    }

    @PutMapping("/updateMark/")
    public void updateMark(@RequestBody Marks mark) throws ResourceNotFoundException {
        studentInfoService.updateMark(mark);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) throws ResourceNotFoundException {
        studentInfoService.deleteStudent(studentId);
    }
}
