package com.cnsi.examination.results.persistence;


import java.util.List;

import com.cnsi.examination.results.vo.Student;

public interface StudentDao {
    public List getAllStudents();
    public Student getStudent(Integer id);
    public void update(Student emp);
    public void insert(Student emp);
    public void delete(Integer id);
}
