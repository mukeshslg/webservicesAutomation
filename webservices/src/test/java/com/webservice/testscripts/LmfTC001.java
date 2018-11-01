package com.webservice.testscripts;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import com.webservice.javaPojo.GetUsers;
import com.webservice.javaPojo.SampleData;
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
	  Gson gson=new GsonBuilder().create();
	  GetUsers getUsers[];
	  String url=LMFURL.UTILITIESFiXURL2+LMFEndPointURL.USER_ID.getResourcePath();
	  Response response= LMFWebServices.get(url);
	  int statusCode=response.getStatusCode();
	  if (statusCode==200) {
		  getUsers=gson.fromJson(response.getBody().asString(), GetUsers[].class);
		  for (int i = 0; i < getUsers.length; i++) {
			Assert.assertEquals(new Integer(i+1), getUsers[i].getId());
			String title=getUsers[i].getTitle();
			Assert.assertEquals(new Integer(i+1), getUsers[i].getId());
			
			Assert.assertEquals(SampleData.titles[i], title);
			
			//System.out.println(getUsers[i].toString());
		}
	  	}else {
	  		Assert.assertTrue(false);
	  	}
	  
	  
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
