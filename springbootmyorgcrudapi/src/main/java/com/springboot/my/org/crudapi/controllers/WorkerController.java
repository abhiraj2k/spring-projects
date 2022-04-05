package com.springboot.my.org.crudapi.controllers;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.org.crudapi.models.Bonus;
import com.springboot.my.org.crudapi.models.Title;
import com.springboot.my.org.crudapi.models.Worker;
import com.springboot.my.org.crudapi.repositories.BonusRepository;
import com.springboot.my.org.crudapi.services.BonusService;
import com.springboot.my.org.crudapi.services.TitleService;
import com.springboot.my.org.crudapi.services.WorkerService;

@RestController()
@RequestMapping("/worker")
public class WorkerController {
	
//	@Qualifier("workerMysqlRepository")
//	@Autowired
	
	@Autowired
	private WorkerService workerService;
	@Autowired
	private BonusService bonusService;
	@Autowired 
	TitleService titleService;
	
	@GetMapping("/{id}")
	public Worker showWorker(@PathVariable int id){
		return this.workerService.getWorker(id);
	}
	
	@GetMapping("/all")
	public List<Worker> showAllWorkers() {
		return this.workerService.getAllWorkers();
	}
	
	@GetMapping("/all/fullInfo")
	public List<Worker> showCompleteWorkers(){
		return this.workerService.findAllCompleteWorkers();
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
	
	@DeleteMapping("/delete")
	public Boolean deleteWorker(@PathVariable int id) {
		return this.workerService.deleteWorker(id);
	}
	
	@GetMapping("/bonus/{id}")
	public List<Bonus> getWorkerBonus(@PathVariable int id) {
		return this.bonusService.getWorkerWithBonus(id);
	}
	
	@PostMapping("/{id}/bonus/new")
	public Boolean createBonus(@PathVariable int id,@RequestBody Bonus bonus) {
		return this.bonusService.createBonus(id, bonus);
	}
	@DeleteMapping("/{id}/bonus/latest")
	public Boolean deleteBonusLatest(@PathVariable int id) {
		return this.bonusService.deleteBonusLatest(id);
	}
	
	@GetMapping("/title/{id}")
	public List<Title> getWorkerTitle(@PathVariable int id){
		return this.titleService.getWorkerWithTitle(id);
	}
	
	@GetMapping("/{id}/promote/{title}")
	public Boolean createTitle(@PathVariable int id, @PathVariable String title) {
		return this.titleService.createTitle(id, title);
	}
	
	@GetMapping("/{id}/demote")
	public Boolean deleteTitleLatest(@PathVariable int id) {
		return this.titleService.deleteTitleLatest(id);
	}
}
