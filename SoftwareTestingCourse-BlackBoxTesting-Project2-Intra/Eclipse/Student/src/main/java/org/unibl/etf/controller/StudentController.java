package org.unibl.etf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.model.Student;
import org.unibl.etf.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Student>> allStudents() {
		return new ResponseEntity<List<Student>>(studentService.getStudents(), HttpStatus.OK);
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable("studentId") Long studentId) {

		studentService.deleteStudent(studentId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Long studentId) {

		Optional<Student> studentOpt = studentService.getStudentById(studentId);
		if (studentOpt.isPresent())
			return new ResponseEntity<Student>(studentOpt.get(), HttpStatus.OK);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PutMapping("/{studentId}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("studentId") Long studentId) {
		student.setStudentId(studentId);
		return new ResponseEntity<Student>(studentService.updateStudent(student), HttpStatus.OK);
	}
}
