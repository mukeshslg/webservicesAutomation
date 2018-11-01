package com.webservice.testscripts;

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
	  String url=LMFURL.UTILITIESFiXURL+LMFEndPointURL.CITY_WEATHER.getResourcePath();
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
	  String url=LMFURL.UTILITIESFiXURL+LMFEndPointURL.CITY_WEATHER.getResourcePath();
	  Response response= LMFWebServices.get(url);
	//  System.out.println(response.getStatusCode());
  }
  
  
  
  
  
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	//  System.out.println("beforeMethod");

  }

  @AfterMethod
  public void afterMethod() {
	 // System.out.println("afterMethod");
  }

}
