package selenide_tests.decorator_pattern;

import selenide_tests.strategy_pattern.CSharpCodeExampleCheck;
import utils.TextExamples;

public class CSharpCheck implements Check {
    @Override
    public void makeCheck() {
        new CSharpCodeExampleCheck().checkContent(TextExamples.CSHARP_EXAMPLE);
    }
}
