package com.springboot.workers.crudapi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.crudapi.dao.WorkerDAO;
import com.springboot.workers.crudapi.mapper.WorkerMapper;
import com.springboot.workers.crudapi.model.Worker;


@Repository("workerMysqlRepository")
public class WorkerRepository implements WorkerDAO {
	Connection connection;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
    @Override
    public int createWorker(Worker worker) {
        String sql = """
                INSERT INTO worker
                (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT, EMAIL)
                VALUES (?,?,?,?,?,?,?)""";
        try  {
        	return this.jdbcTemplate.update(sql,worker.getWorkerId(),worker.getFirstName(), worker.getLastName(), worker.getSalary(), worker.getJoiningDate(), worker.getDepartment(), worker.getEmail());

        } catch (DataAccessException e) {
            e.getMessage();
            return 0;
        }
    }

    @Override
    public int deleteWorker(int workerId) {
        String sql = """
                DELETE FROM worker
                WHERE
                WORKER_ID = ? """;
        try  {
        	return this.jdbcTemplate.update(sql,workerId);

        } catch (DataAccessException e) {
            e.getMessage();
            return 0;
        }
    }

    @SuppressWarnings("deprecation")
	@Override
    public Worker findWorkerById(int workerId) {
        String sql = "SELECT * FROM worker WHERE WORKER_ID = ?";
        try {
            return this.jdbcTemplate.queryForObject(sql, new Object[] {workerId}, new WorkerMapper());

        } catch (DataAccessException e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public List<Worker> findAllWorkers() {
        String sql = "SELECT * FROM worker";
        try {
        		return this.jdbcTemplate.query(sql, new WorkerMapper());
        		
        } catch (DataAccessException e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public int updateWorker(Worker emp) {
        String sql = """
                UPDATE worker
                SET
                FIRST_NAME = ?,
                LAST_NAME = ?,
                SALARY = ?,
                JOINING_DATE = ?,
                DEPARTMENT = ?,
                EMAIL = ?
                WHERE
                WORKER_ID = ?""";

        try  {
            return this.jdbcTemplate.update(sql, emp.getFirstName(), emp.getLastName(), emp.getSalary(), new Date(), emp.getDepartment(), emp.getEmail(), emp.getWorkerId());

        } catch (DataAccessException e) {
            e.getMessage();
            return 0;
        }
    }
	@Override
	public int updateEmailById(String email, int id) {
		String format = """
				UPDATE Worker
					SET	
						email = ?
					WHERE worker_id = ?
				""";
		try {
			return jdbcTemplate.update(format, email, id);			
		}catch(DataAccessException e) {
			return 0;
		}
	}

}
