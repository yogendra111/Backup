package rezi.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rezi.entities.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao stuDao;

	@Override
	public void addStudent(Student stu) {
		stuDao.addRecord(stu);		
	}

	@Override
	public List<Student> getStudents() {
		return stuDao.getRecords();
	}

	@Override
	public void deleteStudent(int rollno) {
		stuDao.deleteRecord(rollno);
	}

	@Override
	public void updateStudent(Student stu) {
		stuDao.updateRecord(stu);
	}

	@Override
	public Student getStudent(int rollNo) {
		return stuDao.getRecord(rollNo);
	}

}
