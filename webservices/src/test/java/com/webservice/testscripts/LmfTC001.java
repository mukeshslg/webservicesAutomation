package com.webservice.testscripts;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import com.webservice.javaPojo.GetUsers;
import com.webservice.javaPojo.SampleData;
import com.webservice.methods.LMFWebServices;
import com.webservice.utils.LMFEndPointURL;
import com.webservice.utils.LMFURL;

import groovy.json.JsonBuilder;

public class LmfTC001 {
	
ArrayList<Integer> id=new ArrayList<Integer>();;
ArrayList<String> titleAl=new ArrayList<String>();;

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
	  //below 3 line code to create JSONObject
	  JSONObject jsonObject=new JSONObject(response.getBody().asString());
	   Object temp=jsonObject.get("Temperature");
	   System.out.println(temp);
	  System.out.println(response.asString());
  }
  @Test
  public void verifyWeatherByCityOther() {
	  String url=LMFURL.UTILITIESFiXURL+LMFEndPointURL.CITY_WEATHER.getResourcePath("Bangalore");
	  Response response= LMFWebServices.get(url);
	  System.out.println(response.getStatusCode());
	  System.out.println(response.asString());
	  
  }
  @Test(priority=1)
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
			Assert.assertEquals(SampleData.titles[i], title);
			
			id.add(getUsers[i].getId());//insert id
			titleAl.add(getUsers[i].getTitle());//insert title value
			
			//System.out.println(getUsers[i].toString());
		}
	  	}else {
	  		Assert.assertTrue(false);
	  	}
	  
	  
  }
  
  @Test(dataProvider="getUserByIDDP")
  public void getUserDetailById(Integer id,String title) {
	  Gson gson=new GsonBuilder().create();
	  String url=LMFURL.UTILITIESFiXURL2+LMFEndPointURL.USER_ID.getResourcePath(String.valueOf(id));
	  Response response=LMFWebServices.get(url);
	  if (response.getStatusCode()==200) {
		  GetUsers getUsers= gson.fromJson(response.getBody().asString(), GetUsers.class);
		  Assert.assertEquals(title, getUsers.getTitle());
	}else {
		Assert.assertTrue(false);
	}
	 
	  
  }
  
  @DataProvider
  public  Object[][] getUserByIDDP() {
	  Object[][] res=new Object[id.size()][2];
	  for (int i = 0; i < res.length; i++) {
		res[i][0]=id.get(i);
		res[i][1]=titleAl.get(i);
	}
	return res;
	  
	  
  }
  
  
  
  
  
  
  
  @BeforeMethod
  public void beforeMethod(Method m) {
	  
	 System.out.println("*********TC Name:"+""+m.getName()+" *******Starts##");

  }

  @AfterMethod
  public void afterMethod(Method m) {
	  System.out.println("*********TC Name:"+""+m.getName()+" ##ENDS## *******");
  }

}
