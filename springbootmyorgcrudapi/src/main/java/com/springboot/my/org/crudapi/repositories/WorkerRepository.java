package com.springboot.my.org.crudapi.repositories;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.my.org.crudapi.dao.WorkerDAO;
import com.springboot.my.org.crudapi.mappers.WorkerBonusTitleMapper;
import com.springboot.my.org.crudapi.mappers.WorkerMapper;
import com.springboot.my.org.crudapi.models.Worker;



@Repository("workerMysqlRepository")
public class WorkerRepository implements WorkerDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
    @Override
    public int createWorker(Worker worker) {
        String sql = """
                INSERT INTO worker
                (WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT, EMAIL)
                VALUES (?,?,?,?,?,?,?) """;
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
    public List<Worker> findAllCompleteWorkers(){
    	String sql = """
    			SELECT * FROM worker
    			LEFT JOIN bonus ON
    			worker.WORKER_ID = bonus.WORKER_REF_ID 
    			LEFT JOIN title ON
    			worker.WORKER_ID = title.WORKER_REF_ID""";


    	return this.jdbcTemplate.query(sql, new WorkerBonusTitleMapper());
    }
    
    @SuppressWarnings("deprecation")
	@Override 
    public List<Worker> findAllCompleteWorkersWithDept(String dept){
    	String sql = """
    			SELECT * FROM worker
    			LEFT JOIN bonus ON
    			worker.WORKER_ID = bonus.WORKER_REF_ID
    			LEFT JOIN title ON
    			worker.WORKER_ID = title.WORKER_REF_ID
    			WHERE worker.DEPARTMENT = ? """;
    	return this.jdbcTemplate.query(sql,new Object[] {dept}, new WorkerBonusTitleMapper());
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
                WORKER_ID = ? """;
        try  {
            return this.jdbcTemplate.update(sql, emp.getFirstName(), emp.getLastName(), emp.getSalary(), emp.getJoiningDate(), emp.getDepartment(), emp.getEmail(), emp.getWorkerId());

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
					WHERE worker_id = ? """;
		try {
			return jdbcTemplate.update(format, email, id);			
		}catch(DataAccessException e) {
			return 0;
		}
	}

}
