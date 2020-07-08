package APIAutomation.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverCommonLib {

	private WebDriverWait wait;
	private WebDriver driver;
	private Actions act=null;
	public WebElement getVisibility(WebDriver driver, WebElement webElement, int timeout) {
		this.driver=driver;
		WebElement element = null;
		wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOf(webElement));
		return element;
		}
	
	public boolean getVisibility(WebDriver driver, String xpath, int timeout) {
		this.driver=driver;
		Boolean element = false;
		wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
		return element;
		}
	public void clickElementWhenClickable(WebDriver driver,By locator, int timeout) {
		this.driver=driver;
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void movetoElement(WebDriver driver, String xpath) {
		this.driver= driver;
		act= new Actions(this.driver);
		act.moveToElement(this.driver.findElement(By.xpath(xpath))).perform();
	}
	
	public void movetoElementAndClick(WebDriver driver, String xpath) {
		this.driver= driver;
		act= new Actions(this.driver);
		act.moveToElement(this.driver.findElement(By.xpath(xpath))).click().perform();
	}
	
	public void scrollIntoView(WebDriver driver, WebElement element) {
		this.driver=driver;
		JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
}
