package selenide_tests;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import selenium_pages.BasePage;
import selenium_pages.HomePage;
import selenium_pages.ProjectPage;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class SauceLabsTesting {
    private BasePage basePage = new BasePage();
    private HomePage homePage = new HomePage();
    private ProjectPage projectPage = new ProjectPage();
    private final String URL = "https://oauth-hereonearth692-e8e17:75e551eb-e528-4666-a78a-38df4789d7e4@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    private RemoteWebDriver driver;


    @SneakyThrows
    @BeforeMethod
    public void testsSetUp() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "1.0");
        sauceOptions.put("name", "Check WebDriver topic's header");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL(URL);
        driver = new RemoteWebDriver(url, browserOptions);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test() {
        driver.navigate().to(basePage.getURL());
        driver.findElement(By.xpath(homePage.getProjectButton())).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete"));
        String topicHeader = driver.findElement(By.xpath(projectPage.getSeleniumWebDriverBlock())).getText();
        Assert.assertEquals(topicHeader, "Selenium WebDriver");
    }
}
