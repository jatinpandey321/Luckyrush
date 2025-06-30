package com.luckyrush.stepdefination;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.luckyrush.Helperclass;
import com.opencsv.CSVWriter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends Helperclass {



	public Login() throws Exception {
		super();
	}

	@Given("user is on the login page")
	public void user_is_on_the_login_page() throws Exception {
		  Thread.sleep(2000); 
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	}

	@When("user enters valid username and password")
	public void the_user_enters_valid_username_and_password() throws Exception {		
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).clear();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).sendKeys("John4322@yopmail.com");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).clear();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Welcome@123");		
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='auth-captcha']")).click();

			}
		

	@And("user clicks the login button")
	public void user_clicks_the_login_button() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("user should be redirected to the homepage")
	public void user_should_be_redirected_to_the_homepage() throws Exception {
		
		String filePath = "D:\\Jatin\\eclipse-workspace\\Luckyrush\\src\\test\\resources\\Result\\LoginResult.csv";
		
		try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {

		
		Thread.sleep(4000);
	String actual=	driver.findElement(By.xpath("//div[@class='wallet-profile-title']/span")).getText();
		String expected = "WELCOME BACK";
		
		
		String result = null;
		if(actual.equals(expected)) {
			result="Pass";
			System.out.println(expected+" "+" is equal to "+actual);
			System.out.println("User registration is successful");
		} else {
			result="Fail";
			System.out.println(expected+" "+" is equal to "+actual);
			System.out.println("User registration failed");
		}
		
		writer.writeNext(new String[] {"Result for user login"});
		writer.writeNext(new String[] {"Expected Result", "Actual Result", "Result"});
		writer.writeNext(new String[] {expected, actual,result });
		
		
	//	driver.findElement(By.xpath("//div[@class='app-menu ']/ul/li[2]")).click();
		
		
//			WebElement getcoinsbutton=	driver.findElement(By.xpath("//button[contains(text(),'Get coins')]"));
//	
//			 int height = getcoinsbutton.getSize().getHeight();
//		        int width = getcoinsbutton.getSize().getWidth();
//
//		        System.out.println("Button height of get coins : " + height);
//		        System.out.println("Button width of get coins : " + width);
//		        
//		        
//		       Thread.sleep(2000);
//		       
//		       WebElement redeem=	driver.findElement(By.xpath("//button[contains(text(),'Get coins')]"));
//		        
//		        int height1 = redeem.getSize().getHeight();
//		        int width1 = redeem.getSize().getWidth();
//		        
//		        
//		        String a=Integer.toString(height);
//		        String b=Integer.toString(width);
//		        
//		        System.out.println("Button height of redeem : " + height);
//		        System.out.println("Button width of redeem : " + width);
//		        String fontWeight = redeem.getCssValue("font-weight");
//		        System.out.println("Font weight: " + fontWeight);
//		        
//		        Thread.sleep(2000);
//		      WebElement gcamount=  driver.findElement(By.xpath("//p[@class='GC_Trim']"));
//		      System.out.println("GC amount " + gcamount.getText());
//		      
//		      WebElement scamount=  driver.findElement(By.xpath("(//div[@class='wallet-profile-item']/p)[2]"));
//		      System.out.println("SC amount " + scamount.getText());
//		      
//		      Point p1 = getcoinsbutton.getLocation();
//		      Point p2 = redeem.getLocation();
//		      
//		      
//		      String[] record = { "Expected Result", "Actual Result", "Status" };
//		      String[] getheightcoin = { "Button height of get coins" , a };
//		      String[] getwidthcoin = { "Button width of get coins :" , b};
//		      String[] getredeem = { "Button height of redeem", "Button width of reedem :"};
//	//	      String[] getredeem = { "Button height of redeem", "Button width of reedem :"};
//				String[] result = { a, b };
//				writer.writeNext(record);
//	//			writer.writeNext(getcoin);
//				
//				writer.writeNext(result);
//				writer.writeNext(getredeem);
		
		
		
		
		
		
		
		      
		 }catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
		      
		        
//			Thread.sleep(2000);
//			String actual = driver.findElement(By.xpath("//div[@id='loginSuccess']")).getText();
//			System.out.println(actual);
//
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//button[contains(text(),'Accept')]")).click();
//			String expected = "Login Successfully";
//
//			String status;
//			if (expected.equalsIgnoreCase(actual)) {
//				System.out.println("Test Case Pass");
//				status = "Pass";
//			} else {
//				System.err.println("Test Case Fail");
//				status = "Fail";

//			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			String targetPath = System.getProperty("user.dir") + "/target/screenshots/homePageScreenshot.png";
//			FileUtils.copyFile(screenshot, new File(targetPath));//changes

			}
	//		String[] record = { "Expected Result", "Actual Result", "Status" };
	//		String[] result = { expected, actual, status };
			
	

	@Then("a error message should be displayed for Invalid credential")
	public void a_error_message_should_be_displayed_for_invalid_credential() throws Exception {

//		String expected = "User not found";
//	//	String actual = driver.findElement(By.xpath("//span[@class='text-sm text-red-500 mt-1']")).getText();
//		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		// Wait for the toast to appear
//		WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginError")));
//
//		// Get the full toast text
//		String toastMessage = toast.getText();
//		System.out.println("Toast Message: " + toastMessage);
//
//	//	System.out.println("Error Message: " + actual.getText());
//		
//		System.out.println("Password must not contain whitespace"+expected+" "+toastMessage);
//		
//
//		 String status;
//			if (expected.equalsIgnoreCase(toastMessage)) {
//				System.out.println("Test Case Pass");
//				status = "Pass";
//			} else {
//				System.err.println("Test Case Fail");
//				status = "Fail";
//			}
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div[@class='auth-banner-container w-1/2 md:block hidden relative']/button")).click();
	}

}
