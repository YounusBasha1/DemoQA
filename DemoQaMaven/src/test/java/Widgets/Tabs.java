package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tabs {
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
		System.out.println("Tabs is Completed");
		driver.close();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[text()='Widgets']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Tabs']")).click();
		Thread.sleep(1000);
		WebElement What = driver.findElement(By.id("demo-tab-what"));
		WebElement Orgin = driver.findElement(By.id("demo-tab-origin"));
		WebElement Use = driver.findElement(By.id("demo-tab-use"));
		WebElement More = driver.findElement(By.id("demo-tab-more"));

		WebElement WhatText = driver.findElement(By.xpath("//div[@id=\"demo-tabpane-what\"]/p"));
		WebElement OrginText1 = driver.findElement(By.xpath("(//div[@id='demo-tabpane-origin']/p)[1]"));
		WebElement OrginText2 = driver.findElement(By.xpath("(//div[@id='demo-tabpane-origin']/p)[2]"));
		WebElement UseText = driver.findElement(By.xpath("//div[@id='demo-tabpane-use']/p"));

		if (WhatText.isDisplayed()) {
			System.out.println("WhatText is Displayed");
			Thread.sleep(1000);
			if (What.isDisplayed()) {
				System.out.println("What is Displayed");
			}

		} else {
			System.out.println("Error Occur at What");
		}
		Thread.sleep(2000);
		Orgin.click();
		System.out.println("Orgin is clicked");
		if (OrginText1.isDisplayed()) {
			System.out.println("Orgin Text 1 is Displayed");
		}
		Thread.sleep(1000);
		if (OrginText2.isDisplayed()) {
			System.out.println("Orgin text 2 is displayed");

		}
		Thread.sleep(2000);
		Use.click();
		System.out.println("Use is Clicked");
		Thread.sleep(1000);
		if (UseText.isDisplayed()) {
			System.out.println("Use Text is displayed");
		}
		Thread.sleep(1000);
		if (More.isDisplayed()) {
			System.out.println("more Is displayed");
		}

	}
}
