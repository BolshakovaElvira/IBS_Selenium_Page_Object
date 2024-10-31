package extension;


import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ru.ibs.appline.managers.DriverManager.*;

public class AllureExtension implements TestWatcher, AfterAllCallback {

    private final List<TestResultStatus> testResultStatuses = new ArrayList<>();

    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) {

    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        takeScreenshot();
        testResultStatuses.add(TestResultStatus.SUCCESSFUL);
        TestWatcher.super.testSuccessful(context);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        takeScreenshot();
        testResultStatuses.add(TestResultStatus.FAILED);
        TestWatcher.super.testFailed(context, cause);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = ".png")
    public static byte[] takeScreenshot() {

        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
