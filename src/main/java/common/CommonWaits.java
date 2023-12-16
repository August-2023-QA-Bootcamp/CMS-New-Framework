package common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import reports.Loggers;


public class CommonWaits {

	static WebDriverWait wait;
	
	public CommonWaits(WebDriverWait wait) {
		CommonWaits.wait = wait;
	}
	
	public static void waitUntilClickable(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Loggers.logTheTest("The element was clickable and here it clicked ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n");
			Assert.fail();
		}
	}
}
