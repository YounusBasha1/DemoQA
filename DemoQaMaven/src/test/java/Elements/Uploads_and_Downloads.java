package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Uploads_and_Downloads {
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
		System.out.println("Up and Downloads button is Completed");
		driver.close();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[contains(text(),'Elements')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Upload and Download']")).click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("//a[.='Download']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\HP\\Downloads\\sampleFile.jpeg");
	}
}
