package scooterSiteTest;

import main.BrowserRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pom.MainPage;

@RunWith(Parameterized.class)
public class CheckAccordion {

    private final By mainQuestionsFAQ;
    private final By mainAnswerFAQ;
    private final String mainRealTextAnswerFAQ;

    public CheckAccordion(By mainQuestionsFAQ, By mainAnswerFAQ, String mainRealTextAnswerFAQ) {
        this.mainQuestionsFAQ = mainQuestionsFAQ;
        this.mainAnswerFAQ = mainAnswerFAQ;
        this.mainRealTextAnswerFAQ = mainRealTextAnswerFAQ;
    }

    @Rule
    public BrowserRule browserRule = new BrowserRule();
    @Test
    public void showInfo() {
        System.out.println(getDescription().toString());
    }
    @Test
    public void checkAnswerDayForHundred() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        String actualText = mainPage
                .open()
                .scrollPageToBottom()
                .getActualText(mainQuestionsFAQ, mainAnswerFAQ);
        Assert.assertEquals("Текст: " + actualText + " Не соответствует ожидаемому: " + mainRealTextAnswerFAQ,
                mainRealTextAnswerFAQ, actualText);
    }
    @Parameterized.Parameters(name = "Тестовые данные: {0},{1}, {2}")
    public static Object[][] getDescription() {
        return new Object[][]{
                {MainPage.questionsFAQWhatPrice, MainPage.answerFAQPrice, MainPage.realTextAnswerFAQPrice},
                {MainPage.questionsFAQWantSomeScooter, MainPage.answerFAQSomeScooter, MainPage.realTextAnswerFAQSomeScooter},
                {MainPage.questionsFAQCalculateRentTime, MainPage.answerFAQRentTime, MainPage.realTextAnswerFAQRentTime},
                {MainPage.questionsFAQRentToday, MainPage.answerFAQRentToday, MainPage.realTextAnswerFAQRentToday},
                {MainPage.questionsFAQProlongation, MainPage.answerFAQProlongation, MainPage.realTextAnswerFAQProlongation},
                {MainPage.questionsFAQEnergy, MainPage.answerFAQEnergy, MainPage.realTextAnswerFAQEnergy},
                {MainPage.questionsFAQOrderCancellation, MainPage.answerFAQOrderCancellation, MainPage.realTextAnswerFAQOrderCancellation},
                {MainPage.questionsFAQDeliveryToMCAD, MainPage.answerFAQDeliveryToMCAD, MainPage.realTextAnswerFAQDeliveryToMCAD},
        };


    }
}