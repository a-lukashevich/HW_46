package core;

import org.openqa.selenium.WebDriver;

public class MainPF {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		SignUpPF.validate(driver, "http://alex.academy/exe/signup/www/index.php");
		CommonPF.quit();
		ConfirmationPF.validate(driver, "http://alex.academy/exe/signup/www/confirmation.php");
		CommonPF.quit();
	}

}
