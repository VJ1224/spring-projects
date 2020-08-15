package com.springapps.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
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
		return "<h1>List of API endpoints</h1>" +
				"<h3>Students</h3>" +
				"<p>GET /students/all</p>" +
				"<p>GET /students/uid/{uid}</p>" +
				"<p>GET /students/roll_no/{roll_no}</p>" +
				"<p>GET /students/course/{course}</p>" +
				"<p>POST /students/add</p>" +
				"<p>DELETE /students/delete/{uid}</p>" +
				"<p>PUT /students/update</p>";
	}

	@GetMapping("/students/all")
	public List<Student> getAllStudents() {
		return studentJDBCTemplate.listStudents();
	}

	@GetMapping("/students/uid/{uid}")
    public Student getStudentByUID(@PathVariable int uid) {
	    return studentJDBCTemplate.getStudentByUID(uid);
    }

    @GetMapping("/students/roll_no/{rollNo}")
    public List<Student> getStudentByRollNumber(@PathVariable int rollNo) {
        return studentJDBCTemplate.getStudentByRollNumber(rollNo);
    }

    @GetMapping("/students/course/{course}")
	public List<Student> getStudentByCourse(@PathVariable String course) {
		return studentJDBCTemplate.getStudentByCourse(course);
	}

    @PostMapping(value="/students/add", consumes="application/json", produces="application/json")
	public Student addStudent(@RequestBody Student student) {
		return studentJDBCTemplate.addStudent(student);
	}

	@DeleteMapping("/students/delete/{uid}")
	public Student removeStudent(@PathVariable int uid) {
		return studentJDBCTemplate.deleteStudent(uid);
	}

	@PutMapping("/students/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentJDBCTemplate.updateStudent(student);
	}

}
