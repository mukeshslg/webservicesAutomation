package com.webservice.methods;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class LMFWebServices {
	/**
	 * 
	 * @param URI
	 * @param strJSON
	 * @return response
	 * post method
	 */
	public static Response post(String URI,String strJSON) {
		RequestSpecification requestSpecification= RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response= requestSpecification.post(URI);
		return response;
		 
	}
	/**
	 * 
	 * @param URI
	 * @return response
	 * get method
	 */
	public static Response get(String URI) {
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response=requestSpecification.get(URI);
		return response;
	}
	
	public static Response put(String URI,String strJSON) {
		RequestSpecification requestSpecification=RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response=requestSpecification.put(URI);
		return response;
		
	}
	public static Response delete(String URI,String strJSON) {
		RequestSpecification requestSpecification=RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response=requestSpecification.delete(URI);
		return response;
		
	}
}
