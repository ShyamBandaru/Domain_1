package org.jobiak.domain.baseclass;

import java.io.File;
import java.io.IOException;

import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseTest {
	
	public static String baseURL = "https://hiresurely.com/";
	public String Domain = "HireSurely";
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static Actions action;
	
	
	public static String getURL() {
		return baseURL;
	}
	
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.addArguments("--start-maximized");
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		driver = new ChromeDriver(options);
		js = (JavascriptExecutor)driver;
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	public void scrollToBottom() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File( Domain+ "./screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException 
	{
		Screenshot scr = new AShot()
				.shootingStrategy(ShootingStrategies
				.viewportPasting(3000))
				.takeScreenshot(driver);
		ImageIO.write(scr.getImage(),"PNG",new File( "./" + Domain+ "/screenshots/"+tname+".png"));
		
	}
}
