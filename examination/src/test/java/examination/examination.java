package examination;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class examination {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.variflight.com/en/flight-status");
		driver.findElement(By.xpath("//input[@id='search-flight-num']")).sendKeys("SQ5905");
		driver.findElement(By.xpath("//div[@id='searchBtn']")).click();
		String Actualtitle = driver.getTitle();
		String expectedTitle = "VariFlight—Living on time! We are a leading global flight data services company. We provide flight data such as historical flight status and schedule, realtime flight information and intergarated data such as flight happiness index";
		System.out.print("Site title "+Actualtitle);
		Assert.assertEquals(expectedTitle, Actualtitle);
		System.out.print("Assertion passed");
//		Thread.sleep(3000);
		
		driver.quit();

	}

}

