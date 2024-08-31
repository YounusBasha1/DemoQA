package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MoveToELements {
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
		System.out.println("MoveToElement is Completed");
		driver.close();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[text()='Widgets']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Tool Tips']")).click();
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		WebElement Hover1 = driver.findElement(By.id("toolTipButton"));

		a.moveToElement(Hover1).build().perform();

		Thread.sleep(1000);
		WebElement Hover1Text = driver.findElement(By.xpath("//div[text()='You hovered over the Button']"));
		if (Hover1Text.getText().equals("You hovered over the Button")) {
			System.out.println("Hover1Text is Displayed");

		}
		Thread.sleep(1000);
		WebElement Hover2 = driver.findElement(By.id("toolTipTextField"));

		a.moveToElement(Hover2).build().perform();

		Thread.sleep(500);
		WebElement Hover2Text = driver.findElement(By.xpath("//div[text()='You hovered over the text field']"));
		if (Hover2Text.isDisplayed()) {
			System.out.println("Hover2Text is displayed");
		}
		Thread.sleep(1000);
		WebElement Hover3 = driver.findElement(By.xpath("//a[text()='Contrary']"));

		a.moveToElement(Hover3).build().perform();

		Thread.sleep(1000);
		WebElement Hover3Text = driver.findElement(By.xpath("//*[text()='You hovered over the Contrary']"));
		if (Hover3Text.isDisplayed()) {
			System.out.println("Hover3Text is Displayed");
		}
		Thread.sleep(1000);
		WebElement Hover4 = driver.findElement(By.xpath("//*[text()='1.10.32']"));

		a.moveToElement(Hover4).build().perform();

		Thread.sleep(1000);
		WebElement Hover4Text = driver.findElement(By.xpath("//*[text()='You hovered over the 1.10.32']"));
		if (Hover4Text.isDisplayed()) {
			System.out.println("Hover4Text is Displayed");
		}
		Thread.sleep(1000);
	}
}
