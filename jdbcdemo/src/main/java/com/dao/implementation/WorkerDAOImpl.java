package com.dao.implementation;


import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import com.dao.WorkerDAO;
import com.mapper.WorkerMapper;
import com.model.Worker;


public class WorkerDAOImpl implements WorkerDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}


    @Override
    public void add(Worker worker) throws SQLException {
        String sql = """
                INSERT INTO worker
                (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT, EMAIL)
                VALUES (?,?,?,?,?,?,?)""";
        try  {
        	this.jdbcTemplateObject.update(sql,worker.getWorkerId(),worker.getFirstName(), worker.getLastName(), worker.getSalary(), worker.getJoiningDate(), worker.getDepartment(), worker.getEmail());

            return;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(int workerId) throws SQLException {
        String sql = """
                DELETE FROM worker
                WHERE
                WORKER_ID = ? """;
        try  {
        	this.jdbcTemplateObject.update(sql,workerId);

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Worker getWorker(int workerId) throws SQLException {
        String sql = "SELECT * FROM worker WHERE WORKER_ID = ?";
        try {
            return this.jdbcTemplateObject.queryForObject(sql, new Object[] {workerId}, new WorkerMapper());

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Worker> getWorkers() throws SQLException {
        String sql = "SELECT * FROM worker";
        try {
        		return this.jdbcTemplateObject.query(sql, new WorkerMapper());
        		
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void update(Worker emp) throws SQLException {
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
            this.jdbcTemplateObject.update(sql, emp.getFirstName(), emp.getLastName(), emp.getSalary(), new Date(), emp.getDepartment(), emp.getEmail(), emp.getWorkerId());

        } catch (Exception e) {
            throw e;
        }
    }



}

