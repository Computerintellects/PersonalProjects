package com.cnsi.examination.results.service;

import com.cnsi.examination.results.persistence.StudentDao;
import com.cnsi.examination.results.persistence.StudentDaoImpl;
import com.cnsi.examination.results.service.StudentService;
import com.cnsi.examination.results.vo.Student;

import java.util.List;


public class StudentDaoService implements StudentService {
    private StudentDao dao;

    public StudentDaoService() {
        this.dao = new StudentDaoImpl();
    }

    public List getAllStudents() {
        return dao.getAllStudents();
    }

    public void updateStudent(Student emp) {
        dao.update(emp);
    }

    public void deleteStudent(Integer id) {
        dao.delete(id);
    }

    public Student getStudent(Integer id) {
        return dao.getStudent(id);
    }

    public void insertStudent(Student emp) {
        dao.insert(emp);
    }
}
