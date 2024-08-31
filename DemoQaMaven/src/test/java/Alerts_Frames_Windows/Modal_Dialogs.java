package Alerts_Frames_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Modal_Dialogs {
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
		System.out.println("Modol Dialogs is Completed");
		driver.quit();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Modal Dialogs']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("showSmallModal")).click();
		String small = driver.findElement(By.className("modal-body")).getText();
		System.out.println("small="+small);
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		
		driver.findElement(By.id("showLargeModal")).click();
		String large = driver.findElement(By.tagName("p")).getText();
		System.out.println("large ="+large);
		driver.findElement(By.id("closeLargeModal")).click();

	}
}
