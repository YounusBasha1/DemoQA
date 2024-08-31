package Alerts_Frames_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Nested_Frames {
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
		System.out.println("Nested Frames is Completed");
		driver.quit();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Nested Frames']")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("frame1");// enter parent frame

		System.out.println("Parent =" + driver.findElement(By.xpath("//body[text()='Parent frame']")).getText());

		WebElement childElement = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(childElement);// entering into child frame
		System.out.println("Child=" + driver.findElement(By.xpath("//p[text()='Child Iframe']")).getText());
		driver.switchTo().defaultContent();
	}
}
