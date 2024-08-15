package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// Declaration
	@FindBy(xpath = "//span[text()='Users']")
	private WebElement usersTab;

	@FindBy(xpath = "//span[text()='Courses']")
	private WebElement coursesTab;

	@FindBy(xpath = "//a[text()=' Course List']")
	private WebElement coursesListLink;

	@FindBy(xpath = "//a[text()=' Category']")
	private WebElement categoryLink;

	@FindBy(xpath = "//span[text()='SkillRary Admin']")
	private WebElement skillraryAdmin;

	@FindBy(xpath = "//a[text()='Sign out']")
	private WebElement signoutLink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickUsersTab() {
		usersTab.click();
	}

	public void clickCoursesTab() {
		coursesTab.click();
	}

	public void clickCoursesList() {
		coursesListLink.click();
	}

	public void clickCategory() {
		categoryLink.click();
	}
    
	public void signOutOfSkillrary() {
		skillraryAdmin.click();
		signoutLink.click();
	}
}
