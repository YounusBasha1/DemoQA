package Widgets;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Auto_Complete {
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
		System.out.println("Auto Complete button is Completed");
		driver.close();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[text()='Widgets']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Auto Complete']")).click();
		Thread.sleep(1000);

		WebElement textbox = driver.findElement(By.id("autoCompleteMultipleInput"));
		textbox.sendKeys("a");
		Thread.sleep(2000);

		List<WebElement> list = driver.findElements(By.xpath(
				"//*[starts-with(@class,'auto-complete__menu-list auto-complete__menu-list--is-multi css-11unzgr')]/div"));
		System.out.println(list.size());
		for (WebElement b : list) {
			String all = b.getText();
			System.out.println(all);

			if (all.equalsIgnoreCase("Black")) {
				b.click();
				break;
			}
		}

		System.out.println("Selected Black");
		textbox.sendKeys("a");

		List<WebElement> mag = driver.findElements(By.xpath(
				"//*[starts-with(@class,'auto-complete__menu-list auto-complete__menu-list--is-multi css-11unzgr')]/div"));
		System.out.println(mag.size());

		for (WebElement m : mag) {
			String all = m.getText();
			System.out.println(all);

			if (all.equalsIgnoreCase("Magenta")) {
				m.click();
				break;
			}

		}
		System.out.println("Selected Magenta");

		WebElement textbox2 = driver.findElement(By.id("autoCompleteSingleInput"));
		textbox2.sendKeys("a");
		Thread.sleep(2000);

		List<WebElement> list2 = driver
				.findElements(By.xpath("//div[starts-with(@class,'auto-complete__menu-list css-11unzgr')]/div"));
		System.out.println(list2.size());

		for (WebElement c : list2) {
			String all = c.getText();
			System.out.println(all);

			if (all.equalsIgnoreCase("Black")) {
				c.click();
				break;
			}
		}

		System.out.println("Selected Black 2");

	}

}
