package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Buttons {
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
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Buttons']")).click();
		Thread.sleep(1000);
		WebElement doubleclic = driver.findElement(By.id("doubleClickBtn"));
		Actions a = new Actions(driver);
		a.doubleClick(doubleclic).build().perform();
		Thread.sleep(2000);

		if (driver.findElement(By.xpath("//p[text()='You have done a double click']")).getText()
				.equals("You have done a double click")) {
			System.out.println("You have done a double click");
		} else {
			System.out.println("Not dis = You have done a double click");
		}
		WebElement right = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
		a.contextClick(right).build().perform();
		Thread.sleep(1000);
		if (driver.findElement(By.id("rightClickMessage")).getText().equals("You have done a right click")) {
			System.out.println("You have done a right click");
		} else {
			System.out.println("Not Dis = You have done a right click");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		Thread.sleep(1000);
		if (driver.findElement(By.id("dynamicClickMessage")).getText().equals("You have done a dynamic click")) {
			System.out.println("You have done a dynamic click");
		} else {
			System.out.println("Not Dis = You have done a dynamic click");
		}
	}
}
