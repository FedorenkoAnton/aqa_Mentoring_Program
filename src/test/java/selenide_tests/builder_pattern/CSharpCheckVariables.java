package selenide_tests.builder_pattern;

import selenium_pages.DocumentationPage;
import selenium_utils.TextExamples;

public class CSharpCheckVariables extends VariableBuilder {
    @Override
    void buildPathToFile() {
        variables.setPathToFile(TextExamples.CSHARP_EXAMPLE);
    }

    @Override
    void buildLanguageTabLocator() {
        variables.setLanguageTabLocator(new DocumentationPage().getCsharpTab());
    }

    @Override
    void buildCodeExampleLocator() {
        variables.setCodeExampleLocator(new DocumentationPage().getTextFromCSharpTab());
    }
}
