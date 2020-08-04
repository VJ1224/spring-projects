package com.springapps.rest;

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
}
