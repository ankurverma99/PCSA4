package org.tests;

import org.genric.BaseTest;
import org.genric.ReadData;
import org.pom.ActiTimeHome;
import org.pom.EnterTimeTrak;
import org.testng.annotations.Test;

public class CreateTaks extends BaseTest {

	@Test
	public void createTaksTc() throws Exception {
		String sheetn = ReadData.readValue("SheetName");
		String user = ReadData.getCellValue(excel_path, sheetn, 2, 0);
		String pass = ReadData.getCellValue(excel_path, sheetn, 2, 1);
		ActiTimeHome ah = new ActiTimeHome(driver);
		ah.sendUsername(user);
		ah.sendpassWord(pass);
		ah.logInClick();
		EnterTimeTrak ett = new EnterTimeTrak(driver);
		ett.verifyHPisDisplyed(driver, ETO);
		ett.newClick();
		Thread.sleep(2000);
	}

}
