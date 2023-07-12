package org.jobiak.domain.tests.searchpage;

import java.util.List;
import java.util.ArrayList;

import org.jobiak.domain.baseclass.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase_Search_Title extends BaseTest {
	
	@Test
	public void titlesearch() throws InterruptedException {
		driver.get(baseURL);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<String> tlist = titlelist();
		WebElement title = driver.findElement(By.xpath("//input[contains(@placeholder,'Title')]"));
		WebElement search = driver.findElement(By.xpath("//button[contains(text(),'SEARCH')]"));
		for (String string : tlist) {
			title.clear();
			Thread.sleep(500);
			title.sendKeys(string);
			Thread.sleep(1000);
			search.click();
			Thread.sleep(2000);
			for(int j=0; j<200; j++) {
				action.keyDown(Keys.ARROW_DOWN).build().perform();
				Thread.sleep(50);
			}
			driver.navigate().back();
			Thread.sleep(1000);
			
		}
		
		
	}
	
	public List<String> titlelist() {
		List<String> titles = new ArrayList<>();
		titles.add("Nurse");
		titles.add("Driver");
		titles.add("Accounts");
		titles.add("Amazon");
		titles.add("IT");
		titles.add("Manager");
		return titles;
		
	}

}
