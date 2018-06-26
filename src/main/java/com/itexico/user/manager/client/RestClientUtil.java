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
	    String url = "http://localhost:8080/test/user/{id}";
	    HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	    ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, User.class, 1);
	    User user = responseEntity.getBody();
	    System.out.println("Id:"+user.getId()+", User:"+user.getName()
        +", Password: "+user.getPassword());
		 
   }
	    public void getAllUserDemo() {
	   HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/test/users";
	    HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	    ResponseEntity<User[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, User[].class);
	    User[] users = responseEntity.getBody();
	    for(User user : users) {
	    	System.out.println("Id:"+user.getId()+", User:"+user.getName()
	        +", Password: "+user.getPassword());
	    }
    }
	    
	public void addUserDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/test/user";
		User user = new User();
		user.setName("name");
		user.setPassword("password12345");
		user.setCurp("NAMEFRTGKOHY323");
        HttpEntity<User> requestEntity = new HttpEntity<User>(user, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());
           
    }
	
    public void updateUserDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/test/user/{id}";
		User user = new User();
		user.setName("catalina");
		user.setPassword("catalina");
		user.setCurp("");
        HttpEntity<User> requestEntity = new HttpEntity<User>(user, headers);
        //restTemplate.put(url, requestEntity);
        URI location = restTemplate.postForLocation(url, requestEntity);
    } 
    
    public void deleteUserDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/test/user/{id}";
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
