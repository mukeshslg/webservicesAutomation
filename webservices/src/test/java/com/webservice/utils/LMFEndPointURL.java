package com.webservice.utils;

public enum LMFEndPointURL {
	
	CITY_WEATHER("/utilities/weather/city/"),
	CITY_MISC("/miscaddHere"),
	USER_ID("/todos/");
	
	
	String resourcePath;

	private LMFEndPointURL(String resourcePath) {
		this.resourcePath = resourcePath;
	}
	

	public String getResourcePath() {
		return resourcePath;
	}
	
	public String getResourcePath(String data) {
		return resourcePath+data;
	}
	

}
