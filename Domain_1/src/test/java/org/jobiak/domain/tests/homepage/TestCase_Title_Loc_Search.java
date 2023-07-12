package org.jobiak.domain.tests.homepage;

import org.jobiak.domain.baseclass.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase_Title_Loc_Search extends BaseTest {
	
	@Test
	public void searchfromHome() throws InterruptedException {
		driver.get(baseURL);
		String t1 = driver.findElement(By.xpath("//a//ancestor::h4")).getText();
		String l1 = driver.findElement(By.xpath("//a//ancestor::h4//following::p")).getText();
		driver.findElement(By.xpath("//input[contains(@placeholder,'Title')]")).sendKeys(t1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Loc')]")).sendKeys(l1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		Actions action2 = new Actions(driver);
		for(int j=0; j<200; j++) {
			action2.keyDown(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(100);
		}
		WebElement scroll_btn = driver.findElement(By.xpath("//button[@onclick='scrollToTop()']"));
		js.executeScript("arguments[0].click()", scroll_btn);
		Thread.sleep(500);
	}
}
