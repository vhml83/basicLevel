package com.titanium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example_WebElements {

	public static void main(String[] args) {
		
		WebDriver myDriver;

		String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		String baseURL = "http://live.guru99.com/index.php/checkout/cart";
		//String actualResult = "";
		String expectedResult = "$615.00";
		
		System.setProperty("webdriver.chrome.driver", chromePath);
		myDriver = new ChromeDriver();
		
		myDriver.navigate().to(baseURL);
		
		//Maximize the browser
		myDriver.manage().window().maximize();
		
		//Click on TV link
		WebElement lnkTV = myDriver.findElement(By.linkText("TV"));
		lnkTV.click();
		
		//Click on 'ADD TO CART'
		WebElement btnAddToCart = myDriver.findElement(By.cssSelector(".button.btn-cart"));
		btnAddToCart.click();
		
		//Get price
		WebElement lblSubtotal = myDriver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[5]/span/span"));
				
		if (lblSubtotal.getText().contains(expectedResult)) {
			System.out.println("Test PASSED! The actual result " + lblSubtotal.getText() + " is equal to " + expectedResult);
		} else {
			System.err.println("Test FAILED! The actual result " + lblSubtotal.getText() +  " is not equal to " + expectedResult);
		}
		
		myDriver.close();
	}

}
