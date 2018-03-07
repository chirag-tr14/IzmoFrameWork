package factory;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public class DataproviderFactory

{

	public static ConfigDataProvider getConfig() {
		ConfigDataProvider config = new ConfigDataProvider();
		return config;
	}

	public static ExcelDataProvider getExcel() {
		ExcelDataProvider excel = new ExcelDataProvider("./ApplicationTestData/PriceRule.xlsx");
		return excel;
	}

	public static ExcelDataProvider contactusExcel() {
		ExcelDataProvider formsxcel = new ExcelDataProvider("./ApplicationTestData/ContactUSForm.xlsx");
		return formsxcel;
	}

}
