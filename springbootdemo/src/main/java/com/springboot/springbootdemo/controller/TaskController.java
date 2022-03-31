package com.springboot.springbootdemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	@GetMapping("/task")
	public String task(){
		return "Task demonstration";
	}
	@GetMapping("/task/showMyInfo")
	public Map<String,String> showMyInfo() {
		return Map.of("name","Abhishek","city","Pune","state","Maharashtra","dream_job","Software Developer");
	}
	@GetMapping("task/showMyHobbies")
	public List<String> showMyHobbies(){
		return List.of("MMA","Gaming","Riding Bike");
	}
}
