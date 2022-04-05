package com.springboot.my.org.crudapi.dao;


import java.sql.SQLException;
import java.util.List;

import com.springboot.my.org.crudapi.models.Worker;



public interface WorkerDAO {

	public int createWorker(Worker worker) throws SQLException;

	public int deleteWorker(int workerId) throws SQLException;

	public Worker findWorkerById(int workerId) throws SQLException;

	public List<Worker> findAllWorkers() throws SQLException;

	public List<Worker> findAllCompleteWorkers() throws SQLException;
	
	public List<Worker> findAllCompleteWorkersWithDept(String dept) throws SQLException;
	
	public int updateWorker(Worker emp) throws SQLException;
	
	public int updateEmailById(String email, int id) throws SQLException;
}