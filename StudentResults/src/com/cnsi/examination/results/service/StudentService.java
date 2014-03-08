package com.cnsi.examination.results.service;


import java.util.List;

import com.cnsi.examination.results.vo.Student;

public interface StudentService {
    public List getAllStudents();
    public void updateStudent(Student emp);
    public void deleteStudent(Integer id);
    public Student getStudent(Integer id);
    public void insertStudent(Student emp);
}
