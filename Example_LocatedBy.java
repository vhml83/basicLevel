package com.titanium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example_LocatedBy {

	public static void main(String[] args) {
		
		WebDriver myDriver;

		String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		String baseURL = "http://live.guru99.com/index.php/checkout/cart";
		String actualResult = "";
		String expectedResult = "$615.00";
		
		System.setProperty("webdriver.chrome.driver", chromePath);
		myDriver = new ChromeDriver();
		
		myDriver.navigate().to(baseURL);
		//Maximize the browser
		myDriver.manage().window().maximize();
		//Click on TV link
		myDriver.findElement(By.linkText("TV")).click();
		//Click on 'ADD TO CART'
		myDriver.findElement(By.cssSelector(".button.btn-cart")).click();
		//Get price
		actualResult = myDriver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[5]/span/span")).getText();
		
		if (actualResult.contains(expectedResult)) {
			System.out.println("Test PASSED! The actual result " + actualResult + " is equal to " + expectedResult);
		} else {
			System.err.println("Test FAILED! The actual result " + actualResult +  " is not equal to " + expectedResult);
		}
		
		myDriver.close();
	}

}
