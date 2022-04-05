package com.springboot.my.org.crudapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.org.crudapi.models.Bonus;
import com.springboot.my.org.crudapi.models.Title;
import com.springboot.my.org.crudapi.models.Worker;
import com.springboot.my.org.crudapi.services.BonusService;
import com.springboot.my.org.crudapi.services.TitleService;
import com.springboot.my.org.crudapi.services.WorkerService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	@Autowired
	private WorkerService workerService;
	@Autowired
	private BonusService bonusService;
	@Autowired 
	TitleService titleService;
	
	@GetMapping("/{dept}/bonuses")
	public List<Bonus> getWorkerBonusByDept(@PathVariable String dept){
		return this.bonusService.getWorkerBonusByDept(dept);
	}
	
	@GetMapping("{dept}/all")
	public List<Title> getAllWorkersWithTitleInDept(@PathVariable String dept){
		return this.titleService.getAllWorkersWithTitleInDept(dept);
	}
	
	@GetMapping("/{dept}/all/fullInfo")
	public List<Worker> showCompleteWorkersWithDept(@PathVariable String dept){
		return this.workerService.findAllCompleteWorkersWithDept(dept);
	}
	
}
