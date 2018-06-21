package com.itexico.user.manager.client;

import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.itexico.user.manager.entity.User;

public class RestClientUtil {
	
	 public void getUserByIdDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8088/users/{id}";
	    HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	    ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, User.class, 1);
	    User user = responseEntity.getBody();
	    System.out.println("Id:"+user.getId()+", User:"+user.getUser()
        +", Password: "+user.getPassword());
		 
   }
	    public void getAllUserDemo() {
	   HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8088/users";
	    HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	    ResponseEntity<User[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, User[].class);
	    User[] users = responseEntity.getBody();
	    for(User user : users) {
	    	System.out.println("Id:"+user.getId()+", User:"+user.getUser()
	        +", Password: "+user.getPassword());
	    }
    }
	    
	public void addUserDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8088/users";
		User user = new User();
		//user.setId(1);
		user.setUser("karina");
		user.setPassword("password");
		user.setCurp("FRDETGTFR");	
        HttpEntity<User> requestEntity = new HttpEntity<User>(user, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());
           
    }
	
    public void updateUserDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/users";
		User user = new User();
		user.setId(1);
		user.setUser("karina");
		user.setPassword("password");
		user.setCurp("FRDETGTFR");
        HttpEntity<User> requestEntity = new HttpEntity<User>(user, headers);
        //restTemplate.put(url, requestEntity);
        URI location = restTemplate.postForLocation(url, requestEntity);
    } 
    
    public void deleteUserDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8088/users/{id}";
        HttpEntity<User> requestEntity = new HttpEntity<User>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 1);      
    } 
    
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
    	util.getAllUserDemo();
    	util.getUserByIdDemo();
    	util.addUserDemo();
    	util.updateUserDemo();
    	util.deleteUserDemo();	
  
    }   

}
