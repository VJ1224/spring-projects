package com.springapps.rest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Student> listStudents() {
        String query = "SELECT * FROM students";

        return jdbcTemplate.query(query, new StudentMapper());
    }

    public Student getStudentByUID(int uid) {
        try {
            String query = "SELECT * FROM students WHERE uid = ?";

            return jdbcTemplate.queryForObject(query, new Object[] {uid}, new StudentMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Student> getStudentByRollNumber(int rollNo) {
        try {
            String query = "SELECT * FROM students WHERE roll_no = ?";

            return jdbcTemplate.query(query, new Object[] {rollNo}, new StudentMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Student> getStudentByCourse(String course) {
        try {
            String query = "SELECT * FROM students WHERE course = ?";

            return jdbcTemplate.query(query, new Object[] {course}, new StudentMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Student addStudent(Student student) {
        String query = "INSERT INTO students VALUES (?, ?, ?, ?)";
        Object[] params = new Object[] { new Object[] {student.getUid(), student.getName(), student.getRollNo(), student.getCourse()}};
        jdbcTemplate.update(query, params);

        return student;
    }

    public Student deleteStudent(int uid) {
        Student student = getStudentByUID(uid);
        String query = "DELETE FROM students WHERE uid = ?";
        jdbcTemplate.update(query, new Object[] { new Object[] {uid}});

        return student;
    }

    public Student updateStudent(Student student) {
        String query = "UPDATE students SET name = ?, roll_no = ?, course = ? WHERE uid = ?";
        Object[] params = new Object[]{student.getName(), student.getRollNo(), student.getCourse(), student.getUid()};
        jdbcTemplate.update(query, params);

        return student;
    }
}
