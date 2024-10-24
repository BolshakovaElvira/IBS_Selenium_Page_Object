package extension;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import static ru.ibs.appline.managers.DriverManager.closeDriver;
import static ru.ibs.appline.managers.DriverManager.getWebDriver;

public class DriverExtension implements BeforeAllCallback, AfterAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        getWebDriver();
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        closeDriver();
    }
}
