package selenide_tests.decorator_pattern;

import selenide_tests.strategy_pattern.JavaCodeExampleCheck;
import utils.TextExamples;

public class CSharpCheckAndMessage extends CheckDecorator {
    public CSharpCheckAndMessage(Check check) {
        super(check);
    }

    private void printMessage() {
        System.out.println("===================================");
        System.out.println("CSHARP TEST");
        System.out.println("===================================");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    @Override
    public void makeCheck() {
        super.makeCheck();
        printMessage();
    }
}
