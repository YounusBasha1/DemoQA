package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testbox_Elements {
	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
	}

	@AfterTest
	public void CloseBrowser() {
	System.out.println("TextBox is Completed");
	driver.close();
	 }

	@Test
	public void Testing() throws Exception {

		driver.findElement(By.xpath("(//div[@class='header-wrapper'])[1]")).click();
		System.out.println("clicked Elemets");
		driver.findElement(By.xpath("//span[normalize-space()='Text Box']")).click();
		System.out.println("TextBox");
		driver.findElement(By.id("userName")).sendKeys("Shaik");
		driver.findElement(By.id("userEmail")).sendKeys("Demo@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Hyderbad");
		driver.findElement(By.id("permanentAddress")).sendKeys("Hyderbad 1");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(2000);
		System.out.println("clicked the submit");

		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']")).isDisplayed()) {
			System.out.println("Displayed the Text");

		} else {
			System.out.println("not Displayed Text");
		}
	}
}
