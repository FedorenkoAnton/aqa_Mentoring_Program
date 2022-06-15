package selenide_tests.reporter_utils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.squareup.okhttp.*;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;

public class SlackUtils {
    private static final String WEBHOOK_URL = "https://hooks.slack.com/services/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";
    private static final File JSON_PATTERN = new File("src/main/resources/message_body.json");
    private static final String MESSAGE_TEXT_PATH = "$.text";

    @SneakyThrows(IOException.class)
    private static RequestBody getRequestBody(String testName) {
        String message = String.format("%s failed", testName);
        DocumentContext context = JsonPath.parse(JSON_PATTERN);
        context.set(MESSAGE_TEXT_PATH, message);
        System.out.println(context.jsonString());
        return RequestBody.create(MediaType.parse("application/json"), context.jsonString());
    }

    @SneakyThrows(IOException.class)
    public static void sendMessage(String testName) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = getRequestBody(testName);

        Request request = new Request.Builder()
                .url(WEBHOOK_URL)
                .header("Content-Type", "application/json")
                .post(body)
                .build();

        Call call = client.newCall(request);
        call.execute();
    }
}
