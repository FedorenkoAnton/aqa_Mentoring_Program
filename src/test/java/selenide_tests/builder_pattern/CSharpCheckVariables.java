package selenide_tests.builder_pattern;

import pages.DocumentationPage;
import utils.TextExamples;

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
