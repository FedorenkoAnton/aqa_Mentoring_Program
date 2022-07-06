package selenide_tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import selenium_pages.BasePage;
import selenium_pages.EventsPage;
import selenium_pages.HomePage;
import selenium_pages.ProjectPage;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

@Listeners(ScreenShooter.class)
public class TestForSelenideTask {
    private HomePage homePage;
    private ProjectPage projectPage;
    private BasePage basePage;
    private EventsPage eventsPage;
    private Logger loggerFactory;

    private final String URL = "https://oauth-hereonearth692-e8e17:75e551eb-e528-4666-a78a-38df4789d7e4@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

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
        WebDriverRunner.setWebDriver(new RemoteWebDriver(url, browserOptions));

    }

    @BeforeTest
    public void init() {
        basePage = new BasePage();
        homePage = new HomePage();
        projectPage = new ProjectPage();
        eventsPage = new EventsPage();
        loggerFactory = LoggerFactory.getLogger(TestForSelenideTask.class);
        ScreenShooter.captureSuccessfulTests = true;
    }

    @Test
    public void checkThatProjectPageHasSeleniumWebDriverBlock() {
        open(basePage.getURL());
        element(By.xpath(homePage.getProjectButton())).click();
        element(By.xpath(projectPage.getSeleniumWebDriverBlock())).should(text("Selenium WebDrive"));
    }

    @Test
    public void checkThatProjectPageHasSeleniumIdeBlock() {
        open(basePage.getURL());
        element(By.xpath(homePage.getProjectButton())).click();
        element(By.xpath(projectPage.getSeleniumIdeBlock())).should(text("Selenium IDE"));
    }

    @Test
    public void checkThatProjectPageHasSeleniumGridBlock() {
        open(basePage.getURL());
        element(By.xpath(homePage.getProjectButton())).click();
        element(By.xpath(projectPage.getSeleniumGridBlock())).should(text("Selenium Grid"));
    }

    @Test
    public void checkThatSponsorBlockContainsEightItems() {
        open(basePage.getURL());
        element(By.xpath(homePage.getProjectButton())).click();
        $$(By.xpath(projectPage.getSponsorBlock())).shouldHave(size(8));
    }

    @Test
    public void checkThatClickingOnMeetUpsButtonLeadToMeetupSite() {
        open(basePage.getURL());
        loggerFactory.info("URL opened");
        element(By.xpath(homePage.getDropdownAbout())).click();
        loggerFactory.info("Dropdown About clicked");
        element(By.xpath(homePage.getEventsFromDropdown())).click();
        loggerFactory.info("Clicked on Event");
        $(By.xpath(eventsPage.getGoTomeetupsButton())).click();
        loggerFactory.info("Go to meetups button clicked");
        assertEquals("https://www.meetup.com/topics/selenium/", WebDriverRunner.getWebDriver().getCurrentUrl());
    }


}
