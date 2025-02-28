package TestCase;

import org.testng.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.GoogleHomePage;
import PageObject.googleSearchResult;



public class GoogleSearchResultTest extends BaseTest {
	@Test
	@Parameters({ "searchText", "suggestionIndex" })
	public void GoogleSearchTest(String searchText, int suggestionIndex) {
		GoogleHomePage Ghp = new PageObject.GoogleHomePage(driver);
		googleSearchResult Gr = new PageObject.googleSearchResult(driver);
		Ghp.LaunchUrl();;
		Ghp.isDisplayed();
		Ghp.searchText(searchText);
		Ghp.clickSuggestionByIndex(suggestionIndex);
		Gr.isDisplayed();
		Assert.assertEquals("Pass", "Pass");

	}

	/*
	 * @DataProvider public Object[][] dataprovider(){ return new Object[][]{
	 * {"selenium", 2}, {"docker", 3} };
	 */

}
