package com.springapps.rest;

import java.util.List;
import javax.sql.DataSource;

public interface StudentDAO {
    public void setDataSource(DataSource ds);

    public List<Student> listStudents();

    public Student getStudentByUID(int uid);

    public List<Student> getStudentByRollNumber(int rollNo);

    public List<Student> getStudentByCourse(String course);

    public Student addStudent(Student student);

    public Student deleteStudent(int uid);

    public Student updateStudent(Student student);
}
