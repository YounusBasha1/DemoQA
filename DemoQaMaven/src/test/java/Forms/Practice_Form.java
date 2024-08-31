package Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practice_Form {
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
		System.out.println("Practise form is Completed");
		driver.close();
	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//div[.='Forms']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[.='Practice Form']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("firstName")).sendKeys("Masthan");
		driver.findElement(By.id("lastName")).sendKeys("Shaik");
		driver.findElement(By.id("userEmail")).sendKeys("shaik@gmail.co");
		driver.findElement(By.xpath("//div[.='Male']")).click();
		driver.findElement(By.id("userNumber")).sendKeys("1234567890");
		Thread.sleep(2000);
		driver.findElement(By.id("dateOfBirthInput")).click();
		Thread.sleep(1000);
		Select s = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));

		s.selectByVisibleText("September");
		System.out.println("Selected Sep");
		Thread.sleep(1000);
		Select s1 = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
		s1.selectByVisibleText("2000");
		System.out.println("Set 200");
		driver.findElement(By.xpath("//div[@aria-label='Choose Monday, September 4th, 2000']")).click();
		System.out.println("Set 4th day");
		Thread.sleep(3000);
		WebElement sub = driver.findElement(By.xpath("//input[@id='subjectsInput']\r\n"));
		sub.sendKeys("maths");
		sub.sendKeys(Keys.TAB);
		sub.sendKeys("English");
		sub.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[.='Sports']")).click();
		driver.findElement(By.xpath("//label[.='Reading']")).click();
		driver.findElement(By.xpath("//label[.='Music']")).click();
		driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\HP\\Downloads\\sampleFile.jpeg");
		driver.findElement(By.id("currentAddress")).sendKeys("Here only my add");

		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath("//div[text()='Select State']"));
		Thread.sleep(2000);
		dropdown.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Rajasthan']")).click();
		Thread.sleep(1000);
		System.out.println("clicked Rajasthan");
		driver.findElement(By.xpath("//div[contains(text(),'Select City')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("react-select-4-option-0")).click();
		System.out.println("Clicked Jaipur");
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']")).getText()
				.equals("Thanks for submitting the form")) {
			System.out.println("Thanks for submitting the form");
		} else {
			System.out.println("not = Thanks for submitting the form");
		}
	}
}
