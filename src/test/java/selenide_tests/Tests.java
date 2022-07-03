package selenide_tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenide_tests.strategy_pattern.*;
import selenide_tests.reporter_utils.ListenerTest;
import selenium_utils.TextExamples;

@Listeners(ListenerTest.class)  //ListenerTest.class
public class Tests {
    private TabContentChecks checks;
    @BeforeTest
    public void initChecks() {
        checks = new TabContentChecks();
    }

    @Test(testName = "cSharp test")
    public void checkCSharp() {
        checks.setContentCheck(new CSharpCodeExampleCheck());
        checks.doCheck(TextExamples.CSHARP_EXAMPLE);
    }

    @Test(testName = "java test")
    public void checkJava() {
        checks.setContentCheck(new JavaCodeExampleCheck());
        checks.doCheck(TextExamples.JAVA_EXAMPLE);
    }

    @Test(testName = "javascript test")
    public void checkJavaScript() {
        checks.setContentCheck(new JavaScriptCodeExampleCheck());
        checks.doCheck(TextExamples.JAVA_SCRIPT_EXAMPLE);
    }

    @Test(testName = "kotlin test")
    public void checkKotlin() {
        checks.setContentCheck(new KotlinCodeExampleCheck());
        checks.doCheck(TextExamples.KOTLIN_EXAMPLE);
    }

    @Test(testName = "python test")
    public void checkPython() {
        checks.setContentCheck(new PythonCodeExampleCheck());
        checks.doCheck(TextExamples.PYTHON_EXAMPLE);
    }

    @Test(testName = "ruby test")
    public void checkRuby() {
        checks.setContentCheck(new RubyCodeExampleCheck());
        checks.doCheck(TextExamples.RUBY_EXAMPLE);
    }
}
