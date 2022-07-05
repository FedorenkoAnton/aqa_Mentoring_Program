package selenide_tests.strategy_pattern;

import org.openqa.selenium.By;

import org.testng.Reporter;
import selenide_tests.BaseTest;
import utils.TextExamplePaths;
import utils.TextExamples;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CSharpCodeExampleCheck extends BaseTest implements ContentCheck {
    Reporter reporter = new Reporter();

    @Override
    public void checkContent(TextExamples example) {
        String pathToFile = TextExamplePaths.getFilePath(example);
        String textFromFile = getCodeExampleFromFile(pathToFile);

        open(getHomePage().getURL());
        element(By.cssSelector(getHomePage().getDocumentationButton())).click();
        element(By.cssSelector(getDocumentationPage().getCsharpTab())).click();
        element(By.cssSelector(getDocumentationPage().getTextFromCSharpTab())).shouldHave(text(textFromFile));
    }
}
