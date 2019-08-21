package core;

import org.openqa.selenium.WebDriver;

public class SignUp {
	static String browser = "firefox";
	
	public static void validate(WebDriver driver, String url) throws Exception {
		Common.open(browser, url);
		Common.pageValidation("01.01 Element [Quotes (dynamic)]", Common.el_01);
		Common.pageValidation("02.02 Element [Current Location]", Common.el_02);
		Common.pageValidation("03.03 Element [Weather Icon]",     Common.el_03);
        Common.pageValidation("04.04 Element [Quotes (dynamic)]", Common.el_04);
        Common.pageValidation("05.05 Element [Title]",             Common.el_05);
        
        Common.pageValidation("06.06 Element [First Name (label)]",Common.el_06);
        Common.pageValidation("07.07 Element [First Name (field)]",Common.el_07);
        Common.pageValidation("08.08 Element [Last Name (label)]", Common.el_08);
        Common.pageValidation("09.09 Element [Last Name (field)]", Common.el_09);
        Common.pageValidation("10.10 Element [Email (label)]",     Common.el_10);

        Common.pageValidation("11.11 Element [Email (filed)]",     Common.el_11);
        Common.pageValidation("12.12 Element [Phone (label)]",     Common.el_12);
        Common.pageValidation("13.13 Element [Phone (field)]",     Common.el_13);
        Common.pageValidation("14.14 Element [Genre (label)]",     Common.el_14);
        Common.pageValidation("15.15 Element [Male (label)]",      Common.el_15);

        Common.pageValidation("16.16 Element [Male (radio button)]",Common.el_16);
        Common.pageValidation("17.17 Element [Female (label)]",     Common.el_17);
        Common.pageValidation("18.18 Element [Female (radio button)]", Common.el_18);
        Common.pageValidation("19.19 Element [State (label)]",     Common.el_19);
        Common.pageValidation("20.20 Element [State (drop-down)]", Common.el_20);

        Common.pageValidation("21.21 Element [State California (item)]", Common.el_21);
        Common.pageValidation("22.22 Element [Terms (label)]",     Common.el_22);
        Common.pageValidation("23.23 Element [Terms (checkbox)]", Common.el_23);
        Common.pageValidation("24.24 Element [Image (facebook)]", Common.el_24);
        Common.pageValidation("25.25 Element [Image (twitter)]",   Common.el_25);

        Common.pageValidation("26.26 Element [Image (flickr)]",    Common.el_26);
        Common.pageValidation("27.27 Element [Image (youtube)]",   Common.el_27);
        Common.pageValidation("28.28 Element [Reset (button)]",    Common.el_28);
        Common.pageValidation("29.29 Element [Submit (button)]",   Common.el_29);
        Common.pageValidation("30.30 Element [Timestamp (dynamic)]", Common.el_30);

        Common.pageValidation("31.31 Element [Copyright (dynamic)]", Common.el_31);
        Common.pageValidation("32.32 Element [OS & Browser (dynamic)]", Common.el_32);
        Common.pageValidation("33.33 Element [Error Line]",        Common.el_33);
        Common.pageValidation("34.34 Element [First Name Error]", Common.el_34);
        Common.pageValidation("35.35 Element [Last Name Error]",   Common.el_35);

        Common.pageValidation("36.36 Element [Email Error]",       Common.el_36);
        Common.pageValidation("37.37 Element [Phone Error]",       Common.el_37);
        Common.pageValidation("38.38 Element [First Name Error (img)]", Common.el_38);
        Common.pageValidation("39.39 Element [Last Name Error (img)]", Common.el_39);
        Common.pageValidation("40.40 Element [Email Error (img)]", Common.el_40);
        Common.pageValidation("41.41 Element [Phone Error (img)]", Common.el_41);
	}

}
