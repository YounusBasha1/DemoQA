package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Slider {
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
		System.out.println("Slider is Completed");
		driver.close();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[text()='Widgets']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Slider']")).click();
		Thread.sleep(1000);
		WebElement Slider = driver.findElement(By.xpath("//input[@type='range']"));
		System.out.println("Location of Slider = " + Slider.getLocation());
		System.out.println("Size of the Slider = " + Slider.getSize());

		Actions a = new Actions(driver);
		a.dragAndDropBy(Slider, 206, 0).build().perform();
	}
}
