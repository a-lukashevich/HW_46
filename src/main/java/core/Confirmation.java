package core;

import org.openqa.selenium.WebDriver;

public class Confirmation {
	static String browser = "firefox";
	
	public static void validate(WebDriver driver, String url) throws Exception {
		Common.open(browser, url);
		
        Common.pageValidation("42.05 Element [Title]",              Common.el_05);
        Common.pageValidation("43.06 Element [First Name (label)]",Common.el_06);
        Common.pageValidation("44.07 Element [First Name (field)]",Common.el_07);
        Common.pageValidation("45.08 Element [Last Name (label)]", Common.el_08);
        Common.pageValidation("46.09 Element [Last Name (field)]", Common.el_09);

        Common.pageValidation("47.10 Element [Email (label)]",     Common.el_10);
        Common.pageValidation("48.11 Element [Email (filed)]",     Common.el_11);
        Common.pageValidation("49.12 Element [Phone (label)]",     Common.el_12);
        Common.pageValidation("50.13 Element [Phone (field)]",     Common.el_13);
        Common.pageValidation("51.14 Element [Genre (label)]",     Common.el_14);

        Common.pageValidation("52.42 Element [Genre (field)]",     Common.el_42);
        Common.pageValidation("53.43 Element [Back (button)]",     Common.el_43);     
	}

}
