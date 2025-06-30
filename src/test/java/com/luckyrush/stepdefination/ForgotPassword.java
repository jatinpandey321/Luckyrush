package com.luckyrush.stepdefination;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;

import com.luckyrush.Helperclass;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPassword extends Helperclass {
	String CSVResult="D:\\Jatin\\eclipse-workspace\\Luckyrush\\src\\test\\resources\\Result\\forgotpasssword.csv";

	@Given("User is on the login page")
	public void user_is_on_the_login_page() throws Exception {
		  Thread.sleep(2000); 
			driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	}

	@When("user click on the forget password link")
	public void user_click_on_the_forget_password_link() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Forgot password?')]")).click();
	   
	}

	@And("user enter a valid registered email address")
	public void user_enter_a_valid_registered_email_address() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("john345@yopmail.com");
	}

	@And("user click on the Send Reset Link button")
	public void user_click_on_the_send_reset_link_button() throws Exception {
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("(//button[contains(text(),'Send')])[1]")).click();
	   Thread.sleep(2000);
	}
	
	@And("user enter the otp")
	public void user_enter_the_otp() throws Exception {
		String originalTab = driver.getWindowHandle();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(3000); 

		
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

		
		driver.switchTo().window(tabs.get(tabs.size() - 1));

		Thread.sleep(2000);

		
		driver.get("https://yopmail.com/?john345");

		Thread.sleep(4000);

	
		driver.switchTo().frame("ifinbox");

		
		driver.findElement(By.xpath("//div[contains(text(),'Reset') or contains(text(),'OTP')]")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame("ifmail");

		
		String emailBody = driver.findElement(By.xpath("//body")).getText();
		System.out.println("Email Body:\n" + emailBody);
		
		Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
		Matcher matcher = pattern.matcher(emailBody);
		String otp = " ";
		if (matcher.find()) {
		   otp = matcher.group();
		    System.out.println("Extracted OTP: " + otp);
		} else {
		    System.out.println("OTP not found in email body.");
		}
		
		driver.switchTo().window(originalTab);
		System.out.println("Switched back to original tab.");
		
		driver.findElement(By.xpath("//input[@inputmode='numeric']")).sendKeys(otp);
		
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		
		
	}

	@And("user enter the new password")
	public void user_enter_the_new_password() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='New password']")).sendKeys("Welcome@12345");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Confirm new password']")).sendKeys("Welcome@12345");
		
	}

	@And("user click on update password button")
	public void user_click_on_update_password_button() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'RESET PASSWORD')]")).click();
	}


	@Then("user should see a confirmation message")
	public void user_should_see_a_confirmation_message() throws Exception {
		try (CSVWriter writer = new CSVWriter(new FileWriter(CSVResult))) {	
		Thread.sleep(2000);
		String actual = driver.findElement(By.xpath("//div[contains(text(),'Successfully Changed the Password')]")).getText();
		System.out.println("Success Message: " + actual);
		String result = null;
		String expectedMessage = "Successfully Changed the Password";
		if (actual.equals(expectedMessage)) {
			result="Pass";
			System.out.println("Password reset successful.");
		} else {
			result="Fail";
			System.out.println("Password reset failed.");
		}
		writer.writeNext(new String[] {"Result for forgot passwrd success"});
		writer.writeNext(new String[] {"Expected Result", "Actual Result", "Result"});
		writer.writeNext(new String[] {expectedMessage, actual,result });
	}
	}
}
