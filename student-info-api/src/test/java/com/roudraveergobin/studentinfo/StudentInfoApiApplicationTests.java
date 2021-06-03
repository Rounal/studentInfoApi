package com.roudraveergobin.studentinfo;

import com.roudraveergobin.studentinfo.controller.StudentInfoController;
import com.roudraveergobin.studentinfo.dao.MarksDao;
import com.roudraveergobin.studentinfo.dao.StudentsDao;
import com.roudraveergobin.studentinfo.dao.SubjectsDao;
import com.roudraveergobin.studentinfo.dao.TeacherDao;
import com.roudraveergobin.studentinfo.domain.MarksEntity;
import com.roudraveergobin.studentinfo.domain.StudentsEntity;
import com.roudraveergobin.studentinfo.domain.SubjectsEntity;
import com.roudraveergobin.studentinfo.domain.TeacherEntity;
import com.roudraveergobin.studentinfo.models.Students;
import com.roudraveergobin.studentinfo.models.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class StudentInfoApiApplicationTests {

	@Test
	void contextLoads() {
	}


}
