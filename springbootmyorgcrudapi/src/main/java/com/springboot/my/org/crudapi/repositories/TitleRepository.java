package com.springboot.my.org.crudapi.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.my.org.crudapi.dao.TitleDAO;
import com.springboot.my.org.crudapi.mappers.TitleMapper;
import com.springboot.my.org.crudapi.models.Title;

@Repository("titleMysqlRepository")
public class TitleRepository implements TitleDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
		
	@SuppressWarnings("deprecation")
	@Override
	public List<Title> getWorkerWithTitle(int id)  {
		String sql = """
				SELECT * FROM title 
				WHERE title.WORKER_REF_ID = ? ;""";
//		INNER JOIN worker ON
//		worker.WORKER_ID = title.WORKER_REF_ID
		try {
			return this.jdbcTemplate.query(sql,new Object[] {id}, new TitleMapper());
		}catch(DataAccessException e) {
			e.getMessage();
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Title> getAllWorkersWithTitleInDept(String dept)  {
		String sql = """
				SELECT WORKER_REF_ID, WORKER_TITLE, AFFECTED_FROM FROM title
				INNER JOIN worker ON
				worker.WORKER_ID = title.WORKER_REF_ID 
				WHERE worker.DEPARTMENT LIKE ? ;""";
		try {
			return this.jdbcTemplate.query(sql,new Object[] {dept}, new TitleMapper());
		}catch(DataAccessException e) {
			e.getMessage();
			return null;
		}
	}

	@Override
	public int createTitle(int id, String title)  {
		String sql = """
				INSERT INTO title 
				(WORKER_REF_ID, WORKER_TITLE, AFFECTED_FROM)
				VALUES (?,?,?);""";
		try {
			return this.jdbcTemplate.update(sql, new Object[] {id, title, new Date()}, new TitleMapper());
		}catch(DataAccessException e) {
			e.getMessage();
			return 0;
		}
	}

	@Override
	public int deleteTitleLatest(int id)  {
		String sql = """
				DELETE FROM title
				WHERE WORKER_REF_ID, WORKER_TITLE, AFFECTED_FROM in 
				(SELECT t.WORKER_REF_ID, t.WORKER_TITLE, t.AFFECTED_FROM FROM worker 
				INNER JOIN title t ON
				worker.WORKER_ID = t.WORKER_REF_ID
				WHERE worker.WORKER_ID = ? 
				ORDER BY t.AFFECTED_FROM 
				LIMIT 1)""";
		try {
			return this.jdbcTemplate.update(sql, new Object[] {id}, new TitleMapper());
		}catch(DataAccessException e) {
			e.getMessage();
			return 0;
		}
	}

}
