package com.utils;
		import java.io.FileNotFoundException;
		import java.io.FileReader;
		import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonParser;

import bsh.ParseException;
			public class Readjsonexample{
		    public static void main(String[] args) 
		    {
		        //JSON parser object to parse read file
		        JsonParser jsonParser = new JsonParser();
		         
		        try (FileReader reader = new FileReader("src/main/resources/{}ExpectedHelptopic.json"))
		        {
		            Object obj = jsonParser.parse(reader);
		 
		            JSONArray employeeList = (JSONArray) obj;
		            System.out.println(employeeList);
		             
		            //Iterate over employee array
		            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
		 
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		 
		    private static void parseEmployeeObject(JSONObject employee) 
		    {
		        //Get employee object within list
		        JSONObject employeeObject = (JSONObject) employee.get("employee");
		         
		        //Get employee first name
		        String firstName = (String) employeeObject.get("firstName");    
		        System.out.println(firstName);
		         
		        //Get employee last name
		        String lastName = (String) employeeObject.get("lastName");  
		        System.out.println(lastName);
		         
		        //Get employee website name
		        String website = (String) employeeObject.get("website");    
		        System.out.println(website);
		    }
		}

	


