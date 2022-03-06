package com.aip.ai4c.controller;


import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.aip.ai4c.entity.Activity;
import com.aip.ai4c.entity.Customer;
import com.aip.ai4c.entity.Person;
import com.aip.ai4c.exception.PersonExisitingException;
import com.aip.ai4c.service.PersistService;
import com.aip.ai4c.util.JsonParseUtility;

@RestController
public class PersistController {
		
		@Autowired
		PersistService service;
	
		@Autowired
		JsonParseUtility util;
	
		@PostMapping("/person")
		public ResponseEntity<String> savePerson(@RequestBody Person person) throws PersonExisitingException {
			
			String tempPerson = person.getUuIdEmail();
			Optional<Person> findPerson = service.findByEmailId(tempPerson);
			
			if(findPerson.isPresent()) {
				throw new PersonExisitingException("Person already Existing!!");
			}
			else {
					service.savePerson(person);
					return ResponseEntity.status(HttpStatus.OK)
							.body("Person details saved!!");
				
			}
			
				
		}
	
		
		@PostMapping("/activity")
		public ResponseEntity<String> saveActivity(@RequestBody Activity activity, @RequestHeader(name = "transaction-id") String transactionId){

				
					Activity saveActivity = service.saveActivity(activity,transactionId);
					
					if(saveActivity!=null) {
						return ResponseEntity.status(HttpStatus.OK)
								.body("Activity details saved!!");
					
					}
					else {
						return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								.body("Failed to Save Activity Details");
					
					}
					
		}
	
		
		@PostMapping("/save")
		public ResponseEntity<String> savePersonAndActivity(@RequestBody String object, @RequestHeader(name = "transaction-id") String transactionId){
			
					Person savePerson =null,tempPerson=null;
					String personExist = "";
					String tempuuIdEmail="";
					Activity tempActivity =null,saveActivity=null;
					int presentFlag =0;
					Map personData  = util.jsonParser(object,"personalData");  
					Map activityData =util.jsonParser(object,"activityData");
					
					
				if(personData!=null) {
								tempPerson = util.createPerson(personData);
								
								tempuuIdEmail = tempPerson.getUuIdEmail();
								Optional<Person>findPerson = service.findByEmailId(tempuuIdEmail);
								
										if(findPerson.isPresent()) {
											presentFlag =1;
											
											try {
												throw new PersonExisitingException("Person with the "+tempuuIdEmail+ " Already Exists!!");
											}
											catch(PersonExisitingException pe) {
												personExist = pe.getMessage();
											}
											
										}
										else {
												savePerson = service.savePerson(tempPerson);
										}
						}
					
				
				if(activityData !=null) {
						tempActivity = util.createActivity(activityData);
						saveActivity = service.saveActivity(tempActivity, transactionId);
				}
				

				if(saveActivity!=null && savePerson!=null) {
					return ResponseEntity.status(HttpStatus.OK)
							.body("Records were saved!!");
				}
				else if(savePerson == null && saveActivity!=null) {
					return ResponseEntity.status(HttpStatus.OK)
							.body("Activity Records were saved!! \n"+personExist);
			
				}
				else if(savePerson != null && saveActivity == null){
					return ResponseEntity.status(HttpStatus.OK)
							.body("Person Records were saved!!");
			
				}
				else if(savePerson == null && saveActivity ==null) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body("Please provide the Payload!!");
			
				}
				
					
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Please provide the Payload!!");
			
			
		}
		
		
		@PostMapping("/customer")
		public Customer saveCustomer(@RequestBody Customer customer) {
			
			Customer cust = service.saveCustomer(customer);
			return cust;
		}
		
}
