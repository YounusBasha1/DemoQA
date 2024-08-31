package Widgets;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Select_Menu {
	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com");
		Thread.sleep(2000);
	}

//	@AfterTest
//	public void CloseBrowser() {
//		System.out.println("MoveToElement1 is Completed");
//		driver.close();
//	}

	@Test
	public void Testing() throws Exception {
		driver.findElement(By.xpath("//h5[text()='Widgets']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Select Menu']")).click();
		Thread.sleep(2000);
		WebElement Dropdown = driver.findElement(By.id("cars"));

		Select s = new Select(Dropdown);
		boolean Cheacking = s.isMultiple();
//checking the Dropdown is allows to multiple Values or not
		if (Cheacking == true) {
			System.out.println("This Allows to Select Multiple Values");
			s.selectByVisibleText("Volvo");
			s.selectByVisibleText("Audi");

		}
		//Printing the Selected Values
		List<WebElement> SelectedOptions = s.getAllSelectedOptions();
		for (WebElement SelectedOption : SelectedOptions) {

			System.out.println(SelectedOption.getText());

		}
		//DeSelecting the Value
		s.deselectByVisibleText("Volvo");
		//Printig the All Options in DropDown
		List<WebElement> Options = s.getOptions();
		for (WebElement Option : Options) {
			System.out.println(Option.getText());
		}
		Thread.sleep(2000);
		//Multi Select DropDown
		WebElement Dropdown1 = driver.findElement(By.xpath("(//div[@class=' css-2b097c-container']/div)[3]/div[1]"));
		Dropdown1.click();
		Thread.sleep(1000);
		driver.findElement(By.id("react-select-4-option-0")).click();
		driver.findElement(By.id("react-select-4-option-1")).click();
		driver.findElement(By.id("react-select-4-option-2")).click();
		driver.findElement(By.id("react-select-4-option-3")).click();
	    Thread.sleep(1000);
	    WebElement OptionMes = driver.findElement(By.xpath("//div[text()='No options']"));
		
		if (OptionMes.isDisplayed()) {
			System.out.println("Displayed");
		}
	//Select One
		WebElement Dropdown3 = driver.findElement(By.id("oldSelectMenu"));
		Thread.sleep(1000);
		Select s2 = new Select(Dropdown3);
		List<WebElement> getall = s2.getOptions();
		for (WebElement getal : getall) {
			System.out.println(getal.getText());
		}

		//s2.selectByIndex(3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}