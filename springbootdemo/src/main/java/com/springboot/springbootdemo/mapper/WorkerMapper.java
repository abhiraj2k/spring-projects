package com.springboot.springbootdemo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.springbootdemo.model.Worker;


public class WorkerMapper implements RowMapper<Worker> {


	@Override
	public Worker mapRow(ResultSet rs, int rowNum) throws SQLException {
		Worker worker = new Worker();
		worker.setWorkerId(rs.getInt("WORKER_ID"));
		worker.setFirstName(rs.getString("FIRST_NAME"));
		worker.setLastName(rs.getString("LAST_NAME"));
		worker.setSalary(rs.getString("SALARY"));
//		worker.setJoiningDate(rs.getObject("JOINING_DATE"));
		worker.setJoiningDate(new Date());		
		worker.setDepartment(rs.getString("DEPARTMENT"));
		worker.setEmail(rs.getString("EMAIL"));
		return worker;
	}
}
