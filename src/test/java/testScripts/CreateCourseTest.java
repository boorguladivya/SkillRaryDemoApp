package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;


public class CreateCourseTest extends BaseClass{

	@Test
	public void createCourseTest() {
	SoftAssert soft=new SoftAssert();	
	 home.clickCoursesTab();
	 home.clickCoursesList();
	 //here validate page header
	 soft.assertEquals(course.getPageHeader(),"Course List");
	 course.clickNewBTN();
	 
	 Map<String,String>  map=excel.readFromExcel("Add Course");
	 course.addCourse(web,map.get("Name"),map.get("Category"), map.get("Price"),map.get("Photo"),map.get("Description"));
	 
	 //Adding course
//	 course.addCourse(web, "Selenium", "Testing", "10000","C:\\Users\\boorg\\Music\\Downloads\\flower.jpeg","Testing tool");
	 
	 soft.assertTrue(course.getAlertMessage().contains("Course added successfully"));
	
	 soft.assertTrue(course.searchForCourse(map.get("Name")));
		
	
	 course.deleteCourse(web, map.get("Name"));
	 
	 soft.assertFalse(course.searchForCourse(map.get("Name")));
	 
	 soft.assertTrue(course.getAlertMessage().contains("Product deleted successfully"));
	soft.assertAll();
	}
}
