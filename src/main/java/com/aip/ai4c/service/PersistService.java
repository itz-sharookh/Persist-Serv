package com.aip.ai4c.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aip.ai4c.entity.Activity;
import com.aip.ai4c.entity.Customer;
import com.aip.ai4c.entity.Person;
import com.aip.ai4c.repo.ActivityRepository;
import com.aip.ai4c.repo.CustomerRepository;
import com.aip.ai4c.repo.PersonRepository;

@Service
public class PersistService {
	
	
	@Autowired
	ActivityRepository activityRepo;
	
	
	@Autowired
	PersonRepository personRepo;
	
	@Autowired
	CustomerRepository custRepo;
	
	@Transactional
	public Activity saveActivity(Activity activity, String transactionId) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		activity.setTransientId(transactionId);
		activity.setTimeStamp(dateFormat.format(date));
		Activity tempActivity = activityRepo.save(activity);
		
		return tempActivity;
	}
	
	
	@Transactional
	public Person savePerson(Person person) {
		
		Person tempPerson;
		
			int randomNumber = (int)(Math.random()*1000000);  			
			person.setPersistentId("SCN"+String.valueOf(randomNumber));
			tempPerson = personRepo.save(person);
		
		
		return tempPerson;
	}
	
	@Transactional
	public Optional<Person> findByEmailId(String uuIdemailId){

		Optional<Person> findPerson = personRepo.findById(uuIdemailId);
		return findPerson;
	}


	public Customer saveCustomer(Customer customer) {
		Customer cust = custRepo.save(customer);
		return cust;
	}
	
}
