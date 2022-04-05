package com.springboot.my.org.crudapi.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.my.org.crudapi.models.Bonus;
import com.springboot.my.org.crudapi.utils.DateTimeUtils;

public class BonusMapper implements RowMapper<Bonus>{

	@Override
	public Bonus mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Bonus(rs.getInt("WORKER_REF_ID"), rs.getInt("BONUS_AMOUNT"), DateTimeUtils.getUtilDate((LocalDateTime)rs.getObject("BONUS_DATE")));

	}

}
