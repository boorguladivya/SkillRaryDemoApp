package testScripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;

public class CreateUsersTest extends BaseClass {

	@Test
	public void CreateUsersTest() {
		SoftAssert soft = new SoftAssert();
		home.clickUsersTab();
     	soft.assertTrue(users.getPageHeader().contains("Users"));
		users.clickNewBtn();

		Map<String, String> map = excel.readFromExcel("Add User");
		users.createUser(map.get("Email"), map.get("Password"), map.get("Firstname"), map.get("Lastname"),
				map.get("Address"), map.get("Contact Info"), map.get("Photo"));
		try {
			users.getAlertMessage();
		}
		catch(Exception e) {
			web.captureScreennshot();
			Assert.fail();
		}
		
    	soft.assertAll();
	}

}
