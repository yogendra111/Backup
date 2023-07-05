package rezi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Student {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "Id")
//	private int stuID;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Roll_No")
	private int rollNo;

	@NotBlank(message = "Name cannot be Empty!!")
	@Column(name = "Name")
	private String stuName;

	@NotBlank(message = "Email cannot be Empty!!")
	@Email(message = "Enter a valid Email!")
	@Column(name = "Email")
	private String stuEmail;
	
	@NotBlank(message = "Course cannot be Empty!!")
	@Column(name = "Course")
	private String course;
	
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	
	public Student() {
		super();
	}
	public Student(String stuName, String course, int rollNo, String stuEmail) {
		super();
		this.stuName = stuName;
		this.course = course;
		this.rollNo = rollNo;
		this.stuEmail = stuEmail;
	}
	
	@Override
	public String toString() {
		return "Student: stuName=" + stuName + ", course=" + course + ", rollNo=" + rollNo + "]";
	}

}
