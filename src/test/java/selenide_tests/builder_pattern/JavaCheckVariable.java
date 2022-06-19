package selenide_tests.builder_pattern;

import pages.DocumentationPage;
import utils.TextExamples;

public class JavaCheckVariable extends VariableBuilder {
    @Override
    void buildPathToFile() {
        variables.setPathToFile(TextExamples.JAVA_EXAMPLE);
    }

    @Override
    void buildLanguageTabLocator() {
        variables.setLanguageTabLocator(new DocumentationPage().getJavaTab());
    }

    @Override
    void buildCodeExampleLocator() {
        variables.setCodeExampleLocator(new DocumentationPage().getTextFromJavaCodeTab());
    }
}
