package com.aimorc.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SampleServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("welcome to DoGet of SampleServlet");

	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String jsonString = "";
		if(bufferedReader != null){
			jsonString = bufferedReader.readLine();
		}
		System.out.println("Received JSON :"+ jsonString);
		try {
			//JSON Parsing..
			Object paresedJSONObject = new JSONParser().parse(jsonString);
			JSONObject jsonObject = (JSONObject) paresedJSONObject;
			String username = (String) jsonObject.get("username");
			String password = (String) jsonObject.get("password");


			//String statusMessage = validateUser(username, password) ? "Valid Account" : "Invalid User Account";
			String statusMessage = "";

			//Data Validation from back-end
			if(validateUser(username, password))
				statusMessage = "Valid Account";
			else 
				statusMessage = "Invalid User Account";

			response.getWriter().write(statusMessage);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private boolean validateUser(String username, String password) {
		System.out.println("\nUsername :" + username + " Password: " + password);
		Account currentAccount = AccountUtility.findByUsername(username);
		return currentAccount != null && currentAccount.getPassword().equals(password);
	}

}
