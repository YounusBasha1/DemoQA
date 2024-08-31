package Alerts_Frames_Windows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Brwoser_Window_NewWindowMSG {
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
		System.out.println("BrowserWindows New Window is Completed");
		driver.quit();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();
		Thread.sleep(2000);

		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.id("messageWindowButton")).click();
		Thread.sleep(1000);

		Set<String> windowids = driver.getWindowHandles();

		for (String windowid : windowids) {
			driver.switchTo().window(windowid);

			if (!windowid.equals(parentwindow)) {
				System.out.println("New Window message is Opened");
				driver.close();
			}

		}
		driver.switchTo().window(parentwindow);
		System.out.println("navigate from New Window =" + driver.getTitle());

	}
}
