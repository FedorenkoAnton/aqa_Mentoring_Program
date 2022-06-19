package selenide_tests.decorator_pattern;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckExamplesRunner {
    private Check check;
    @BeforeTest
    public void init() {
        check = new CSharpCheckAndMessage(new CSharpCheck());
    }
    @Test(testName = "decorator pattern runner")
    public void check() {
        check.makeCheck();
    }
}
