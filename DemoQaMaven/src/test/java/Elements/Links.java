package Elements;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Links {
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
		System.out.println("Links is Completed");
		driver.close();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[contains(text(),'Elements')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Links']")).click();
		Thread.sleep(1000);
		String ParentWindow = driver.getWindowHandle();

		WebElement Home = driver.findElement(By.id("simpleLink"));
		WebElement Home2 = driver.findElement(By.id("dynamicLink"));

		Home.click();
		Thread.sleep(2000);

		Set<String> windowids = driver.getWindowHandles();

		for (String windowid : windowids) {
			driver.switchTo().window(windowid);

			if (!windowid.equals(ParentWindow)) {

				System.out.println("new tab is open");
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());

				driver.close();
			}
		}
		driver.switchTo().window(ParentWindow);
		System.out.println("ParentWindow = " + driver.getTitle());
		Thread.sleep(2000);
		Home2.click();

		Set<String> windowids1 = driver.getWindowHandles();

		for (String window : windowids1) {

			driver.switchTo().window(window);
			if (!window.equals(ParentWindow)) {
				System.out.println("New tab is Open");
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				driver.close();

			}

		}
		driver.switchTo().window(ParentWindow);
		System.out.println("again Parent Window = " + driver.getTitle());

		WebElement Created = driver.findElement(By.id("created"));
		Created.click();
		

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse"))).getText());
		;

	}
}
