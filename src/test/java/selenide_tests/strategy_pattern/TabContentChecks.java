package selenide_tests.strategy_pattern;

import utils.TextExamples;

public class TabContentChecks {
    private ContentCheck contentCheck;

    public void setContentCheck(ContentCheck contentCheck) {
        this.contentCheck = contentCheck;
    }

    public void doCheck(TextExamples examples) {
        contentCheck.checkContent(examples);
    }
}
