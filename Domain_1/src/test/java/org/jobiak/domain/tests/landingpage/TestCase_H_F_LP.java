package org.jobiak.domain.tests.landingpage;

import java.util.List;

import org.jobiak.domain.baseclass.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestCase_H_F_LP extends BaseTest {
	
	@Test
	public void h_f_lp() throws InterruptedException {
		driver.get(BaseTest.baseURL);
		WebElement featuredlink = driver.findElement(By.xpath("//*[contains(text(),'Featured')]//following::a[contains(text(),'BROWSE')]"));
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);",featuredlink);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click()", featuredlink);
		Thread.sleep(1000);
		String window1 = driver.getWindowHandle();
		String heading1 = driver.findElement(By.tagName("h1")).getText();
		System.out.println(heading1);
		List<WebElement> companyList = driver.findElements(By.xpath("//a[contains(text(),'APPLY') or contains(text(),'Apply')]"));
		for(WebElement c1 : companyList) {
			Thread.sleep(1000);
			String navigate1 = c1.getAttribute("href");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(navigate1);
			Thread.sleep(2000);
			Actions action2 = new Actions(driver);
			for(int j=0; j<150; j++) {
				action2.keyDown(Keys.ARROW_DOWN).build().perform();
				Thread.sleep(100);
			}
			driver.close();
			driver.switchTo().window(window1);
		}
	}

}
