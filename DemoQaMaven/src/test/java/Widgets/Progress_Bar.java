package Widgets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Progress_Bar {
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
		System.out.println("Progress Bar is Completed");
		driver.close();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[text()='Widgets']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Progress Bar']")).click();
		Thread.sleep(1000);
		WebElement startStop = driver.findElement(By.id("startStopButton"));
		startStop.click();
		WebElement progressBar = driver.findElement(By.xpath("//div[@role='progressbar']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		Thread.sleep(1000);
		boolean progressStatus = wait.until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", "100"));

		if (progressStatus == true) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resetButton"))).click();
		} else {
			System.out.println("Progress did not reach 100%");
		}

	}
}
