package TestCase;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setupDriver() throws MalformedURLException, URISyntaxException {
        String browser = System.getProperty("browser", "chrome");
        String host = "localhost";
		if(System.getProperty("HUB_HOST")!=null) {
			host=System.getProperty("HUB_HOST");
			
		}

        URI gridURL = new URI("http://" + host +":4444/wd/hub");

        switch (browser.toLowerCase()) {
        case "firefox":
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            this.driver = new RemoteWebDriver(gridURL.toURL(), firefoxOptions);
            break;

        case "edge":
            EdgeOptions edgeOptions = new EdgeOptions();
            this.driver = new RemoteWebDriver(gridURL.toURL(), edgeOptions);
            break;

        case "chrome":
        default:
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            this.driver = new RemoteWebDriver(gridURL.toURL(), chromeOptions);
            break;
        }
        System.out.println("Started session with browser: " + browser);
    }

    @AfterMethod
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            System.out.println("Closed browser session");
        }
    }
}
