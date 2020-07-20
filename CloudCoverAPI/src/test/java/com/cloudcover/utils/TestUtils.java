package com.cloudcover.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TestUtils {
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> objectToMap(Object obj)
	{
		Map<String, Object> map = null;
		try {
			ObjectMapper oMapper = new ObjectMapper();
			map = oMapper.convertValue(obj, Map.class);
			
		}catch(Exception e)
		{System.out.println("An Exception encounterd in object to map conversion:"+e.getMessage());}
		return map;
	}	
	
	public static HashMap<String, String> urlParameterMap(String page, String pageSize, String site)
	{
		HashMap<String, String> map = null;
		try {			
			map = new HashMap<>(); 
			map.put("page", page);
			map.put("pageSize", pageSize);
			map.put("site", site);					
		}catch(Exception e)
		{System.out.println("An Exception encounterd in object to map conversion:"+e.getMessage());}
		return map;
	}	
	
	public static File getSchemaFile(String fileName)
	{
		File schema = new File(System.getProperty("user.dir")+"/"+fileName);
		return schema;
	}
}
