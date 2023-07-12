package org.jobiak.domain.tests.homepage;

import java.util.List;

import org.jobiak.domain.baseclass.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase_FeaturedJobs extends BaseTest  {
	
	//Navigations Home(selects browse all in featured jobs section and navigates to job listing page
	//opens up each and every landing page listed in the job listing page
	//completed
	@Test
	public void featuredJobs() throws InterruptedException {
		driver.get(BaseTest.baseURL);
		WebElement fjba = driver.findElement(By.xpath("//*[contains(text(),'Featured')]//following::a[contains(text(),'BROWSE')]"));
		action.moveToElement(fjba);
		Thread.sleep(2000);
		fjba.click();
		Thread.sleep(1000);
		String window1 = driver.getWindowHandle();
		Actions action2 = new Actions(driver);
		List<WebElement> links = driver.findElements(By.xpath("//a[contains(text(),'APPLY') or contains(text(),'Apply')]"));
		for (WebElement webElement : links) {
			String link1 = webElement.getAttribute("href");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(link1);
			Thread.sleep(1500);
			for(int i=0;i<150;i++) {
				action2.sendKeys(Keys.ARROW_DOWN).perform();
				Thread.sleep(50);
			}
			driver.findElement(By.xpath("//button[@onclick='scrollToTop()']")).click();
			Thread.sleep(1000);
			driver.close();
			driver.switchTo().window(window1);
			
		}
	}

}
