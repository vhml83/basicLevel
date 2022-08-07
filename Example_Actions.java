package com.titanium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Example_Actions {

	static WebDriver myDriver;
	static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	static String baseURL = "http://www.facebook.com";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromePath);
		myDriver = new ChromeDriver();
		myDriver.navigate().to(baseURL);
		//Maximize the browser
		myDriver.manage().window().maximize();

		try {
			WebElement txtUserName = myDriver.findElement(By.id("email"));
		
			Actions builder = new Actions(myDriver);
			
			Action seriesOfActions = builder
					.moveToElement(txtUserName)
					.click()
					.keyDown(Keys.SHIFT)
					.sendKeys("dolan@goobypls.com")
					.keyUp(Keys.SHIFT)
					.doubleClick()
					.contextClick(txtUserName)//click der del mouse
					.build();
			seriesOfActions.perform();
			
			Thread.sleep(2000);
			System.out.println("Test passed!");
		} catch (Exception ex) {
			if (ex instanceof NoSuchElementException) {
				System.err.println("Test Failed! WebElement not found: " + ex.getMessage());
			} else {
				System.err.println("Test Failed!: " + ex.getMessage());
			}
		} finally {
			myDriver.close();
		}
	}

}
