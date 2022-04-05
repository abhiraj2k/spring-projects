package com.springboot.my.org.crudapi.services;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.my.org.crudapi.models.Title;
import com.springboot.my.org.crudapi.repositories.TitleRepository;
@Service
public class TitleService {
	@Resource(name="titleMysqlRepository")
	TitleRepository titleRepository;
	
	public List<Title> getWorkerWithTitle(Integer id) {
		return this.titleRepository.getWorkerWithTitle(id);
	};
	
	public List<Title> getAllWorkersWithTitleInDept(String dept) {
		return this.titleRepository.getAllWorkersWithTitleInDept(dept);
	};
	
	public boolean createTitle(Integer id, String title) {
		int row =  this.titleRepository.createTitle(id, title);
		if(row == 1) {
			return true;
		}
		return false;
	};

	public boolean deleteTitleLatest(Integer id) {
		int row=  this.titleRepository.deleteTitleLatest(id);
		if(row == 1) {
			return true;
		}
		return false;
	};
}
