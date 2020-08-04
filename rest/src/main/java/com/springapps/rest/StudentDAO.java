package com.springapps.rest;

import java.util.List;
import javax.sql.DataSource;

public interface StudentDAO {
    public void setDataSource(DataSource ds);

    public List<Student> listStudents();
}
