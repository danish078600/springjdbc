package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoimple implements StudentDao{

	private JdbcTemplate temp;
	public JdbcTemplate getTemp() {
		return temp;
	}
	public void setTemp(JdbcTemplate temp) {
		this.temp = temp;
	}
	public int insert(Student student) {
		String q="insert into student(id,name,city) values(?,?,?)";
		int r=this.temp.update(q,student.getId(),student.getName(),student.getCity());
		return r;
	}
	public int update(Student student) {
		// updating data
		String q="update student set name=?,city=? where id=?";
		int r=this.temp.update(q,student.getName(),student.getCity(),student.getId());
		
		return r;
	}
	public int delete(int studentId) {
		// delete
		String q="delete from student where id=?";
		int r=this.temp.update(q,studentId);
		return r;
	}
	public Student getStudent(int studentId) {
		// selcting single student data
		String q="select * from student where id=?";
		RowMapper<Student> rm=new RowMapperImpl();
		Student s =this.temp.queryForObject(q,rm,studentId);
		return s;
	}
	public List<Student> getAllStudent() {
		// selecting multiple student
		String q="select * from student";
		List<Student> students=this.temp.query(q, new RowMapperImpl());
		return students;
	}

}
