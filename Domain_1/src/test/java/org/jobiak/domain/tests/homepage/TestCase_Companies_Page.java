package org.jobiak.domain.tests.homepage;

import java.util.List;

import org.jobiak.domain.baseclass.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase_Companies_Page extends BaseTest {
	
	@Test
	public void hmp_companies_selection() throws InterruptedException {
		driver.get(baseURL);
		WebElement com_all = driver.findElement(By.xpath("//*[contains(text(),'Compan')]//following::a[contains(text(),'ALL') or contains(text(),'All') or contains(text(),'More')]"));
		js.executeScript("arguments[0].click()", com_all);
		Thread.sleep(1000);
		List<WebElement> list_companies = driver.findElements(By.xpath("//h5//parent::a"));
		String window1 = driver.getWindowHandle();
		for (WebElement l1 : list_companies) {
			action.moveToElement(l1);
			Thread.sleep(500);
			String link = l1.getAttribute("href");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(link);
			String window2 = driver.getWindowHandle();
			Thread.sleep(1000);
			List<WebElement> list_locations = driver.findElements(By.xpath("//a[contains(text(),'Apply')]"));
			for (WebElement l2 : list_locations) {
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView(true);",l2);
				js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", l2);
				Thread.sleep(1000);
				String link2 = l2.getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(link2);
				for(int i=0;i<150;i++) {
					Actions action3 = new Actions(driver);
					action3.sendKeys(Keys.ARROW_DOWN).build().perform();
					Thread.sleep(50);
				}
				driver.close();
				driver.switchTo().window(window2);
			}
			Thread.sleep(1500);
			driver.close();
			driver.switchTo().window(window1);
		}
		
	}

}
