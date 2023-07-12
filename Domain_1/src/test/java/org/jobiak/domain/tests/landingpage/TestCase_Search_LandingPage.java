package org.jobiak.domain.tests.landingpage;

import java.util.List;

import org.jobiak.domain.baseclass.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase_Search_LandingPage extends BaseTest {
	
	@Test
	public void searchtolanding() throws InterruptedException {
		driver.get(baseURL);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		WebElement jobtab = driver.findElement(By.xpath("//a[contains(text(),'APPLY') or contains(text(),'Apply')]"));
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(true);",jobtab);
		js.executeScript("arguments[0].click()", jobtab);
		Thread.sleep(2000);
		Actions action2 = new Actions(driver);
		for(int j=0; j<150; j++) {
			action2.keyDown(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(50);
		}
		List<WebElement> landingpage_keywords = driver.findElements(By.xpath("//h2//following::div//descendant::h2//following::h2//following::div//following::a"));
		String window1 = driver.getWindowHandle();
		for (WebElement l1 : landingpage_keywords) {
			Thread.sleep(1500);
			js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", l1);
			Thread.sleep(1000);
			js.executeScript("arguments[0].scrollIntoView(true);", l1);
			Thread.sleep(1000);
			String link = l1.getAttribute("href");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(link);
			Thread.sleep(1000);
			for(int i=0;i<250;i++) {
				action2.sendKeys(Keys.ARROW_DOWN).build().perform();
				Thread.sleep(50);
			}
			Thread.sleep(1000);
			driver.close();
			driver.switchTo().window(window1);
		}
		
		
		
		
		
	}

}
