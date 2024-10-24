package HomeWork_2.ru.appline;

import extension.DriverExtension;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.ibs.appline.steps.LoginPageSteps;
import java.util.List;
import java.util.Properties;

import static ru.ibs.appline.properties.TestProps.getInstance;

@ExtendWith(DriverExtension.class)
public class ApplineTest {
    private LoginPageSteps loginSteps = new LoginPageSteps();
    private final Properties properties = getInstance().getProperties();

    @Test
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
                .checkErrorMessage("Список командируемых сотрудников не может быть пустым");
    }
}

