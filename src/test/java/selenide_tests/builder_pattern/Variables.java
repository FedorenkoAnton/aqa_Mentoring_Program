package selenide_tests.builder_pattern;

import utils.TextExamples;

public class Variables {
    private TextExamples pathToFile;
    private String languageTabLocator;
    private String codeExampleLocator;

    public void setPathToFile(TextExamples pathToFile) {
        this.pathToFile = pathToFile;
    }

    public void setLanguageTabLocator(String languageTabLocator) {
        this.languageTabLocator = languageTabLocator;
    }

    public void setCodeExampleLocator(String codeExampleLocator) {
        this.codeExampleLocator = codeExampleLocator;
    }

    public TextExamples getPathToFile() {
        return pathToFile;
    }

    public String getLanguageTabLocator() {
        return languageTabLocator;
    }

    public String getCodeExampleLocator() {
        return codeExampleLocator;
    }
}
