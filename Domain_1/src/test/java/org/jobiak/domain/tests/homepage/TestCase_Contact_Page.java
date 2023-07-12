package org.jobiak.domain.tests.homepage;

import org.jobiak.domain.baseclass.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase_Contact_Page extends BaseTest {
	
	@Test
	public void contactpage() throws InterruptedException  {
		
		driver.get(baseURL);
		Thread.sleep(2000);
		WebElement cont = driver.findElement(By.xpath("//a[contains(text(),'Contact')]"));
		js.executeScript("arguments[0].click()", cont);
		Thread.sleep(1000);
		WebElement sendDetailsBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click()", sendDetailsBtn);
		Thread.sleep(1000);
		driver.findElement(By.id("name")).sendKeys("Test");
		Thread.sleep(1000);
		driver.findElement(By.id("subject")).sendKeys("Test");
		Thread.sleep(1000);
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("Test");
		Thread.sleep(1000);
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("987654321o");
		Thread.sleep(1000);
		js.executeScript("arguments[0].click()", sendDetailsBtn);
		Thread.sleep(3000);
		email.clear();
		phone.clear();
		email.sendKeys("test@email.com");
		Thread.sleep(1000);
		phone.sendKeys("9876543210");
		js.executeScript("arguments[0].click()", sendDetailsBtn);
		Thread.sleep(3000);
	}
}
