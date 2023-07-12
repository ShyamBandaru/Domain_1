package org.jobiak.domain.tests.homepage;

import org.jobiak.domain.baseclass.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase_Terms_Page extends BaseTest{
	
	@Test
	public void tp_tc() throws InterruptedException {
		driver.get(baseURL);
		WebElement tc = driver.findElement(By.xpath("//a[contains(text(),'Terms')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", tc);
		Thread.sleep(500);
		js.executeScript("arguments[0].click()", tc);
		Thread.sleep(500);
		Actions action3 = new Actions(driver);
		for(int j=0; j<75; j++) {
			action3.keyDown(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(100);
		}
		driver.findElement(By.xpath("//button[@onclick='scrollToTop()']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h2//parent::a")).click();
		Thread.sleep(2000);
	}
}
