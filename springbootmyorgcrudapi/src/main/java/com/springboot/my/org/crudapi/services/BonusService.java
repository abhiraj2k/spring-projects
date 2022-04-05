package com.springboot.my.org.crudapi.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.my.org.crudapi.models.Bonus;
import com.springboot.my.org.crudapi.repositories.BonusRepository;

@Service
public class BonusService {
	@Resource(name="bonusMysqlRepository")
	BonusRepository bonusRepository;
	
	public List<Bonus> getWorkerWithBonus(Integer id){
		return this.bonusRepository.getWorkerWithBonus(id);
	}
	
	public List<Bonus> getWorkerBonusByDept(String dept){
		return this.bonusRepository.getWorkerBonusByDept(dept);
	}
	
	public Boolean createBonus(Integer id, Bonus bonus) {
		int row = this.bonusRepository.createBonus(id, bonus);
		if(row == 1) {
			return true;
		}
		return false;
	}
	
	public Boolean deleteBonusLatest(Integer id) {
		int row = this.bonusRepository.deleteBonusLatest(id);
		if(row == 1) {
			return true;
		}
		return false;
	}
}
