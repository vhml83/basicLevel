package com.titanium.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Ejercicio con Frames y ventanas Alert

public class Example_2 {

	static WebDriver myDriver;
	static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	static String baseURL = "http://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromePath);
		myDriver = new ChromeDriver();
		myDriver.navigate().to(baseURL);
		//Maximize the browser
		myDriver.manage().window().maximize();
		//Le damos un rango 15 seg para realizar la acción. Una vez terminados los 15 seg entra a finally.
		myDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait waitVar = new WebDriverWait(myDriver, 15);
		

		try {
			//Entramos al frame, buscamos el botón y damos click
			myDriver.switchTo().frame("iframeResult");
			
			//myDriver.findElement(By.xpath("html/body/button")).click();
			//Otra manera de hacerla por WebElement:
			WebElement btnTry = myDriver.findElement(By.xpath("html/body/button"));
			waitVar.until(ExpectedConditions.elementToBeClickable(btnTry));
			btnTry.click();
			
			//Para fines de demostración
			Thread.sleep(1000);
			
			//Esperar a que la ventana alert esté activa
			//Traer el texto de la ventana alert y enviarle un nombre. En este caso Gooby PLS 
			waitVar.until(ExpectedConditions.alertIsPresent());
			Alert alertWindow = myDriver.switchTo().alert();
			String alertText = alertWindow.getText();
			System.out.println(alertText);
			alertWindow.sendKeys("Gooby PLS");
			alertWindow.accept();
			
			//Para fines de demostración
			Thread.sleep(2000);
			
			String finalText = myDriver.findElement(By.id("demo")).getText();
			
			System.out.println(finalText.contains("Gooby PLS")?finalText:"Test Failed!");
		} catch (Exception ex) {
			if (ex instanceof NoSuchElementException) {
				System.err.println("Test failed! WebElement not found: " + ex.getMessage());
			} else if (ex instanceof NoSuchFrameException) { 
				System.err.println("Test failed! Frame was not found: " + ex.getMessage());
		    } else if (ex instanceof NoAlertPresentException) { 
		    	System.err.println("Test failed! Alert was not displayed: " + ex.getMessage());			
		    } else if (ex instanceof TimeoutException) { 
		    	System.err.println("Test failed! Time Exceeded: " + ex.getMessage());			    
		    } else {
				System.err.println(ex.getMessage());
			}
		} finally {
			myDriver.close();
		}
		
	}

}
