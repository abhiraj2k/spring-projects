package com.springboot.my.org.crudapi.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.springboot.my.org.crudapi.models.Bonus;
import com.springboot.my.org.crudapi.models.Title;
import com.springboot.my.org.crudapi.models.Worker;
import com.springboot.my.org.crudapi.utils.DateTimeUtils;

public class WorkerBonusTitleMapper implements ResultSetExtractor<List<Worker>> {

	@Override
	public List<Worker> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Worker> workerList = new ArrayList<Worker>();
		Map<Integer, Worker> workerMap = new HashMap<>();
		Map<Date, Title> titleMap = new HashMap<>();

		while(rs.next()) {
			int workerRefId = rs.getInt("WORKER_ID");
			Worker worker = workerMap.get(workerRefId);
			if(worker == null) {
				worker = new Worker(rs.getInt("WORKER_ID"),rs.getString("FIRST_NAME"),rs.getString("LAST_NAME"),rs.getString("SALARY"),DateTimeUtils.getUtilDate((LocalDateTime)rs.getObject("JOINING_DATE")) ,rs.getString("DEPARTMENT"),rs.getString("EMAIL"), new ArrayList<>(), new ArrayList<>());;
				workerMap.put(workerRefId, worker);
				workerList.add(worker);
			}
			worker = workerMap.get(workerRefId);;
			Bonus bonus = new Bonus(rs.getInt("WORKER_REF_ID"), rs.getInt("BONUS_AMOUNT"), DateTimeUtils.getUtilDate((LocalDateTime)rs.getObject("BONUS_DATE")) );;
			
			Title title = titleMap.get(DateTimeUtils.getUtilDate((LocalDateTime)rs.getObject("AFFECTED_FROM")));
			
			if(title  == null) {
				title = new Title(rs.getInt("WORKER_REF_ID"), rs.getString("WORKER_TITLE"), DateTimeUtils.getUtilDate((LocalDateTime)rs.getObject("AFFECTED_FROM")) );
				titleMap.put(DateTimeUtils.getUtilDate((LocalDateTime)rs.getObject("AFFECTED_FROM")), title);
				worker.getTitle().add(title);
			}

			worker.getBonus().add(bonus);
		}
		return workerList;
	}

}
