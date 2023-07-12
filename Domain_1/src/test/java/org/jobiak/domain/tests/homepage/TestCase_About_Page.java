package org.jobiak.domain.tests.homepage;

import org.jobiak.domain.baseclass.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase_About_Page extends BaseTest  {
		
	@Test
	public void aboutpage() throws InterruptedException  {
		driver.get(baseURL);
		for(int j=0; j<50; j++) {
			action.keyDown(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(50);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@onclick='scrollToTop()']")).click();
		Thread.sleep(1000);
		WebElement about = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		action.moveToElement(about);
		Thread.sleep(1000);
		about.click();
		Thread.sleep(1000);
		Actions action2 = new Actions(driver);
		for(int j=0; j<50; j++) {
			action2.keyDown(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(100);
		}
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@onclick='scrollToTop()']")).click();
		Thread.sleep(500);
		
		WebElement home = driver.findElement(By.xpath("//a[text()='Home']"));
		home.click();
		Thread.sleep(2000);
	}

}
