package selenide_tests.builder_pattern;

import org.openqa.selenium.By;
import selenide_tests.BaseTest;
import utils.TextExamplePaths;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;

public class CodeExampleCheck extends BaseTest {
    private Variables variables;

    public CodeExampleCheck(Variables variables) {
        this.variables = variables;
    }

    public void checkContent() {
        String pathToFile = TextExamplePaths.getFilePath(variables.getPathToFile());
        String textFromFile = getCodeExampleFromFile(pathToFile);

        open(getHomePage().getURL());
        element(By.cssSelector(getHomePage().getDocumentationButton())).click();
        element(By.cssSelector(variables.getLanguageTabLocator())).click();
        element(By.cssSelector(variables.getCodeExampleLocator())).shouldHave(text(textFromFile));
    }
}
