package HomeWork_2.ru.appline;

import extension.AllureExtension;
import extension.DriverExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.ibs.appline.steps.LoginPageSteps;

import java.util.List;
import java.util.Properties;

import static ru.ibs.appline.managers.TestPropsManager.getInstance;

@DisplayName(value = "Сценарий прогона Appline")
@ExtendWith({AllureExtension.class, DriverExtension.class})
public class ApplineTest {
    private final LoginPageSteps loginSteps = new LoginPageSteps();
    private final Properties properties = getInstance().getProperties();

    @Test
    @Severity(value = SeverityLevel.NORMAL)
    @Description(value = "Тест по созданию командировки и проверки сообщения об ошибке, если не все обязательные поля заполнены")
    @DisplayName("TEST-1 Проверка создания командировки с незаполненым обязательным полем Список командируемых сотрудников")
    public void test1() {
        loginSteps.login(properties.getProperty("login"), properties.getProperty("password"))
                .checkTitle("Панель быстрого запуска")
                .filterByTrip()
                .createTripClick()
                .checkTitle("Создать командировку")
                .selectSubdivision("Отдел внутренней разработки")
                .selectHostOrganization("Академия Тестирования")
                .selectTask("Заказ билетов")
                .selectDepartureCity("Москва")
                .selectArrivalCity("Хабаровск")
                .selectDepartureDatePlan("21.10.2024")
                .selectReturnDatePlan("30.10.2024")
                .checkSubdivision("Отдел внутренней разработки")
                .checkHostOrganization("Академия Тестирования")
                .checkTasksInCheckBox(List.of("Заказ билетов"))
                .checkDepartureCity("Москва")
                .checkArrivalCity("Хабаровск")
                .checkDepartureDatePlan("21.10.2024")
                .checkReturnDatePlan("30.10.2024")
                .saveAndCloseTripClick()
                .checkErrorMessage("Список командируемых сотрудников не может быть пустым")
        ;
    }
}

