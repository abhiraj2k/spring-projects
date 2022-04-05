package com.springboot.my.org.crudapi.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.my.org.crudapi.models.Worker;
import com.springboot.my.org.crudapi.utils.DateTimeUtils;




public class WorkerMapper implements RowMapper<Worker> {
	@Override
	public Worker mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Worker(rs.getInt("WORKER_ID"),rs.getString("FIRST_NAME"),rs.getString("LAST_NAME"),rs.getString("SALARY"),DateTimeUtils.getUtilDate((LocalDateTime)rs.getObject("JOINING_DATE")),rs.getString("DEPARTMENT"),rs.getString("EMAIL"));
	}
}
