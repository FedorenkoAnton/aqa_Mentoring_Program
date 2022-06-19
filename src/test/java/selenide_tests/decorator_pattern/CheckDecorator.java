package selenide_tests.decorator_pattern;

import selenide_tests.builder_pattern.JavaCheckVariable;
import selenide_tests.strategy_pattern.JavaCodeExampleCheck;
import utils.TextExamples;

public class CheckDecorator implements Check {
    Check check;

    public CheckDecorator(Check check) {
        this.check = check;
    }

    @Override
    public void makeCheck() {
        check.makeCheck();
    }

}
