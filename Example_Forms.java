package com.titanium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Ejercicio llenar un formulario y enviar datos

public class Example_Forms {

	static WebDriver myDriver;
	static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	static String baseURL = "http://newtours.demoaut.com/";
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromePath);
		myDriver = new ChromeDriver();
		myDriver.navigate().to(baseURL);
		
		//Maximize the browser
		myDriver.manage().window().maximize();
		
		try {
			myDriver.findElement(By.linkText("REGISTER")).click();
			
			WebElement txtFirstName = myDriver.findElement(By.name("firstName"));
			txtFirstName.sendKeys("Gil");
			//Para propósitos de demostración
			Thread.sleep(1500);
			txtFirstName.clear();
			//Para propósitos de demostración
			Thread.sleep(1500);
			txtFirstName.sendKeys("Gilberto");
			
			myDriver.findElement(By.name("address1")).sendKeys("Test address");
			
			Select drpCountry = new Select(myDriver.findElement(By.name("country")));
			Thread.sleep(2000);
			//Seleccionar "MEXICO" del dropdown menú
			drpCountry.selectByVisibleText("MEXICO");
			//Otra manera de hacerlo pero no es 'best practice'
			//myDriver.findElement(By.name("country")).sendKeys("MEXICO");
			
			myDriver.findElement(By.id("email")).sendKeys("gilbertoS");
			myDriver.findElement(By.name("password")).sendKeys("123");
			
			WebElement txtConfirmPass = myDriver.findElement(By.name("confirmPassword"));
			txtConfirmPass.sendKeys("123");
			txtConfirmPass.submit();
			
			//El //*[contains(text(),'Note:')] filtra todos los elementos de la página para encontrar el texto que buscamos
			//En la parte inferior del navegador debe indicar '1 matching node'
			String textSuccess = myDriver.findElement(By.xpath("//*[contains(text(),'Note:')]")).getText();
			System.out.println("Test Passed: " + textSuccess);
			
		} catch (Exception ex) {
			if (ex instanceof NoSuchElementException) {
				System.err.println("WebElement not found: " + ex.getMessage());
			} else {
				System.err.println(ex.getMessage());
			}	
		} finally {
			myDriver.close();
		}

	}

}
