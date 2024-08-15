package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {

	// Declaration
	@FindBy(xpath = "//h1[contains(text(),'Users')]")
	private WebElement pageHeader;

	@FindBy(xpath = "//a[contains(text(), 'New')]")
	private WebElement newBTN;
	
	@FindBy(xpath = "//div[contains(@class,'alert')]")
	private WebElement alert;

	@FindBy(xpath = "//input[@id='email' and @required]") // passing multiple attributes to x path
	private WebElement emailTF;

	@FindBy(xpath = "//input[@id='password' and @required]")
	private WebElement passwordTF;

	@FindBy(xpath = "//input[@id='firstname' and @required]")
	private WebElement firstNameTF;

	@FindBy(xpath = "//input[@id='lastname' and @required]")
	private WebElement lastNameTF;

	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement addressTF;

	@FindBy(xpath = "//input[@id='contact']")
	private WebElement contactTF;

	@FindBy(xpath = "(//input[@id='photo'])[2]")
	private WebElement chooseFile;

	@FindBy(xpath = "//button[@name='add']")
	private WebElement saveBTN;

	// Initialization
	public UsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void clickNewBtn() {
		newBTN.click();
	}

	public void createUser(String email,String pwd,String firstName,String lastName,String address,String contact,String file) {
	   emailTF.sendKeys(email);
       passwordTF.sendKeys(pwd);
       firstNameTF.sendKeys(firstName);
       lastNameTF.sendKeys(lastName);
       addressTF.sendKeys(address);
       contactTF.sendKeys(contact);
       chooseFile.sendKeys(file);
       saveBTN.click();
	}
//public void createUser(Map<String,String> map){
//emailTF.sendkeys(map.get("Email"));
	
	public String getAlertMessage() {
		return alert.getText();
	}
}
