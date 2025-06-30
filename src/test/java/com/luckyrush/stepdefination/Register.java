package com.luckyrush.stepdefination;

import java.io.FileWriter;

import org.openqa.selenium.By;

import com.luckyrush.Helperclass;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Register extends Helperclass{
	
	String CSVResult="D:\\Jatin\\eclipse-workspace\\Luckyrush\\src\\test\\resources\\Result\\RegisterResult.csv";
	
	@Given("User is on registeration page")
	public void user_is_on_registeration_page() throws Exception {
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).click();
	}

	@And("User is on register page")
	public void user_is_on_register_page() {
	   
	}

	@And("User enter Username")
	public void user_enter_username() throws Exception {
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("John4322");
	}

	@And("User enter Email")
	public void user_enter_email() throws Exception {
		Thread.sleep(1000);
	  driver.findElement(By.name("email")).sendKeys("John4322@yopmail.com");
	}

	@And("User enter Phone Number")
	public void user_enter_phone_number() {
	   driver.findElement(By.xpath("//input[@class=' input-focus-gradient-border']")).sendKeys("35457454");
	}

	@And("User enter Password")
	public void user_enter_password() {
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Welcome@123");
	}

	@And("User select robot checkbox")
	public void user_select_robot_checkbox() {
		 driver.findElement(By.xpath("//input[@id='auth-captcha']")).click();
	}

	@And("User select condition checkbox")
	public void user_select_condition_checkbox() throws Exception {
		
		WebElement checkbox = driver.findElement(By.xpath("(//input[@class='form-check-input'])[2]"));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", checkbox);
		//js.executeScript("arguments[0].click();", checkbox);
		Thread.sleep(1000);
		 driver.findElement(By.xpath("(//input[@class='form-check-input'])[1]")).click();
	}

	@And("User select age checkbox")
	public void user_select_age_checkbox() throws Exception {
		Thread.sleep(2000);
		 driver.findElement(By.xpath("(//input[@class='form-check-input'])[2]")).click();
	}

	@And("User clicks on Signup button")
	public void user_clicks_on_signup_button() {
		 driver.findElement(By.xpath("//span[@class='button-text']")).click();
	}

	@Then("User registration is successful")
	public void user_registration_is_successful() throws Exception {
		try (CSVWriter writer = new CSVWriter(new FileWriter(CSVResult))) {	
		Thread.sleep(4000);
		String actualresult = driver.findElement(By.xpath("//div[@class='wallet-profile-title']/h4")).getText();
		String expectedresult = "John4322";
		
		String result = null;
		if(actualresult.equals(expectedresult)) {
			result="Pass";
			System.out.println(expectedresult+" "+" is equal to "+actualresult);
			System.out.println("User registration is successful");
		} else {
			result="Fail";
			System.out.println(expectedresult+" "+" is equal to "+actualresult);
			System.out.println("User registration failed");
		}
		
		writer.writeNext(new String[] {"Result for user registration"});
		writer.writeNext(new String[] {"Expected Result", "Actual Result", "Result"});
		writer.writeNext(new String[] {expectedresult, actualresult,result });
	
	}catch (Exception e) {
	System.out.println("Exception occurred while register"+e);
	}
		
	}
}
