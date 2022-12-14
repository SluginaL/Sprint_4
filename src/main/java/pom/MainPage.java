package pom;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@RunWith(Parameterized.class)
public class MainPage {

    private static final String url = "https://qa-scooter.praktikum-services.ru/";

    // Кнопка "Заказать" в хэдэре
    public final static By orderButtonHeader = By.xpath(".//div[contains(@class,'Header_Nav__AGCXC')]" +
            "/button[contains(text(),'Заказать')]");

    // FAQ questions
    public final static By questionsFAQWhatPrice = By.id("accordion__heading-0");
    public final static By questionsFAQWantSomeScooter = By.id("accordion__heading-1");
    public final static By questionsFAQCalculateRentTime = By.id("accordion__heading-2");
    public final static By questionsFAQRentToday = By.id("accordion__heading-3");
    public final static By questionsFAQProlongation = By.id("accordion__heading-4");
    public final static By questionsFAQEnergy = By.id("accordion__heading-5");
    public final static By questionsFAQOrderCancellation = By.id("accordion__heading-6");
    public final static By questionsFAQDeliveryToMCAD = By.id("accordion__heading-7");

    //FAQ answers
    public final static By answerFAQPrice = By.xpath(".//div[contains(@class,'accordion__panel')]/" +
            "p[contains(text(),'Сутки')]");
    public final static By answerFAQSomeScooter = By.xpath(".//div[contains(@class,'accordion__panel')]/" +
            "p[contains(text(),'Пока что у нас')]");
    public final static By answerFAQRentTime = By.xpath(".//div[contains(@class,'accordion__panel')]/" +
            "p[contains(text(),'Допустим')]");
    public final static By answerFAQRentToday = By.xpath(".//div[contains(@class,'accordion__panel')]/" +
            "p[contains(text(),'Только начиная ')]");
    public final static By answerFAQProlongation = By.xpath(".//div[contains(@class,'accordion__panel')]/" +
            "p[contains(text(),'Пока что нет')]");
    public final static By answerFAQEnergy = By.xpath(".//div[contains(@class,'accordion__panel')]/" +
            "p[contains(text(),'Самокат приезжает')]");
    public final static By answerFAQOrderCancellation = By.xpath(".//div[contains(@class,'accordion__panel')]/" +
            "p[contains(text(),'Да, пока самокат')]");
    public final static By answerFAQDeliveryToMCAD = By.xpath(".//div[contains(@class,'accordion__panel')]/" +
            "p[contains(text(),'Да, обязательно. ')]");

    //FAQ answers  text
    public final static String realTextAnswerFAQPrice = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public final static String realTextAnswerFAQSomeScooter = "Пока что у нас так: один заказ — один самокат. " +
            "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public final static String realTextAnswerFAQRentTime = "Допустим, вы оформляете заказ на 8 мая. " +
            "Мы привозим самокат 8 мая в течение дня." +
            " Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру." +
            " Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public final static String realTextAnswerFAQRentToday = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public final static String realTextAnswerFAQProlongation = "Пока что нет!" +
            " Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public final static String realTextAnswerFAQEnergy = "Самокат приезжает к вам с полной зарядкой." +
            " Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public final static String realTextAnswerFAQOrderCancellation = "Да, пока самокат не привезли. Штрафа не будет," +
            " объяснительной записки тоже не попросим. Все же свои.";
    public final static String realTextAnswerFAQDeliveryToMCAD = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    private final static By orderStatusButton = By.xpath(".//button[@class='Header_Link__1TAG7']");
    private final static By inputOrder = By.xpath(".//div[contains(@class,'Input_InputContainer__3NykH')]/" +
            "input[contains(@placeholder,'Введите')]");
    private final static By goButton = By.xpath(".//button[contains(text(),'Go')]");

    // Кнопка «Статус заказа»
    String orderStatus = ".Header_Link__1TAG7";

    // Кнопка заказать
    public static String orderButtonUp = ".Header_Nav__AGCXC :first-child";
    public static String orderButtonDown = ".Button_Button__ra12g.Button_Middle__1CSJM";

    // Клик по кнопке Заказать
    public void makeOrder(String orderButton) {
        WebElement element = driver.findElement(By.cssSelector(orderButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public String getActualText(By accordionElement, By elementWithActualText){
        driver.findElement(accordionElement).click();
        return  driver.findElement(elementWithActualText).getText();
    }
    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(url);
        return this;
    }

    public MainPage clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
        return this;
    }

    public MainPage clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
        return this;
    }

    public MainPage inputOrder(String text) {
        driver.findElement(inputOrder).sendKeys(text);
        return this;
    }

    public MainPage clickGoButton() {
        driver.findElement(goButton).click();
        return this;
    }

    public MainPage scrollPageToBottom() {
        executeJS("window.scrollTo(0, document.body.clientHeight);");
        return this;
    }

    public void executeJS(String js) {
        ((JavascriptExecutor) driver).executeScript(js);
    }

    public NotFoundPage notFoundPage() {
        return new NotFoundPage(driver);
    }
}
