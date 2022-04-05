package com.springboot.my.org.crudapi.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.my.org.crudapi.models.Title;
import com.springboot.my.org.crudapi.utils.DateTimeUtils;

public class TitleMapper implements RowMapper<Title> {

	@Override
	public Title mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Title(rs.getInt("WORKER_REF_ID"), rs.getString("WORKER_TITLE"), DateTimeUtils.getUtilDate((LocalDateTime) rs.getObject("AFFECTED_FROM")));
	}
	
}
