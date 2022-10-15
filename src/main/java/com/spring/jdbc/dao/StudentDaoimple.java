package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

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

}
