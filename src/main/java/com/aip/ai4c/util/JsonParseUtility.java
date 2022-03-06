package com.aip.ai4c.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.aip.ai4c.entity.Activity;
import com.aip.ai4c.entity.Person;

@Component
public class JsonParseUtility {
	
	/*
	 * 
	 * activityData": {

        "cmsId": "77890000-89ABCDEF-01234567-89ABCDEX",

        "cookieId": "00000000-89ABCDEF-01234567-89ABCMHH",

        "opimizelyId": "12345000-89ABCDEF-01234567-89ABCCLI",

        "deviceId": "99340000-89ABCDEF-01234567-89ABCDEF"

    },

    "personalData": {

        "PHONE": "7980406991",

        "ADDRESS": "221B Baker Street",

        "EMAIL": "customer@organization.com",

        "NAME": "Jhon Doe"

    }
	 * 
	 * 
	 */
	
	
	public Map jsonParser(String object, String value) {
		Map data=null;
		try {
			Object obj = new JSONParser().parse(object);
			JSONObject jo = (JSONObject)obj;
			data = ((Map) jo.get(value));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
				
		return data;
	}
	
	
	
	public Activity createActivity(Map value) {

		Activity act = new Activity();
		Iterator<Map.Entry> valueIterator = value.entrySet().iterator();
		
		while(valueIterator.hasNext()) {
			Map.Entry pair = valueIterator.next();
			String temp1 = (String)pair.getKey();
			
			if(temp1.toLowerCase().contains("cmsid")) {
				act.setCmsId((String)pair.getValue());
				
			}else if(temp1.toLowerCase().contains("cookieid")) {
				act.setCookieId((String)pair.getValue());
			}
			else if(temp1.toLowerCase().contains("uuidemail")) {
				act.setUuIdEmail(new Person((String)pair.getValue()));;
			}
			else if(temp1.toLowerCase().contains("optimizelyid")) {
				act.setOptimizelyId((String)pair.getValue());
			}
			else if(temp1.toLowerCase().contains("deviceid")) {
				act.setDeviceId((String)pair.getValue());
			}
			
		}
		
		return act; 
	}
	
	
	public Person createPerson(Map value){
		Person per = new Person();
		
		Iterator<Map.Entry> valueIterator = value.entrySet().iterator();
		
		while(valueIterator.hasNext()) {
			Map.Entry pair = valueIterator.next();
			String temp1 = (String)pair.getKey();
			
			if(temp1.toLowerCase().contains("phone")) {
				per.setPhoneNumber((String)pair.getValue());
				
			}else if(temp1.toLowerCase().contains("address")) {
				per.setAddress((String)pair.getValue());
			}
			else if(temp1.toLowerCase().contains("uuidemail")) {
				per.setUuIdEmail((String)pair.getValue());
			}
			else if(temp1.toLowerCase().contains("email")) {
				per.setEmailId((String)pair.getValue());
			}
			else if(temp1.toLowerCase().contains("name")) {
				per.setName((String)pair.getValue());
			}
			
		}
		
		return per;
	}
	
/*	
	public String[] personJsonParser(Object object) {
		JSONObject jo = (JSONObject)object;
		Map personalData = ((Map)jo.get("personalData"));
		String []pers = new String[personalData.size()];
		
	}
*/
	
	
	
}



