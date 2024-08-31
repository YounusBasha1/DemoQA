package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Date_Picker_DateAndTime {
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
		System.out.println("Date_And_Time is Completed");
		driver.close();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[text()='Widgets']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Date Picker']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("dateAndTimePickerInput")).click();
		String month = "July 2025";
		String day = "20";
		Thread.sleep(1000);
		while (true) {
			String text = driver
					.findElement(By.xpath("//*[@id='dateAndTimePicker']/div[2]/div/div/div/div[2]/div[1]/div[1]"))
					.getText();
			if (text.equals(month)) {
				Thread.sleep(1000);
				break;

			} else {
				driver.findElement(By.xpath("//*[@id=\"dateAndTimePicker\"]/div[2]/div[2]/div/div/button[2]")).click();

			}

		}
		driver.findElement(By.xpath("//div[@class='react-datepicker__month']//div[text()=" + day + "]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@class='react-datepicker__time-list']//li[contains(text(),'23:15')]"))
				.click();

	}
}
