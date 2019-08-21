package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Common {
	static WebDriver driver;
	
	static void getWebDriver(String browser) {
		Logger.getLogger("").setLevel(Level.OFF);
		String driverPath = "";
		if (browser.equalsIgnoreCase("firefox")) {
			if (System.getProperty("os.name").toUpperCase().contains("MAC"))
				driverPath = "./resources/webdrivers/mac/geckodriver.sh";
			else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
				 driverPath = "./resources/webdrivers/pc/geckodriver.exe";
			else throw new IllegalArgumentException("Unknown OS");
			
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			if (System.getProperty("os.name").toUpperCase().contains("MAC"))
				driverPath = "./resources/webdrivers/mac/chromedriver";
			else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
				 driverPath = "./resources/webdrivers/pc/chromedriver.exe";
			else throw new IllegalArgumentException("Unknown OS");
			
			System.setProperty("webdriver.chrome.driver", driverPath);
			System.setProperty("webdriver.chrome.silentOutput", "true");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("disable-infobars");
			option.addArguments("--disable-notifications");
			
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
		}
		else if (browser.equalsIgnoreCase("safari")) {
			if (!System.getProperty("os.name").toUpperCase().contains("MAC")) {
				throw new IllegalArgumentException("Safari is available only on Mac");
			}
			driver = new SafariDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		else if (browser.equalsIgnoreCase("edge")) {
			if (!System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
				throw new IllegalArgumentException("MS Edge is available only on Windows");
			}
			System.setProperty("webdriver.edge.driver", "./resources/webdrivers/pc/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		else {
			throw new WebDriverException("Unknown WebDriver");
		}
	}
	
	static void open(String browser, String url) {
		getWebDriver(browser);
		driver.get(url);
	}
	
	static void quit() {
		driver.quit();
	}
	
	static boolean isElementPresent(By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty())
			return true;
		else
			return false;
	}
	
	static String getFileName() {
		String file = driver.getCurrentUrl().toString().trim();
		return file.substring(file.lastIndexOf('/') + 1);
	}
	
	static void pageValidation(String test_case, By by) {
		System.out.println(test_case + (isElementPresent(by) ? " - exists" : " - not exist") + "; Page [" + getFileName() + "]");
	}
	
	static By el_01 = By.id("id_quotes");							//signup
	static By el_02 = By.id("id_current_location");					//signup
	static By el_03 = By.id("id_weather_icon");						//signup
	static By el_04 = By.id("id_temperature");						//signup
	static By el_05 = By.id("id_f_title");							//signup & confirmation
	
	static By el_06 = By.id("id_f_label_fn");						//signup & confirmation
	static By el_07 = By.id("id_fname");							//signup & confirmation
	
	static By el_08 = By.id("id_f_label_ln");						//signup & confirmation
	static By el_09 = By.id("id_lname");							//signup & confirmation
	
	static By el_10 = By.id("id_f_label_ea");						//signup & confirmation
	static By el_11 = By.id("id_email");							//signup & confirmation
	
	static By el_12 = By.id("id_f_label_pn");						//signup & confirmation
	static By el_13 = By.id("id_phone");							//signup & confirmation
	
	static By el_14 = By.id("id_rb_label_g");						//signup & confirmation
	
	static By el_15 = By.id("id_rb_label_m");						//signup
	static By el_16 = By.id("id_gender_male");						//signup
	
	static By el_17 = By.id("id_rb_label_f");						//signup
	static By el_18 = By.id("id_gender_female");					//signup
	
	static By el_19 = By.id("id_f_label_s");						//signup & confirmation
	static By el_20 = By.id("id_state");							//signup & confirmation
	static By el_21 = By.xpath("//*[@id='id_state']/option[6]");	//signup
	
	static By el_22 = By.id("id_cb_label_t");						//signup & confirmation
	static By el_23 = By.id("id_terms");							//signup & confirmation
	
	static By el_24 = By.id("id_img_facebook");						//signup
	static By el_25 = By.id("id_img_twitter");						//signup
	static By el_26 = By.id("id_img_flickr");						//signup
	static By el_27 = By.id("id_img_youtube");						//signup
	
	static By el_28 = By.id("id_reset_button");						//signup
	static By el_29 = By.id("id_submit_button");					//signup
	
	static By el_30 = By.id("timestamp");							//signup
	static By el_31 = By.id("copyright");							//signup & confirmation
	static By el_32 = By.id("os_browser");							//signup
	
	static By el_33 = By.id("ErrorLine");							//signup
	static By el_34 = By.id("fname_error");							//signup 
	static By el_35 = By.id("lname_error");							//signup 
	static By el_36 = By.id("email_error");							//signup 
	static By el_37 = By.id("phone_error");							//signup 
	
	static By el_38 = By.xpath("//*[@id='fname_error']/img");		//signup 
	static By el_39 = By.xpath("//*[@id='lname_error']/img");		//signup 
	static By el_40 = By.xpath("//*[@id='email_error']/img");		//signup 
	static By el_41 = By.xpath("//*[@id='phone_error']/img");		//signup 
	
	static By el_42 = By.id("id_gender");							//confirmation
	static By el_43 = By.id("id_back_button");						//confirmation
}
