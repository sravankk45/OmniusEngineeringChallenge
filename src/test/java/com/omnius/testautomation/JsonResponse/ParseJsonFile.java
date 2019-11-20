package com.omnius.testautomation.JsonResponse;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import java.io.File;
import java.io.IOException;

/**
* The class is to Parse the JSON file
* @version 1.0
* @author Sravan
*/
public class ParseJsonFile {
	
	public DocumentContext parseJSON() throws IOException{
		
		 String rootPath=System.getProperty("user.dir");
		 DocumentContext jsonPath = JsonPath.parse(new File(rootPath+"\\response.JSON"));
		 return jsonPath;
		
	}
	
}
