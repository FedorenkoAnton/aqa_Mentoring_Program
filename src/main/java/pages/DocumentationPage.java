package pages;

public class DocumentationPage extends BasePage {

    private String javaTab = "#tabs-3-0-tab";

    private String pythonTab = "#tabs-3-1-tab";

    private String csharpTab = "#tabs-3-2-tab";

    private String rubyTab = "#tabs-3-3-tab";

    private String javaScriptTab = "#tabs-3-4-tab";

    private String kotlinTab = "#tabs-3-5-tab";

    private String textFromJavaCodeTab = ".tab-content";

    private String textFromPythonCodeTab = ".tab-content";

    private String textFromCSharpTab = "pre>.language-cs";

    private String textFromRubyTab = "code.language-rb";

    private String textFromJavaScriptTab = "code.language-js";

    private String textFromKotlinTab = "code.language-kt";

    public String getJavaTab() {
        return javaTab;
    }

    public String getPythonTab() {
        return pythonTab;
    }

    public String getCsharpTab() {
        return csharpTab;
    }

    public String getRubyTab() {
        return rubyTab;
    }

    public String getJavaScriptTab() {
        return javaScriptTab;
    }

    public String getKotlinTab() {
        return kotlinTab;
    }

    public String getTextFromJavaCodeTab() {
        return textFromJavaCodeTab;
    }

    public String getTextFromPythonCodeTab() {
        return textFromPythonCodeTab;
    }

    public String getTextFromCSharpTab() {
        return textFromCSharpTab;
    }

    public String getTextFromRubyTab() {
        return textFromRubyTab;
    }

    public String getTextFromJavaScriptTab() {
        return textFromJavaScriptTab;
    }

    public String getTextFromKotlinTab() {
        return textFromKotlinTab;
    }
}