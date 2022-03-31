package com.springboot.springbootdemo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.springbootdemo.dao.WorkerDAO;
import com.springboot.springbootdemo.mapper.WorkerMapper;
import com.springboot.springbootdemo.model.Worker;
import com.springboot.springbootdemo.util.HelperMethods;

@Repository("workerMysqlRepository")
public class WorkerRepository implements WorkerDAO {
	Connection connection;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
    @Override
    public int add(Worker worker) throws SQLException {
        String sql = """
                INSERT INTO worker
                (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT, EMAIL)
                VALUES (?,?,?,?,?,?,?)""";
        try  {
        	return this.jdbcTemplate.update(sql,worker.getWorkerId(),worker.getFirstName(), worker.getLastName(), worker.getSalary(), worker.getJoiningDate(), worker.getDepartment(), worker.getEmail());

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int delete(int workerId) throws SQLException {
        String sql = """
                DELETE FROM worker
                WHERE
                WORKER_ID = ? """;
        try  {
        	return this.jdbcTemplate.update(sql,workerId);

        } catch (Exception e) {
            throw e;
        }
    }

    @SuppressWarnings("deprecation")
	@Override
    public Worker getWorker(int workerId) throws SQLException {
        String sql = "SELECT * FROM worker WHERE WORKER_ID = ?";
        try {
            return this.jdbcTemplate.queryForObject(sql, new Object[] {workerId}, new WorkerMapper());

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Worker> getWorkers() throws SQLException {
        String sql = "SELECT * FROM worker";
        try {
        		return this.jdbcTemplate.query(sql, new WorkerMapper());
        		
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int update(Worker emp) throws SQLException {
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

        } catch (Exception e) {
            throw e;
        }
    }

}
