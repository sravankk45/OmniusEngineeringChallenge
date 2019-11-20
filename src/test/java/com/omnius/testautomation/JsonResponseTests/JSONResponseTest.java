package com.omnius.testautomation.JsonResponseTests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.DocumentContext;
import com.omnius.testautomation.JsonResponse.ParseJsonFile;

/**
* The class has methods to handle JSON file
* @version 1.0
* @author Sravan
*/
public class JSONResponseTest {	

	
	ParseJsonFile processFile;
	DocumentContext jsonPath;
	Map<String,Integer> map;
	List<Map<String, Object>> list;	

	
	JSONResponseTest(){
		
		processFile	=new ParseJsonFile();
		
		try {
			
			//Parses the JSON file and returns JSON Path
			jsonPath=processFile.parseJSON();	
			
		}
		
		catch(IOException e) {			
			
			e.printStackTrace();
			
		}
	
}

//Returns the Map of Status with its sum value
public Map<String,Integer> GetDocumentCountbyStatus() {
	
	map=new HashMap<String,Integer>();
	int length= jsonPath.read("$.payload.items.length()");
	 
	for(int i=0;i<length;i++) {
		
		String status=jsonPath.read("$.payload.items["+i+"].status");
		map.merge(status, 1, Integer::sum);
		
	}
	
	return map;
}

//Returns the List of map which has all details based on given status
public List<Map<String, Object>> GetDocumentDetailsbyStatus(String status) {	
	
	 list=jsonPath.read("$.payload.items[?(@.status=='" + status + "')]");
	 
	 return list;
	
}

//Returns the List of map which has all details based on given file name
public List<Map<String, Object>> GetDocumentDetailsbyFileName(String fileName) {	
	
	list=jsonPath.read("$.payload.items[?(@.file_name=='" + fileName + "')]");
	
	return list;
	
}



}


