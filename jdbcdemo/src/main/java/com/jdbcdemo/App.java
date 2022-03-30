package com.jdbcdemo;

import java.sql.*;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.implementation.WorkerDAOImpl;
import com.model.Worker;

public class App {
    public static void main(String[] args) throws Exception {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	
        WorkerDAOImpl wDao =(WorkerDAOImpl) context.getBean("workerDAO");
        
        List<Worker> workerList = wDao.getWorkers();
        workerList.forEach(System.out::println);
        Worker worker = wDao.getWorker(1);

        System.out.println(worker);

        worker.setWorkerId(2);
        wDao.update(worker);
        System.out.println(wDao.getWorker(2));
    }
}
