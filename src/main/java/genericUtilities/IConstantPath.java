package genericUtilities;

public interface IConstantPath {

	String PROPERTIES_PATH = System.getProperty("user.dir")//it will give current working directory 
			+ "/src/test/resources/data.properties";
	String EXCEL_PATH = System.getProperty("user.dir") 
			+ "/src/test/resources/SkillRaryTestData.xlsx";
}