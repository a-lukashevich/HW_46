package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPF {
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
		PageFactory.initElements(driver, CommonPF.class);
		driver.get(url);
	}
	
	static void quit() {
		driver.quit();
	}
	
	static boolean isElementPresent(WebElement element) {
		if (element.getTagName() != null)
			return true;
		else
			return false;
//		try {element.getTagName(); return true;}
//		catch (NoSuchElementException e) {return false;}
	}
	
	static String getFileName() {
		String file = driver.getCurrentUrl().toString().trim();
		return file.substring(file.lastIndexOf('/') + 1);
	}
	
	static void pageValidation(String test_case, WebElement element) {
		System.out.println(test_case + (isElementPresent(element) ? " - exists" : " - not exist") + "; Page [" + getFileName() + "]");
	}
	
	@FindBy(id="id_quotes") @CacheLookup static WebElement pf_el_01;
	@FindBy(id="id_current_location") @CacheLookup static WebElement pf_el_02;
	@FindBy(id="id_weather_icon") @CacheLookup static WebElement pf_el_03;
	@FindBy(id="id_temperature") @CacheLookup static WebElement pf_el_04;
	@FindBy(id="id_f_title") @CacheLookup static WebElement pf_el_05;
	
	@FindBy(id="id_f_label_fn") @CacheLookup static WebElement pf_el_06;
	@FindBy(id="id_fname") @CacheLookup static WebElement pf_el_07;
	
	@FindBy(id="id_f_label_ln") @CacheLookup static WebElement pf_el_08;
	@FindBy(id="id_lname") @CacheLookup static WebElement pf_el_09;
	
	@FindBy(id="id_f_label_ea") @CacheLookup static WebElement pf_el_10;
	@FindBy(id="id_email") @CacheLookup static WebElement pf_el_11;
	
	@FindBy(id="id_f_label_pn") @CacheLookup static WebElement pf_el_12;
	@FindBy(id="id_phone") @CacheLookup static WebElement pf_el_13;
	
	@FindBy(id="id_rb_label_g") @CacheLookup static WebElement pf_el_14;
	
	@FindBy(id="id_rb_label_m") @CacheLookup static WebElement pf_el_15;
	@FindBy(id="id_gender_male") @CacheLookup static WebElement pf_el_16;
	
	@FindBy(id="id_rb_label_f") @CacheLookup static WebElement pf_el_17;
	@FindBy(id="id_gender_female") @CacheLookup static WebElement pf_el_18;
	
	@FindBy(id="id_f_label_s") @CacheLookup static WebElement pf_el_19;
	@FindBy(id="id_state") @CacheLookup static WebElement pf_el_20;
	@FindBy(xpath="//*[@id='id_state']/option[6]") @CacheLookup static WebElement pf_el_21;
	
	@FindBy(id="id_cb_label_t") @CacheLookup static WebElement pf_el_22;
	@FindBy(id="id_terms") @CacheLookup static WebElement pf_el_23;
	
	@FindBy(id="id_img_facebook") @CacheLookup static WebElement pf_el_24;
	@FindBy(id="id_img_twitter") @CacheLookup static WebElement pf_el_25;
	@FindBy(id="id_img_flickr") @CacheLookup static WebElement pf_el_26;
	@FindBy(id="id_img_youtube") @CacheLookup static WebElement pf_el_27;
	
	@FindBy(id="id_reset_button") @CacheLookup static WebElement pf_el_28;
	@FindBy(id="id_submit_button") @CacheLookup static WebElement pf_el_29;
	@FindBy(id="timestamp") @CacheLookup static WebElement pf_el_30;
	@FindBy(id="copyright") @CacheLookup static WebElement pf_el_31;
	@FindBy(id="os_browser") @CacheLookup static WebElement pf_el_32;
	
	@FindBy(id="ErrorLine") @CacheLookup static WebElement pf_el_33;
	@FindBy(id="fname_error") @CacheLookup static WebElement pf_el_34;
	@FindBy(id="lname_error") @CacheLookup static WebElement pf_el_35;
	@FindBy(id="email_error") @CacheLookup static WebElement pf_el_36;
	@FindBy(id="phone_error") @CacheLookup static WebElement pf_el_37;
	
	@FindBy(xpath="//*[@id='fname_error']/img") @CacheLookup static WebElement pf_el_38;
	@FindBy(xpath="//*[@id='lname_error']/img") @CacheLookup static WebElement pf_el_39;
	@FindBy(xpath="//*[@id='email_error']/img") @CacheLookup static WebElement pf_el_40;
	@FindBy(xpath="//*[@id='phone_error']/img") @CacheLookup static WebElement pf_el_41;
	
	@FindBy(id="id_gender") @CacheLookup static WebElement pf_el_42;
	@FindBy(id="id_back_button") @CacheLookup static WebElement pf_el_43;
}
