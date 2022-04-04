package com.springboot.workers.crudapi.controller;



import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.dao.WorkerDAO;
import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.service.WorkerService;



@RestController()
@RequestMapping("/worker")
public class WorkerController {
	
//	@Qualifier("workerMysqlRepository")
//	@Autowired
	
	@Autowired
	private WorkerService workerService;
	@GetMapping("/{id}")
	public Worker showWorker(@PathVariable int id){
		return this.workerService.getWorker(id);
	}
	
	@GetMapping("/all")
	public List<Worker> showWorkers() {
		return this.workerService.getAllWorkers();
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean createWorker(@RequestBody Worker worker)  {
		return this.workerService.createWorker(worker);
	}
	
	@PostMapping("/update/{id}")
	public Boolean updateWorker(@RequestBody Map<String, String> params, @PathVariable int id) {
		return this.workerService.updateWorkerEmailId(params.get("email"), id);
	}
	
	@PostMapping("/delete")
	public Boolean deleteWorker(@PathVariable int id) {
		return this.workerService.deleteWorker(id);
	}
}
