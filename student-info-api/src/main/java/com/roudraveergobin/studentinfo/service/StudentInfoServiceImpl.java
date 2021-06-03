package com.roudraveergobin.studentinfo.service;

import com.roudraveergobin.studentinfo.dao.*;
import com.roudraveergobin.studentinfo.domain.*;
import com.roudraveergobin.studentinfo.exception.ResourceNotFoundException;
import com.roudraveergobin.studentinfo.models.Marks;
import com.roudraveergobin.studentinfo.models.Students;
import com.roudraveergobin.studentinfo.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    private MarksDao marksDao;

    @Autowired
    private StudentsDao studentDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private SubjectsDao subjectsDao;

    @Autowired
    private GroupsDao groupsDao;

    @Override
    public Integer getMark(Long studentId) {
        List<MarksEntity> students =  marksDao.getMarksByStudentId(studentId);
        return students.stream()
                .map(MarksEntity::getMark)
                .mapToInt(i -> i==null?0: i)
                .sum();
    }

    @Override
    public Integer getNumberOfStudents(Long teacherId) {
        Long groupId = teacherDao.getGroupId(teacherId);

        return studentDao.findByGroupId(groupId);
    }

    @Override
    public Map<String, Integer> getListOfMarks(Long studentId) {
        List<MarksEntity> marksEntityList = marksDao.getMarksByStudentId(studentId);

        Map<String, Integer> marksMap = new HashMap<>();

        for (MarksEntity marksEntity : marksEntityList) {
            String subjectTitle = subjectsDao.findSubjectById(marksEntity.getSubjectId()).getTitle();
            int mark = marksEntity.getMark() == null ? 0 : marksEntity.getMark();
            marksMap.put(subjectTitle, mark);
        }

        return marksMap;
    }

    @Override
    public void addStudent(Students student) {

        StudentsEntity studentsEntity = new StudentsEntity();

        Long groupId = groupsDao.findIdByName(student.getGroupName());
        if (groupId == null) {
            groupId = addNewGroup(student.getGroupName());
        }

        studentsEntity.setFirstName(student.getFirstName());
        studentsEntity.setLastName(student.getLastName());
        studentsEntity.setGroupId(groupId);
        studentDao.save(studentsEntity);
    }

    @Override
    public void addTeacher(Teacher teacher) {

        TeacherEntity teacherEntity = new TeacherEntity();

        Long subjectId = subjectsDao.findIdByTitle(teacher.getSubjectTitle());
        if (subjectId == null) {
            subjectId = addNewSubject(teacher.getSubjectTitle());
        }

        Long groupId = groupsDao.findIdByName(teacher.getGroupName());
        if (groupId == null) {
            groupId = addNewGroup(teacher.getGroupName());
        }

        teacherEntity.setGroupId(groupId);
        teacherEntity.setSubjectId(subjectId);
        teacherDao.save(teacherEntity);
    }

    @Override
    public void addMark(Marks mark) throws ResourceNotFoundException {

        MarksEntity marksEntity = new MarksEntity();

        if(studentDao.findById(mark.getStudentId()).isPresent()){
            marksEntity.setStudentId(mark.getStudentId());
        }
        else {
            throw new ResourceNotFoundException("Student does not exist for id:" + mark.getStudentId() );
        }

        if(subjectsDao.findById(mark.getSubjectId()).isPresent()){
            marksEntity.setSubjectId(mark.getSubjectId());
        }
        else {
            throw new ResourceNotFoundException("Subject does not exist for id:" + mark.getSubjectId() );
        }

        marksEntity.setMark(mark.getMark());

        marksDao.save(marksEntity);
    }

    @Override
    public void updateStudent(Long studentId, Students student) throws ResourceNotFoundException {

        Optional<StudentsEntity> studentsEntityOptional = studentDao.findById(studentId);

        if (!studentsEntityOptional.isPresent()) {
            throw new ResourceNotFoundException("Student not found for this id: " + studentId);
        }
        else {
            Long groupId = groupsDao.findIdByName(student.getGroupName());
            if (groupId == null) {
                groupId = addNewGroup(student.getGroupName());
            }
            StudentsEntity studentsEntity = studentsEntityOptional.get();
            studentsEntity.setFirstName(student.getFirstName());
            studentsEntity.setLastName(student.getLastName());
            studentsEntity.setGroupId(groupId);
        }
    }

    @Override
    public void updateMark(Marks mark) throws ResourceNotFoundException {

        if(!studentDao.findById(mark.getStudentId()).isPresent()){
            throw new ResourceNotFoundException("Student does not exist for id:" + mark.getStudentId() );
        }

        if(!subjectsDao.findById(mark.getSubjectId()).isPresent()){
            throw new ResourceNotFoundException("Subject does not exist for id:" + mark.getSubjectId() );
        }

        Optional<MarksEntity> marksEntityOptional = marksDao.findByStudentAndSubjectId(mark.getStudentId(), mark.getSubjectId());

        if (marksEntityOptional.isPresent()) {
            MarksEntity marksEntity = marksEntityOptional.get();
            marksEntity.setMark(mark.getMark());
            marksDao.save(marksEntity);
        }
        else {
            addMark(mark);
        }
    }

    @Override
    public void deleteStudent(Long studentId) throws ResourceNotFoundException {
        Optional<StudentsEntity> studentsEntityOptional = studentDao.findById(studentId);

        if (!studentsEntityOptional.isPresent()) {
            throw new ResourceNotFoundException("Student does not exist for id:" + studentId );
        }

        StudentsEntity studentsEntity = studentsEntityOptional.get();

        marksDao.deleteById(studentId);
        studentDao.delete(studentsEntity);
    }

    @Override
    public Iterable<StudentsEntity> findAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public Iterable<SubjectsEntity> findAllSubjects() {
        return subjectsDao.findAll();
    }

    @Override
    public Students findStudentById(Long studentId) throws ResourceNotFoundException {
        Optional<StudentsEntity> studentsEntityOptional = studentDao.findById(studentId);
        if (!studentsEntityOptional.isPresent()) {
            throw new ResourceNotFoundException("Student does not exist for id:" + studentId );
        }

        Students student = new Students();
        student.setGroupName(groupsDao.findNameById(studentsEntityOptional.get().getGroupId()));
        student.setFirstName(studentsEntityOptional.get().getFirstName());
        student.setLastName(studentsEntityOptional.get().getLastName());

        return student;
    }

    private Long addNewGroup(String name) {
        GroupsEntity groupsEntity = new GroupsEntity();
        groupsEntity.setName(name);
        groupsDao.save(groupsEntity);
        return groupsEntity.getGroupId();
    }

    private Long addNewSubject(String title) {
        SubjectsEntity subjectsEntity = new SubjectsEntity();
        subjectsEntity.setTitle(title);
        subjectsDao.save(subjectsEntity);
        return subjectsEntity.getSubjectId();
    }
}
