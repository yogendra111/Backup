package rezi.daos;

import java.util.List;

import rezi.entities.Student;

public interface StudentService {
	
	void addStudent(Student stu);
	List<Student> getStudents();
	void deleteStudent(int stuID);
	void updateStudent(Student stu);
	Student getStudent(int stuID);

}
