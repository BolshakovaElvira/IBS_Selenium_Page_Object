package extension;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static ru.ibs.appline.managers.DriverManager.*;

public class DriverExtension implements BeforeAllCallback, AfterAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) {
        // Получение WebDriver и сохранение его в контексте
        context.getStore(ExtensionContext.Namespace.GLOBAL).put("driver", getWebDriver());
    }

    @Override
    public void afterAll(ExtensionContext context) {
        closeDriver();
    }
}
