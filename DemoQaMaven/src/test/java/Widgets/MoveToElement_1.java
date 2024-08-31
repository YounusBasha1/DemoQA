package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MoveToElement_1 {
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
		System.out.println("MoveToElement1 is Completed");
		driver.close();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[text()='Widgets']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Menu']")).click();
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		WebElement MainItem2 = driver.findElement(By.xpath("//ul[@id='nav']/li[2]/a"));

		a.moveToElement(MainItem2).build().perform();
		System.out.println("Moved to MainItem2");

		Thread.sleep(1000);
		a.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[2]/ul/li[3]"))).build().perform();
		System.out.println("moved to Sub item List");
		Thread.sleep(1000);
		WebElement subitem1 = driver.findElement(By.xpath("//ul[@id='nav']/li[2]/ul/li[3]/ul/li[1]"));
		a.moveToElement(subitem1).build().perform();
		System.out.println("moved to sub item 1");
		Thread.sleep(2000);
		subitem1.click();
		System.out.println("Clicked Sub item 1");

	}
}
