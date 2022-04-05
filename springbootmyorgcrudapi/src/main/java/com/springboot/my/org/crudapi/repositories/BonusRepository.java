package com.springboot.my.org.crudapi.repositories;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.my.org.crudapi.dao.BonusDAO;
import com.springboot.my.org.crudapi.mappers.BonusMapper;
import com.springboot.my.org.crudapi.mappers.WorkerBonusTitleMapper;
import com.springboot.my.org.crudapi.models.Bonus;
import com.springboot.my.org.crudapi.models.Worker;

@Repository("bonusMysqlRepository")
public class BonusRepository implements BonusDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	@Override
	public List<Bonus> getWorkerWithBonus(int id) {
		String sql = """
				SELECT * FROM bonus 
				WHERE bonus.WORKER_REF_ID = ? ;""";
//		INNER JOIN worker ON
//		worker.WORKER_ID = bonus.WORKER_REF_ID
		try {
			return this.jdbcTemplate.query(sql,new Object[] {id}, new BonusMapper());
		}catch(DataAccessException e) {
			e.getMessage();
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Bonus> getWorkerBonusByDept(String department)   {
		String sql = """
				SELECT WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE FROM bonus
				INNER JOIN worker ON
				worker.WORKER_ID = bonus.WORKER_REF_ID 
				WHERE worker.DEPARTMENT LIKE ? ;""";
		try {
			return this.jdbcTemplate.query(sql,new Object[] {department}, new BonusMapper());
		}catch(DataAccessException e) {
			e.getMessage();
			return null;
		}
	}

	@Override
	public int createBonus(int id, Bonus bonus)   {
		String sql = """
				INSERT INTO bonus 
				(WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE)
				VALUES (?,?,?);""";
		try {
			return this.jdbcTemplate.update(sql, new Object[] {id, bonus.getBonusAmount(), bonus.getBonusDate()}, new BonusMapper());
		}catch(DataAccessException e) {
			e.getMessage();
			return 0;
		}
	}

	@Override
	public int deleteBonusLatest(int id)   {
		String sql = """
				DELETE FROM bonus
				WHERE WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE in 
				(SELECT b.WORKER_REF_ID, b.BONUS_AMOUNT, b.BONUS_DATE FROM worker 
				INNER JOIN bonus b ON
				worker.WORKER_ID = b.WORKER_REF_ID
				WHERE worker.WORKER_ID = ? 
				ORDER BY b.BONUS_DATE 
				LIMIT 1)""";
		try {
			return this.jdbcTemplate.update(sql, new Object[] {id}, new BonusMapper());
		}catch(DataAccessException e) {
			e.getMessage();
			return 0;
		}
	}
}
