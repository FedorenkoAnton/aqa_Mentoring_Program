package selenide_tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium_pages.BasePage;
import selenium_pages.EventsPage;
import selenium_pages.HomePage;
import selenium_pages.ProjectPage;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @BeforeClass
    static void setUp() {

    }

    @BeforeTest
    public void init() {
        basePage = new BasePage();
        homePage = new HomePage();
        projectPage = new ProjectPage();
        eventsPage = new EventsPage();
        loggerFactory = LoggerFactory.getLogger(TestForSelenideTask.class);
        ScreenShooter.captureSuccessfulTests = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Test
    public void checkThatProjectPageHasSeleniumWebDriverBlock() {
        open(basePage.getURL());
        element(By.xpath(homePage.getProjectButton())).click();
        element(By.xpath(projectPage.getSeleniumWebDriverBlock())).should(text("Selenium WebDriver"));
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
        ElementsCollection elements = $$(By.xpath(projectPage.getSponsorBlock()));
        assertEquals(elements.size(), 8);
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
