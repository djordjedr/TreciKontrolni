package stranice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Main {

	public static final String URL="https://www.saucedemo.com/";
	private static final String FUSERNAME="//*[@id=\"user-name\"]";
	private static final String FPASSWORD="//*[@id=\"password\"]";
	private static final String LOGIN="//*[@id=\"login-button\"]";
	
	
	public static void falseRegister(WebDriver driver,String fusername, String fpassword) {
		WebElement we= driver.findElement(By.xpath(FUSERNAME));
		we.click();
		we.sendKeys(fusername);
		WebElement be= driver.findElement(By.xpath(FPASSWORD));
		be.click();
		be.sendKeys(fpassword);
		WebElement ce= driver.findElement(By.cssSelector("input.btn_action"));
		ce.click();
		}
	
	public static void trueRegister(WebDriver driver,String username, String password) {
		WebElement we= driver.findElement(By.xpath(FUSERNAME));
		we.click();
		we.sendKeys(username);
		WebElement be= driver.findElement(By.xpath(FPASSWORD));
		be.click();
		be.sendKeys(password);
		WebElement ce= driver.findElement(By.cssSelector("input.btn_action"));
		ce.click();
		}
	
}
