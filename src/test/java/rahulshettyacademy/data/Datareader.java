package rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Datareader {

	//this method not used ,same code is copied in basetests class and extended from test class
	public List<HashMap<String, String>> getJsondata() throws IOException
	{
		String jsoncontent= FileUtils.readFileToString(new File (System.getProperty("user.dir")+"/src/test/java/rahulshettyacademy/data/Productorder.json"),StandardCharsets.UTF_8);
	//string to hashmap using jackson databind dependncy
		
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String ,String>> data=	mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String ,String>>>(){
			
				});  
		return data;
		//{map,map1}
	
	}
}
