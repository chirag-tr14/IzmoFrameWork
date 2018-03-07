package price.rule.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import factory.BrowserFactory;
import factory.DataproviderFactory;
import price.rule.front.sc.PriceruleGroup;
import price.rule.front.sc.Login;

  

public class AddpriceRuleGroupLevel 
{
	

 
 	WebDriver driver;
 	ExtentReports report;
 	ExtentTest logger;
 
 	 @Test(priority=0)
 	 	  public void setUp1(){
	  
	    driver= BrowserFactory.getBrowser("chrome");
 		driver.manage().deleteAllCookies();
 		driver.get(DataproviderFactory.getConfig().applicationUrl());
 		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);;
	     report =new ExtentReports(".\\Reports\\GroupPriceRuleAdd.html",true);
	    logger=report.startTest("Login SC");
	    logger.log(LogStatus.INFO, "Application is up and running");
	 
   }
   	
     
     
     @Test(priority=1)
	   public void dealerDiscount()
	   {
    	 PriceruleGroup GroupInvt= PageFactory.initElements(driver, PriceruleGroup.class);
  	        Login login =PageFactory.initElements(driver, Login.class);
  	      	    		 
  	    	
	  	 login.loginApplication(DataproviderFactory.getExcel().getData("Sheet1",1,0),
				 DataproviderFactory.getExcel().getData("Sheet1",1,1));
	  	  logger=report.startTest("Naviagte to Group Level Price Rule Module");
	  	        login.selectDealer();
	  	        login.pgagroupSearch(DataproviderFactory.getExcel().getData("Sheet2", 2, 0));
	  	        
	  	      GroupInvt.manageInventory(); 
	  	        
	  	      GroupInvt.delaerDiscountPriceRuleGroup();
	  	      
	  	      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  	        
	  	  
	   }
     
     @Test(priority=2)
       public void  oemDiscount()
       {
    	 
    	  
    	    PriceruleGroup GroupInvt= PageFactory.initElements(driver, PriceruleGroup.class);
    	  	  	        
  	  	    GroupInvt.manageInventory(); 
  	  	        
  	  	    GroupInvt.oemDiscountPriceRuleGroup();
  	  	     
  	  	  
  	   }
       
     
     @Test(priority=3)
     public void greenDiscount()
       {
    	 PriceruleGroup GroupInvt= PageFactory.initElements(driver, PriceruleGroup.class);
 	        
	  	    GroupInvt.manageInventory(); 
	  	        
	  	    GroupInvt.greenDiscountPriceRuleGroup();
       }
     
     
     @Test(priority=4)
     public void tradeInDiscount()
       {

    	 PriceruleGroup GroupInvt= PageFactory.initElements(driver, PriceruleGroup.class);
 	        
	  	    GroupInvt.manageInventory(); 
	  	        
	  	    GroupInvt.greenDiscountPriceRuleGroup();
       }
   }

