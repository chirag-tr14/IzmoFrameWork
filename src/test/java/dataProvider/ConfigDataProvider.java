package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider

{
	Properties prop;

	public ConfigDataProvider() {

		try {

			File src = new File("./Configuration/config.properties");

			FileInputStream fin = new FileInputStream(src);

			prop = new Properties();

			prop.load(fin);
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String applicationUrl() {
		String url = prop.getProperty("url");
		return url;
	}

	public String getChromePath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}

	public String getFirefoxPath() {
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getIePath() {
		String iepath = prop.getProperty("url1");
		return iepath;
	}

	//Contactus Form

	public String contactusFormUrl() {
		String curl = prop.getProperty("curl");
		return curl;
	}

	public String FormUrl1() {
		String curl = prop.getProperty("curl");
		return curl;
	}

}