package com.cognizant.training.jdbcDemo;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cognizant.training.jdbcDemo.bean.Person;
import com.cognizant.training.jdbcDemo.dao.PersonJdbcDao;
import com.cognizant.training.jdbcDemo.dao.PersonJpaRepository;

@SpringBootApplication
public class JdbcDemoApplication implements CommandLineRunner {
	
	//@Autowired()
	//PersonJdbcDao personJdbcDao;
	
	@Autowired
	PersonJpaRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(JdbcDemoApplication.class, args);
		
		
		
		
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//logger.info("user id 10001 -> {}",personJdbcDao.findById(10001));
		
		logger.info("user id 10001 -> {}",repository.findById(10001));
		
		repository.deleteById(10002);
		
		logger.info("Inserting 10004 -> {}",repository.insert(new Person("Meera","Cuttack",new Date())));
		
		logger.info("Updating 10003 -> {}",repository.update(new Person(10003,"Ganesh","Chennai",new Date())));
		
		logger.info("All users -> {}",repository.findAll());
	}

}
