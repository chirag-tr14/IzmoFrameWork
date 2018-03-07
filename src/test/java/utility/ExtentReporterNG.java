package utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public  class ExtentReporterNG{

	static ExtentReports report;
	ExtentTest logger;
	
	public static ExtentReports getInstance(){
		report = new ExtentReports(".\\Reports\\PriceRuleAdd.html", true);
		
		return report;
	
	}
}
    



