package selenide_tests.reporter_utils;

import lombok.SneakyThrows;
import selenide_tests.reporter_utils.testrail_utils.APIClient;

import java.util.HashMap;
import java.util.Map;

public class TestRailUtils {
    @SneakyThrows(Exception.class)
    public static void sendReportToTestRail(String text) {
        Map data = new HashMap();
        String message = String.format("%s filed", text);
        APIClient client = new APIClient("https://autoteststraining.testrail.io/");
        client.setUser("hereonearth692@gmail.com");
        client.setPassword("1hVW0F56avbDCrNltWWg");

        data.put("status_id", 5);
        data.put("comment", message);

        client.sendPost("add_result_for_case/17/2014", data);
    }
}
