package Alerts_Frames_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Frames {
	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com");
		Thread.sleep(2000);
	}

	@AfterTest
	public void CloseBrowser() {
		System.out.println("Frames is Completed");
		driver.quit();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Frames']")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("frame1");
		System.out.println("1st=" + driver.findElement(By.id("sampleHeading")).getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		System.out.println("2nd=" + driver.findElement(By.id("sampleHeading")).getText());

	}
}