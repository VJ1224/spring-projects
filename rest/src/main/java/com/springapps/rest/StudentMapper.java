package com.springapps.rest;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {
    public Student mapRow(ResultSet rs, int row) throws SQLException {
        Student std = new Student();
        std.setUid(rs.getInt("uid"));
        std.setName(rs.getString("name"));
        std.setRollNo(rs.getInt("roll_no"));

        return std;
    }
}
