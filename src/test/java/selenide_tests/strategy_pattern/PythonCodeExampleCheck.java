package selenide_tests.strategy_pattern;

import org.openqa.selenium.By;

import selenide_tests.BaseTest;
import utils.TextExamplePaths;
import utils.TextExamples;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;

public class PythonCodeExampleCheck extends BaseTest implements ContentCheck {

    @Override
    public void checkContent(TextExamples example) {
        String pathToFile = TextExamplePaths.getFilePath(example);
        String textFromFile = getCodeExampleFromFile(pathToFile);

        open(getHomePage().getURL());
        element(By.cssSelector(getHomePage().getDocumentationButton())).click();
        element(By.cssSelector(getDocumentationPage().getPythonTab())).click();
        element(By.cssSelector(getDocumentationPage().getTextFromPythonCodeTab())).shouldHave(text(textFromFile));
    }
}
