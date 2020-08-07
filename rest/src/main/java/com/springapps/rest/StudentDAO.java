package com.springapps.rest;

import java.util.List;
import javax.sql.DataSource;

public interface StudentDAO {
    void setDataSource(DataSource ds);

    List<Student> listStudents();

    Student getStudentByUID(int uid);

    List<Student> getStudentByRollNumber(int rollNo);

    List<Student> getStudentByCourse(String course);

    Student addStudent(Student student);

    Student deleteStudent(int uid);

    Student updateStudent(Student student);
}
