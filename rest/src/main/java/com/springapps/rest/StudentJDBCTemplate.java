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
        List<Student> students = jdbcTemplate.query(query, new StudentMapper());

        return students;
    }

    public Student getStudentByUID(int uid) {
        try {
            String query = "SELECT * FROM students WHERE uid = ?";
            Student student = jdbcTemplate.queryForObject(query, new Object[] {uid}, new StudentMapper());

            return student;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Student> getStudentByRollNumber(int rollNo) {
        try {
            String query = "SELECT * FROM students WHERE roll_no = ?";
            List<Student> students = jdbcTemplate.query(query, new Object[] {rollNo}, new StudentMapper());

            return students;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
