package selenide_tests.reporter_utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        SlackUtils.sendMessage(result.getName());
        TestRailUtils.sendReportToTestRail(result.getName());
    }
}
