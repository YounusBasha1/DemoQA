package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBox_Elements {
	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
	}

	@AfterTest
	public void CloseBrowser() {
		System.out.println("CheckBox is Completed");
		driver.close();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//span[contains(text(), 'Check Box')]")).click();
		WebElement Checkbox = driver.findElement(By.xpath("//span[@class='rct-checkbox']"));
		Thread.sleep(2000);
		Checkbox.click();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//span[text()='You have selected :']")).isDisplayed()) {
			System.out.println("selected is Displayed");
		}
		if (driver.findElement(By.xpath("//span[text()='home']")).isDisplayed()) {
			System.out.println("Home is Displayed");
		}

		if (driver.findElement(By.xpath("//span[text()='desktop']")).isDisplayed()) {
			System.out.println("desktop is Displayed");
		}
		if (driver.findElement(By.xpath("//span[text()='notes']")).isDisplayed()) {
			System.out.println("notes is Displayed");
		}
		if (driver.findElement(By.xpath("//span[text()='commands']")).isDisplayed()) {
			System.out.println("commands is Displayed");
		}
		if (driver.findElement(By.xpath("//span[text()='documents']")).isDisplayed()) {
			System.out.println("documents is Displayed");
		}
		if (driver.findElement(By.xpath("//span[text()='workspace']")).isDisplayed()) {
			System.out.println("workspace is Displayed");
		}
		if (driver.findElement(By.xpath("//span[text()='react']")).isDisplayed()) {
			System.out.println("react is Displayed");
		}

		else {
			System.out.println("Not displayed");
		}
	}
}
