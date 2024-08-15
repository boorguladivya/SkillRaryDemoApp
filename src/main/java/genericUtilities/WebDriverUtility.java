package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	Select select;

	// To Launch Browser
	public WebDriver launchBrowser(String browser) {
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
		case "edge":
			driver = new EdgeDriver();
		default:
			System.out.println("Invalid browser info");
		}
		return driver;
	}

	// To maximize the browser
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	// To navigate to browser
	public void navigateToApp(String url) {
		driver.get(url);
	}

	public void waitTillElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	// **************************Explicit Wait********************
	public WebElement explicitWait(long time, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement explicitWait(WebElement element, long time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public Boolean explicitWait(String title, long time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleContains(title));
	}

	// **************************Actions Class********************
	public void mouseHover(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void rightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void double_click(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void drag_drop(WebElement element, WebElement dest) {
		actions = new Actions(driver);
		actions.dragAndDrop(element, dest).perform();
	}

	// ****************DROPDOWNS-->Select Class*******************
	public void selectAnOption(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectAnOption(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	public void selectAnOption(String text, WebElement element) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	// **************************Frames*********************
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}

	// *********************TakesScreenShot*******************
	public void captureScreennshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/failed.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// *********************JavaScriptEXecutor*******************
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoview(true)", element);
	}

	// *************************POPUPs***************************
	public void handleAlert(String status) {
		Alert a = driver.switchTo().alert();
		if (status.equalsIgnoreCase("ok"))
			a.accept();
		else
			a.dismiss();
	}

	// Child window Popup
	public void switchToWindow(String expectedTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			if (driver.getTitle().equalsIgnoreCase(expectedTitle))
				break;
		}
	}

	// ****Converting Dynamic xpath to WebElement (For CourseList page Delete
	// Button-->to traverse td of course name to td of delete button)
	public WebElement convertDyanamicXpathToWebElement(String dynamicPath, String replaceData) {
		String requiredPath = String.format(dynamicPath, replaceData);
		return driver.findElement(By.xpath(requiredPath));
	}

	// To close the browser
	public void closeBrowser() {
		driver.close();
	}

	// To quit the browser
	public void quitBrowsers() {
		driver.quit();
	}
}
