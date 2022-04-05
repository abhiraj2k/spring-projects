package com.springboot.my.org.crudapi.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.my.org.crudapi.models.Worker;
import com.springboot.my.org.crudapi.repositories.WorkerRepository;



@Service
public class WorkerService {
	@Resource(name="workerMysqlRepository")
	private WorkerRepository workerRepository;
	
	public Worker getWorker(Integer id) {
		return this.workerRepository.findWorkerById(id);
	}

	public List<Worker> getAllWorkers() {
		return this.workerRepository.findAllWorkers();

	}
	
	public List<Worker> findAllCompleteWorkers(){
		return this.workerRepository.findAllCompleteWorkers();
	}
	
	public List<Worker> findAllCompleteWorkersWithDept(String dept){
		return this.workerRepository.findAllCompleteWorkersWithDept(dept);
	}
	
	public Boolean createWorker(Worker worker) {
		int row = this.workerRepository.createWorker(worker);
		if (row == 1) {
			return true;
		}
		return false;
	}

	public Boolean updateWorkerEmailId( String email, Integer id) {
		int rowsAffected = this.workerRepository.updateEmailById(email, id);
		System.out.println("rows affected " + rowsAffected);
		if (rowsAffected == 1) {
			return true;
		}
		return false;
	}

	public Boolean deleteWorker(Integer id) {
		int row = this.workerRepository.deleteWorker(id);
		if (row == 1) {
			return true;
		}
		return false;
	}
}
