package selenide_tests.strategy_pattern;

import org.openqa.selenium.By;

import selenide_tests.BaseTest;
import selenium_utils.TextExamplePaths;
import selenium_utils.TextExamples;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class KotlinCodeExampleCheck extends BaseTest implements ContentCheck {

    @Override
    public void checkContent(TextExamples example) {
        String pathToFile = TextExamplePaths.getFilePath(example);
        String textFromFile = getCodeExampleFromFile(pathToFile);

        open(getHomePage().getURL());
        element(By.cssSelector(getHomePage().getDocumentationButton())).click();
        element(By.cssSelector(getDocumentationPage().getKotlinTab())).click();
        element(By.cssSelector(getDocumentationPage().getTextFromKotlinTab())).shouldHave(text(textFromFile));
    }
}
