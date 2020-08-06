package com.springapps.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
@RestController
public class RestApplication {
	static StudentJDBCTemplate studentJDBCTemplate;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		SpringApplication.run(RestApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("/")
	public String home() {
		return "Hello World!";
	}

	@GetMapping("/students/all")
	public List<Student> getAllStudents() {
		List<Student> students = studentJDBCTemplate.listStudents();
		return students;
	}

	@GetMapping("/students/uid/{uid}")
    public Student getStudentByUID(@PathVariable int uid) {
	    Student student = studentJDBCTemplate.getStudentByUID(uid);
	    return student;
    }

    @GetMapping("/students/roll_no/{rollNo}")
    public List<Student> getStudentByRollNumber(@PathVariable int rollNo) {
        List<Student> students = studentJDBCTemplate.getStudentByRollNumber(rollNo);
        return students;
    }

}
