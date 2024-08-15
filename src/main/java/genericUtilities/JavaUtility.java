package genericUtilities;


import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {

	public void freeze(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public String getCurrentTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		return sdf.format(date);	
	}
	
	public Object parseStringToAnyDatatype(String dataType,String value) {
		Object obj=null;
		
		if(dataType.equalsIgnoreCase("int"))
			obj=Integer.parseInt(value);
		else if(dataType.equalsIgnoreCase("float"))
			obj=Float.parseFloat(value);
		else if(dataType.equalsIgnoreCase("long"))
			obj=Long.parseLong(value);
		else if(dataType.equalsIgnoreCase("short"))
			obj=Short.parseShort(value);
		else if(dataType.equalsIgnoreCase("double"))
			obj=Double.parseDouble(value);
		else
		  System.out.println("Invalid Data Type");
		return obj;
	}
}
