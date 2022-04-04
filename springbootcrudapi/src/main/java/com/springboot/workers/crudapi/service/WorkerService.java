package com.springboot.workers.crudapi.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.repository.WorkerRepository;

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
