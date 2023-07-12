package org.jobiak.domain.tests.searchpage;

import java.util.List;

import org.jobiak.domain.baseclass.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCase_Search_JobType extends BaseTest {
	@Test
	public void search_Category() throws InterruptedException {
		driver.get(baseURL);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		WebElement catDD = driver.findElement(By.xpath("//select[contains(@name,'job')]"));
		Select catslct = new Select(catDD);
		List<WebElement> catOpt = catslct.getOptions();
		for(int i=1; i<catOpt.size();i++) {
			Thread.sleep(1000);
			catslct.selectByIndex(i);
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[contains(text(),'SEARCH')]")).click();
			Thread.sleep(1000);
			for(int j=0; j<200; j++) {
				action.keyDown(Keys.ARROW_DOWN).build().perform();
				Thread.sleep(50);
			}
			driver.findElement(By.xpath("//button[@onclick='scrollToTop()']")).click();
			Thread.sleep(500);
			driver.navigate().back();
			}

	}

}
