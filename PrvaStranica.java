package stranice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PrvaStranica {

	public static final String URL="https://www.saucedemo.com/inventory.html";
	public static final String SORTIRANJE_URL="https://www.saucedemo.com/inventory.html";
	private static final String SORTBTN="//*[@id=\"inventory_filter_container\"]/select";
	
	
	public static void SortiranjeP (WebDriver driver) {
		WebElement we= driver.findElement(By.xpath(SORTBTN));
		we.click();
		
		Select dropdownCountry = new Select(driver.findElement(By.className("product_sort_container")));  
		dropdownCountry.selectByVisibleText("Price (low to high)");
		WebElement be= driver.findElement(By.xpath(SORTBTN));
		be.click();
	}
	
	public static void DohvatiPrvi (WebDriver driver) {
		WebElement we= driver.findElement(By.xpath(SORTBTN));
		we.click();
		
}
}
