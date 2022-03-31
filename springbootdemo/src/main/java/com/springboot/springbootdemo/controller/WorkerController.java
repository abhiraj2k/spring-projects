package com.springboot.springbootdemo.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootdemo.dao.WorkerDAO;
import com.springboot.springbootdemo.model.Worker;
import com.springboot.springbootdemo.repository.WorkerRepository;

@RestController()
@RequestMapping("/worker")
public class WorkerController {
//	@Qualifier("workerMysqlRepository")
//	@Autowired
	@Resource(name="workerMysqlRepository")
	WorkerDAO workerRepository;
	
	@GetMapping("/showWorker")
	public Worker showWorker(){
		try {
			return workerRepository.getWorker(1);
		}catch(SQLException e) {
			e.printStackTrace();
			return new Worker();
		}
	}
	
	@GetMapping("/all/showWorkers")
	public List<Worker> showWorkers() {
		try {
			
		List<Worker> workerList = workerRepository.getWorkers();
		return workerList;
		}catch(SQLException e) {
			e.printStackTrace();
			return List.of(new Worker());
		}
	}
	
	@PostMapping("/create")
	public String createWorker()  {
		try {
			workerRepository.add(new Worker(101, "Jack","Reacher","25000", "Marine", "jreacher@gmail.com"));
			return "Successfully Added";
		}catch(SQLException e) {
			e.printStackTrace();
			return "Something went wrong";
		}
	}
	
	@PostMapping("/update")
	public String updateWorker() {
		try {
			workerRepository.update(new Worker(101, "Jack","Reacher","25000", "Marine", "mfs.akash@gmail.com"));
			return "Updated Successfully";
		}catch(SQLException e) {
			e.printStackTrace();
			return "Something went wrong";
		}
	}
	
	@PostMapping("/delete")
	public String deleteWorker() {
		try {
			workerRepository.delete(101);
			return "Deleted Successfully";
		}catch(SQLException e) {
			e.printStackTrace();
			return "Something went wrong";
		}
	}
}
