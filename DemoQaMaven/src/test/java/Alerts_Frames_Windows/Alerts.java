package Alerts_Frames_Windows;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alerts {
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
		System.out.println("Alerts button is Completed");
		driver.close();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Alerts']")).click();
		Thread.sleep(1000);
		// 1
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		System.out.println("1st");
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		System.out.println("Alert 1 is accepted");
		Thread.sleep(1000);
		// 2
		driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
		System.out.println("2nd");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(driver.switchTo().alert().getText());
		alert2.accept();
		System.out.println("Alert 2 is accepted");
		// 3 confirm
		driver.findElement(By.id("confirmButton")).click();
		System.out.println("3rd confirm");
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		System.out.println("Click ok =" + driver.findElement(By.id("confirmResult")).getText());
		// 3 dismiss
		driver.findElement(By.id("confirmButton")).click();
		System.out.println("3rd Dismiss");
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		System.out.println("Click Cancel=" + driver.findElement(By.id("confirmResult")).getText());

		// 4th accept
		driver.findElement(By.id("promtButton")).click();
		System.out.println("4th ok");
		System.out.println(driver.switchTo().alert().getText());
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Younus");
		alert.accept();
		System.out.println("Younus =" + driver.findElement(By.id("promptResult")).getText());
		// 4th dismiss
		driver.findElement(By.id("promtButton")).click();
		System.out.println("4th cancel");
		System.out.println(driver.switchTo().alert().getText());
		alert.sendKeys("ntg");
		alert.dismiss();
	}
}
