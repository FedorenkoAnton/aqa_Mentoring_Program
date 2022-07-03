package selenide_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import selenium_pages.DocumentationPage;
import selenium_pages.HomePage;

public class BaseTest {
    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void initializeDriver() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void shutDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return PageFactory.initElements(getDriver(), HomePage.class);
    }

    public DocumentationPage getDocumentationPage() {
        return PageFactory.initElements(getDriver(), DocumentationPage.class);
    }

    protected String getCodeExampleFromFile(String fileName) {
        String text = "";
        BufferedReader reader;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString().trim();
    }

}
