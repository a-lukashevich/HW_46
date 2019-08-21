package core;

import org.openqa.selenium.WebDriver;

public class ConfirmationPF {
static String browser = "firefox";
	
	public static void validate(WebDriver driver, String url) throws Exception {
		CommonPF.open(browser, url);
		
        CommonPF.pageValidation("42.05 Element [Title]",              CommonPF.pf_el_05);
        CommonPF.pageValidation("43.06 Element [First Name (label)]",CommonPF.pf_el_06);
        CommonPF.pageValidation("44.07 Element [First Name (field)]",CommonPF.pf_el_07);
        CommonPF.pageValidation("45.08 Element [Last Name (label)]", CommonPF.pf_el_08);
        CommonPF.pageValidation("46.09 Element [Last Name (field)]", CommonPF.pf_el_09);

        CommonPF.pageValidation("47.10 Element [Email (label)]",     CommonPF.pf_el_10);
        CommonPF.pageValidation("48.11 Element [Email (filed)]",     CommonPF.pf_el_11);
        CommonPF.pageValidation("49.12 Element [Phone (label)]",     CommonPF.pf_el_12);
        CommonPF.pageValidation("50.13 Element [Phone (field)]",     CommonPF.pf_el_13);
        CommonPF.pageValidation("51.14 Element [Genre (label)]",     CommonPF.pf_el_14);

        CommonPF.pageValidation("52.42 Element [Genre (field)]",     CommonPF.pf_el_42);
        CommonPF.pageValidation("53.43 Element [Back (button)]",     CommonPF.pf_el_43);     
	}

}
