package com.springboot.my.org.crudapi.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.my.org.crudapi.models.Bonus;
import com.springboot.my.org.crudapi.models.Title;
import com.springboot.my.org.crudapi.models.Worker;

public class WorkerBonusTitleMapper implements RowMapper<Worker>{

	@Override
	public Worker mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bonus bonus = new Bonus(rs.getInt("WORKER_REF_ID"), rs.getInt("BONUS_AMOUNT"), new Date());
		Title title = new Title(rs.getInt("WORKER_REF_ID"), rs.getString("WORKER_TITLE"), new Date());
//		Worker worker = new Worker(rs.getInt("WORKER_ID"),rs.getString("FIRST_NAME"),rs.getString("LAST_NAME"),rs.getString("SALARY"),new Date(),rs.getString("DEPARTMENT"),rs.getString("EMAIL"), bonus, title);

		return new Worker();
	}
}
