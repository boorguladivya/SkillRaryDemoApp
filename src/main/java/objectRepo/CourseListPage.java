package objectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CourseListPage {

	@FindBy(xpath = "//h1[contains(text(),'Course List')]")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//a[text() = ' New']")
	private WebElement newBTN;
	
	@FindBy(xpath = "//div[contains(@class,'alert')]")
	private WebElement alert;
	
	@FindBy(xpath = "//td[@class='sorting_1']")
	private List<WebElement> courseList;
	
	private String dynamicPathForDelete = "//td[text()='%s']/following-sibling::td/button[text()=' Delete']";
	
	@FindBy(xpath = "//button[@name='delete']")
	private WebElement deleteBTN;
	
	@FindBy(xpath = "//input[@name='name' and @required]")
	private WebElement nameTF;
	
	@FindBy(xpath = "//select[@id='category']")
	private WebElement categoryDD;
	
	@FindBy(xpath = "//input[@id='price']")
	private WebElement priceTF;
	
	@FindBy(xpath = "(//input[@id='photo'])[2]")
	private WebElement chooseFile;
	
	@FindBy(xpath = "//iframe[@aria-describedby='cke_56']")
	private WebElement descriptionFrame;
	
	@FindBy(xpath = "//html/body/p")
	private WebElement descriptionBody;
	
	@FindBy(xpath = "//button[@name='add']")
	private WebElement saveBTN;
	
	public CourseListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public String getAlertMessage() {
		return alert.getText();
	}
	
	public void clickNewBTN() {
		newBTN.click();
	}
	
	public boolean searchForCourse(String courseName) {
		boolean isPresent = false;
		for (WebElement course : courseList) {
			if(course.getText().equals(courseName)) {
				isPresent = true;
				break;
			}	
		}
		return isPresent;
	}
	
	public void deleteCourse(WebDriverUtility web, String courseName) {
		web.convertDyanamicXpathToWebElement(dynamicPathForDelete, courseName).click();
		deleteBTN.click();
	}
	
	public void addCourse(WebDriverUtility web, String name, String category, 
							String price, String photoFile, String description) {
		nameTF.sendKeys(name);
		web.selectAnOption(category, categoryDD);
		priceTF.sendKeys(price);
		chooseFile.sendKeys(photoFile);
		
		web.switchToFrame(descriptionFrame);
		descriptionBody.sendKeys(description);
		web.switchBackFromFrame();
		
		saveBTN.click();
	}
}