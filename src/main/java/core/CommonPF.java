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
	
	//static By el_01 = By.id("id_quotes");							//signup
	@FindBy(id="id_quotes") @CacheLookup static WebElement pf_el_01;
	//static By el_02 = By.id("id_current_location");					//signup
	@FindBy(id="id_current_location") @CacheLookup static WebElement pf_el_02;
	//static By el_03 = By.id("id_weather_icon");						//signup
	@FindBy(id="id_weather_icon") @CacheLookup static WebElement pf_el_03;
	//static By el_04 = By.id("id_temperature");						//signup
	@FindBy(id="id_temperature") @CacheLookup static WebElement pf_el_04;
	//static By el_05 = By.id("id_f_title");							//signup & confirmation
	@FindBy(id="id_f_title") @CacheLookup static WebElement pf_el_05;
	
	//static By el_06 = By.id("id_f_label_fn");						//signup & confirmation
	@FindBy(id="id_f_label_fn") @CacheLookup static WebElement pf_el_06;
	//static By el_07 = By.id("id_fname");							//signup & confirmation
	@FindBy(id="id_fname") @CacheLookup static WebElement pf_el_07;
	
	//static By el_08 = By.id("id_f_label_ln");						//signup & confirmation
	@FindBy(id="id_f_label_ln") @CacheLookup static WebElement pf_el_08;
	//static By el_09 = By.id("id_lname");							//signup & confirmation
	@FindBy(id="id_lname") @CacheLookup static WebElement pf_el_09;
	
	//static By el_10 = By.id("id_f_label_ea");						//signup & confirmation
	@FindBy(id="id_f_label_ea") @CacheLookup static WebElement pf_el_10;
	//static By el_11 = By.id("id_email");							//signup & confirmation
	@FindBy(id="id_email") @CacheLookup static WebElement pf_el_11;
	
	//static By el_12 = By.id("id_f_label_pn");						//signup & confirmation
	@FindBy(id="id_f_label_pn") @CacheLookup static WebElement pf_el_12;
	//static By el_13 = By.id("id_phone");							//signup & confirmation
	@FindBy(id="id_phone") @CacheLookup static WebElement pf_el_13;
	
	//static By el_14 = By.id("id_rb_label_g");						//signup & confirmation
	@FindBy(id="id_rb_label_g") @CacheLookup static WebElement pf_el_14;
	
	//static By el_15 = By.id("id_rb_label_m");						//signup
	@FindBy(id="id_rb_label_m") @CacheLookup static WebElement pf_el_15;
	//static By el_16 = By.id("id_gender_male");						//signup
	@FindBy(id="id_gender_male") @CacheLookup static WebElement pf_el_16;
	
	//static By el_17 = By.id("id_rb_label_f");						//signup
	@FindBy(id="id_rb_label_f") @CacheLookup static WebElement pf_el_17;
	//static By el_18 = By.id("id_gender_female");					//signup
	@FindBy(id="id_gender_female") @CacheLookup static WebElement pf_el_18;
	
	//static By el_19 = By.id("id_f_label_s");						//signup & confirmation
	@FindBy(id="id_f_label_s") @CacheLookup static WebElement pf_el_19;
	//static By el_20 = By.id("id_state");							//signup & confirmation
	@FindBy(id="id_state") @CacheLookup static WebElement pf_el_20;
	//static By el_21 = By.xpath("//*[@id='id_state']/option[6]");	//signup
	@FindBy(xpath="//*[@id='id_state']/option[6]") @CacheLookup static WebElement pf_el_21;
	
	//static By el_22 = By.id("id_cb_label_t");						//signup & confirmation
	@FindBy(id="id_cb_label_t") @CacheLookup static WebElement pf_el_22;
	//static By el_23 = By.id("id_terms");							//signup & confirmation
	@FindBy(id="id_terms") @CacheLookup static WebElement pf_el_23;
	
	//static By el_24 = By.id("id_img_facebook");						//signup
	@FindBy(id="id_img_facebook") @CacheLookup static WebElement pf_el_24;
	//static By el_25 = By.id("id_img_twitter");						//signup
	@FindBy(id="id_img_twitter") @CacheLookup static WebElement pf_el_25;
	//static By el_26 = By.id("id_img_flickr");						//signup
	@FindBy(id="id_img_flickr") @CacheLookup static WebElement pf_el_26;
	//static By el_27 = By.id("id_img_youtube");						//signup
	@FindBy(id="id_img_youtube") @CacheLookup static WebElement pf_el_27;
	
	//static By el_28 = By.id("id_reset_button");						//signup
	@FindBy(id="id_reset_button") @CacheLookup static WebElement pf_el_28;
	//static By el_29 = By.id("id_submit_button");					//signup
	@FindBy(id="id_submit_button") @CacheLookup static WebElement pf_el_29;
	//static By el_30 = By.id("timestamp");							//signup
	@FindBy(id="timestamp") @CacheLookup static WebElement pf_el_30;
	//static By el_31 = By.id("copyright");							//signup & confirmation
	@FindBy(id="copyright") @CacheLookup static WebElement pf_el_31;
	//static By el_32 = By.id("os_browser");							//signup
	@FindBy(id="os_browser") @CacheLookup static WebElement pf_el_32;
	
	//static By el_33 = By.id("ErrorLine");							//signup
	@FindBy(id="ErrorLine") @CacheLookup static WebElement pf_el_33;
	//static By el_34 = By.id("fname_error");							//signup 
	@FindBy(id="fname_error") @CacheLookup static WebElement pf_el_34;
	//static By el_35 = By.id("lname_error");							//signup 
	@FindBy(id="lname_error") @CacheLookup static WebElement pf_el_35;
	//static By el_36 = By.id("email_error");							//signup 
	@FindBy(id="email_error") @CacheLookup static WebElement pf_el_36;
	//static By el_37 = By.id("phone_error");							//signup
	@FindBy(id="phone_error") @CacheLookup static WebElement pf_el_37;
	
	//static By el_38 = By.xpath("//*[@id='fname_error']/img");		//signup 
	@FindBy(xpath="//*[@id='fname_error']/img") @CacheLookup static WebElement pf_el_38;
	//static By el_39 = By.xpath("//*[@id='lname_error']/img");		//signup 
	@FindBy(xpath="//*[@id='lname_error']/img") @CacheLookup static WebElement pf_el_39;
	//static By el_40 = By.xpath("//*[@id='email_error']/img");		//signup 
	@FindBy(xpath="//*[@id='email_error']/img") @CacheLookup static WebElement pf_el_40;
	//static By el_41 = By.xpath("//*[@id='phone_error']/img");		//signup 
	@FindBy(xpath="//*[@id='phone_error']/img") @CacheLookup static WebElement pf_el_41;
	
	//static By el_42 = By.id("id_gender");							//confirmation
	@FindBy(id="id_gender") @CacheLookup static WebElement pf_el_42;
	//static By el_43 = By.id("id_back_button");						//confirmation
	@FindBy(id="id_back_button") @CacheLookup static WebElement pf_el_43;
}
