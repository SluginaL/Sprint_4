package scooterSiteTest;

import main.BrowserRule;
        import org.junit.Assert;
        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.junit.runners.Parameterized;
import pom.MainPage;
        import pom.OrderPage;


@RunWith(Parameterized.class)
public class CreateOrderPositiveTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    public CreateOrderPositiveTest(String orderButton, String firstName, String lastName, String address, String metro, int metroElement, String phoneNumber, int dateElement, int periodElement, String comment) {
        this.orderButton = orderButton;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.metroElement = metroElement;
        this.phoneNumber = phoneNumber;
        this.dateElement = dateElement;
        this.periodElement = periodElement;
        this.comment = comment;
    }


    private final String orderButton;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metro;
    private final int metroElement;
    private final String phoneNumber;
    private final int dateElement;
    private final int periodElement;
    private final String comment;

    @Parameterized.Parameters(name = "Тестовые данные: {0},{1}, {2}, {3}, {4}, {5}, {6},{7}. {8}, {9}")
    public static Object[][] data() {
        return new Object[][] {
                {MainPage.orderButtonUp, "Питер", "Паркер", "20 Инграм Стрит в Форест Хиллз",
                        "преображ", 1, "89889889898", 17, 3, "Замечательный самокат!!!"},
                {MainPage.orderButtonDown, "Гарри", "Поттер", "20 Пушкина дом Колотушкина",
                        "черкиз", 0, "89889889897", 20, 1, "Томное катание по центру нью йорка!!!"},
        };
    }
    @Test
    public void showInfo() {
        System.out.println(data().toString());
    }

    @Test
    public void makeOrder() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
            OrderPage orderPage = new OrderPage(browserRule.getDriver());
        mainPage.open();
        mainPage.makeOrder(orderButton);
        orderPage.completeFirstForm(firstName, lastName, address, metro, metroElement, phoneNumber);
        orderPage.completeSecondForm(dateElement, periodElement, comment);
        Assert.assertTrue("Заказ не оформлен", orderPage.orderIsDone().getText().contains("Заказ оформлен"));
    }


}