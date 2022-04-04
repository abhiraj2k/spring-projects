package com.springboot.workers.crudapi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.crudapi.model.Worker;


public interface WorkerDAO {

	public int createWorker(Worker worker) throws SQLException;

	public int deleteWorker(int workerId) throws SQLException;

	public Worker findWorkerById(int workerId) throws SQLException;

	public List<Worker> findAllWorkers() throws SQLException;

	public int updateWorker(Worker emp) throws SQLException;
	
	public int updateEmailById(String email, int id) throws SQLException;
}