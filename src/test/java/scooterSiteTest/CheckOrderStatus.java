package scooterSiteTest;

import org.junit.*;
import main.BrowserRule;
import pom.MainPage;

public class CheckOrderStatus {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    private String orderNumber = "1111";


    @Test
    public void notFoundShowWhenNoExsistingOrdersStatus() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage
                .open()
                .clickOrderStatusButton()
                .inputOrder(orderNumber)
                .clickGoButton();

        Assert.assertTrue(mainPage.notFoundPage().isNotFoundImage());

    }


}