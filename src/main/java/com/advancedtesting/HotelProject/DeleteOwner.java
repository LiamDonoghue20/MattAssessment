package com.advancedtesting.HotelProject;

import org.junit.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import static io.restassured.module.jsv.JsonSchemaValidator.*;
public class DeleteOwner {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	
	@Given("the delete user function")
	public void getOwner() {
		request = given().contentType(ContentType.JSON);
		response = request.when().delete("http://localhost:9966/petclinic/api/owners");

	}
	@When("I enter an owners last name")
	public void enterLastName() {
		JSONObject requestParams = new JSONObject();
		requestParams.put("lastName", "Rodriquez");
	}
	
	@Then("the status code 200 should be returned")
	public void responseCode() {
		System.out.println("response: "+response.prettyPrint());
		int statusCode = response.getStatusCode();
		if (statusCode == 200) {
			System.out.println("Owner retrieved correctly");
		} else {
			System.out.println("Unable to retrieve owner");
		}
		
	}
	
	

}
