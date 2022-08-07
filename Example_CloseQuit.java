package com.titanium.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example_CloseQuit {

	static WebDriver myDriver;
	static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	static String baseURL = "http://www.popuptest.com/popuptest2.html";
	
	//Cierra la ventana principal y deja los 'popups' abiertos
	public static void Close() {
		myDriver = new ChromeDriver();
		myDriver.navigate().to(baseURL);
		myDriver.close();
	}
	
	//Se espera 2 seg y después cierra todas las ventanas abiertas
	public static void Quit() {
		myDriver = new ChromeDriver();
		myDriver.get(baseURL);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myDriver.quit();
	}
	
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromePath);
		Close();
		Quit();

	}

}
