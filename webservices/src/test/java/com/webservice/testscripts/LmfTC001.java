package com.webservice.testscripts;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import com.webservice.methods.LMFWebServices;
import com.webservice.utils.LMFEndPointURL;
import com.webservice.utils.LMFURL;

public class LmfTC001 {
  @Test
  public void verifyWeatherByCityName() {
	  String url=LMFURL.UTILITIESFiXURL+LMFEndPointURL.CITY_WEATHER.getResourcePath("Hyderabad");
	  Response response= LMFWebServices.get(url);
	  System.out.println(response.asString());
  }
  @Test
  public void verifyWeatherByCityId() {
	  String url=LMFURL.UTILITIESFiXURL+LMFEndPointURL.CITY_WEATHER.getResourcePath("Hyderabad");
	  Response response= LMFWebServices.get(url);
	  System.out.println(response.asString());
  }
  @Test
  public void verifyWeatherByCityOther() {
	  String url=LMFURL.UTILITIESFiXURL+LMFEndPointURL.CITY_WEATHER.getResourcePath("Bangalore");
	  Response response= LMFWebServices.get(url);
	  System.out.println(response.getStatusCode());
	  System.out.println(response.asString());
	  
  }
  @Test
  public void verifyUserById() {
	  String url=LMFURL.UTILITIESFiXURL2+LMFEndPointURL.USER_ID.getResourcePath("1");
	  Response response= LMFWebServices.get(url);
	  System.out.println(response.getStatusCode());
	  System.out.println(response.asString());
  }
  
  
  
  
  
  
  
  
  @BeforeMethod
  public void beforeMethod(Method m) {
	  
	 System.out.println("*********TC Name:"+""+m.getName()+" *******");

  }

  @AfterMethod
  public void afterMethod() {
	 // System.out.println("afterMethod");
  }

}
