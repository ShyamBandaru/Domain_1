package org.jobiak.domain.tests.homepage;

import org.jobiak.domain.baseclass.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase_PnP_Page extends BaseTest {
		
	@Test
	public void privacypage() throws InterruptedException  {
		driver.get(baseURL);
		WebElement pnp = driver.findElement(By.xpath("//a[contains(text(),'Privacy')]"));
		js.executeScript("arguments[0].click()", pnp);
		Thread.sleep(1500);
		Actions action2 = new Actions(driver);
		for(int j=0; j<75; j++) {
			action2.keyDown(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(100);
		}
		driver.findElement(By.xpath("//button[@onclick='scrollToTop()']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h2//parent::a")).click();
		Thread.sleep(1000);
	}

}
