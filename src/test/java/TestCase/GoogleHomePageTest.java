package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.GoogleHomePage;

public class GoogleHomePageTest extends BaseTest {
    @Test
	public void GoogleHomePage() {
    	GoogleHomePage gp = new GoogleHomePage(driver);
		gp.LaunchUrl();
		gp.isDisplayed();
		Assert.assertEquals(1, 1);
		
    	
		
		
	}
}
