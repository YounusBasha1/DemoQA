package Elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Wait_Until {
	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
	}

	@AfterTest
	public void CloseBrowser() {
		System.out.println("Wait until is Completed");
		driver.close();
	}

	@Test
	public void Testing() throws Exception {

		driver.findElement(By.xpath("//h5[contains(text(),'Elements')]")).click();
		System.out.println("clicked Elemets");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Dynamic Properties']")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.id("enableAfter")).getText().equals("Will enable 5 seconds")) {
			System.out.println("Will enable 5 seconds");
		}
		if (driver.findElement(By.id("colorChange")).getText().equals("Color Change")) {
			System.out.println("Color Change");
		} else {
			System.out.println("not display");
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));

		if (driver.findElement(By.id("visibleAfter")).getText().equals("Visible After 5 Seconds")) {
			System.out.println("Visible After 5 Seconds");
		} else {
			System.out.println("not visible = Visible After 5 Seconds");
		}

	}
}
