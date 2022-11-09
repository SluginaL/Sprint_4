package orderstatus;

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
    public void checkAnswerDayForHundred() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        String actualText = mainPage
                .open()
                .scrollPageToBottom()
                .getActualText(mainQuestionsFAQ, mainAnswerFAQ);
        Assert.assertEquals("Текст: " + actualText + " Не соответствует ожидаемому: " + mainRealTextAnswerFAQ,
                mainRealTextAnswerFAQ, actualText);
    }
    @Parameterized.Parameters
    public static Object[][] getDescription() {
        return new Object[][]{
                {MainPage.questionsFAQ1, MainPage.answerFAQ1, MainPage.realTextAnswerFAQ1},
                {MainPage.questionsFAQ2, MainPage.answerFAQ2, MainPage.realTextAnswerFAQ2},
                {MainPage.questionsFAQ3, MainPage.answerFAQ3, MainPage.realTextAnswerFAQ3},
                {MainPage.questionsFAQ4, MainPage.answerFAQ4, MainPage.realTextAnswerFAQ4},
                {MainPage.questionsFAQ5, MainPage.answerFAQ5, MainPage.realTextAnswerFAQ5},
                {MainPage.questionsFAQ6, MainPage.answerFAQ6, MainPage.realTextAnswerFAQ6},
                {MainPage.questionsFAQ7, MainPage.answerFAQ7, MainPage.realTextAnswerFAQ7},
                {MainPage.questionsFAQ8, MainPage.answerFAQ8, MainPage.realTextAnswerFAQ8},
        };


    }
}