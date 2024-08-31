package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Radio_Button {
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
		System.out.println("Radio button is Completed");
		driver.close();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[contains(text(),'Elements')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Radio Button')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='yesRadio']")).click();
		boolean Sel = driver.findElement(By.xpath("//p[text()='You have selected ']")).isDisplayed();
		Assert.assertTrue(Sel, "Not displayed");

		WebElement Sel1 = driver.findElement(By.xpath("//p[text()='You have selected ']"));
		if (Sel1.isDisplayed()) {
			System.out.println("You have sel is displayed");

		}
		if (driver.findElement(By.xpath("//span[text()='Yes']")).isDisplayed()) {
			System.out.println("Yes is displayed");
		}

		else {
			System.out.println("not");
		}
		driver.findElement(By.xpath("//label[@for='impressiveRadio']")).click();
		if (Sel1.isDisplayed()) {
			System.out.println("You sel displayed 2nd");
		}
		if (driver.findElement(By.xpath("//span[text()='Impressive']")).isDisplayed()) {
			System.out.println("Impressive is displayed");

		} else {
			System.out.println("impress is not displayed");
		}
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//label[@for='noRadio']")).isEnabled());
	}
}
