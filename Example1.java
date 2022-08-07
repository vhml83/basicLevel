package com.titanium.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Ejercicio para traer el título de una URL y compararlo.

public class Example1 {

	public static void main(String[] args) {
		//Ctrl+Shift+O te importa la librería que hace falta
		//Ctrl+7 comentar código
		//Instantiating WebDriver object
		WebDriver myDriver;
		
		String baseURL = "http://newtours.demoaut.com";
		String actualResult = "";
		String expectedResult = "Welcome: Mercury Tours";
		
		//"user.id" es el equivalente a poner C:\Users\Victor\workspace\BasicLevel
		//a eso hay que concatenarle la carpeta "drivers" y el nombre del driver "chromedriver.exe"
		//Set the location of the chrome.exe file to property webdriver.chrome.driver 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		
		myDriver = new ChromeDriver();
		
		myDriver.get(baseURL);
		//Getting web title
		actualResult = myDriver.getTitle();
		
//		if (actualResult.equals(expectedResult)) {
//			//sysout+CTRL+SPACE
//			System.out.println("Test passed!");
//		} else {
//			System.err.println("Test Failed!");
//		}

		System.out.println(actualResult.equals(expectedResult) ? "Test Passed! " + actualResult : "Test Failed!" );
		//Close the browser
		myDriver.close();
	}

}
