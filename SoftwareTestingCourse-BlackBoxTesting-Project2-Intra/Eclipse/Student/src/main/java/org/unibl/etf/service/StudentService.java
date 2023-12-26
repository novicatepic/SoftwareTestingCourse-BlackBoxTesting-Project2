package org.unibl.etf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unibl.etf.model.Student;
import org.unibl.etf.model.StudentRepository;
import java.util.Optional;



@Service
@Transactional
public class StudentService {
 
	@Autowired
	private StudentRepository studentRepository;
	

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	
	public void deleteStudent(Long studentId) {
		studentRepository.deleteById(studentId);
	}

	
	public Optional<Student> getStudentById(Long studentId) {
		return studentRepository.findById(studentId);
	}


	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

}
