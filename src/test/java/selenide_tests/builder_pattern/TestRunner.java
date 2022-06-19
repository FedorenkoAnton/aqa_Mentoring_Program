package selenide_tests.builder_pattern;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRunner {
    private Variables cSharpVariables;
    private Variables javaVariables;
    @BeforeTest
    public void initChecks() {
        Director director = new Director();
        director.setBuilder(new CSharpCheckVariables());
        cSharpVariables = director.buildVariablesObj();

        director.setBuilder(new JavaCheckVariable());
        javaVariables = director.buildVariablesObj();
    }

    @Test(testName = "CSharp check") // intentionally failed
    public void checkCSharp() {
        new CodeExampleCheck(cSharpVariables).checkContent();
    }

    @Test(testName = "Java check")
    public void checkJava() {
        new CodeExampleCheck(javaVariables).checkContent();
    }

}
