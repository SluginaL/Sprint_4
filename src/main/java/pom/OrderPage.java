package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private  WebDriver driver;


    public OrderPage(WebDriver driver){
        this.driver = driver;

    }

    //кнопка Далее
    private By nextButton = By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\" " +
            "and (text()=\"Далее\")]");

    //кнопка Заказать
    private By makeOrderButton = By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\" " +
            "and (text()=\"Заказать\")]");

    //кнопка подтверждения заказа (Да)
    private By orderConfirmation = By.xpath("//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\" " +
            "and (text()=\"Да\")]");

    //поле Имя
    private By firsName = By.xpath("//input[@placeholder=\"* Имя\"]");

    //поле Фамилия
    private By lastName = By.xpath("//input[@placeholder=\"* Фамилия\"]");

    //поле Адрес
    private By address = By.xpath("//input[@placeholder=\"* Адрес: куда привезти заказ\"]");

    //поле Станция метро
    private By metro = By.xpath("//input[@placeholder=\"* Станция метро\"]");

    //подсказки станций метро
    private By metroSuggestions = By.xpath("//div[@class=\"select-search__select\"]/ul/li");

    //поле Телефон
    private By phoneNumber = By.xpath("//input[@placeholder=\"* Телефон: на него позвонит курьер\"]");

    //календарь
    private By deliveryDates = By.xpath("//input[@placeholder=\"* Когда привезти самокат\"]");

    //даты
    private By week = By.xpath("//div[@class=\"react-datepicker__week\"]/div");

    //поле срок аренды
    private By rentalPeriod = By.xpath("//div[@class=\"Dropdown-control\"]");

    //варианты сроков аренды
    private By periodVariants = By.xpath("//div[@class=\"Dropdown-menu\"]/div");

    //черный цвет
    private By color = By.xpath("//input[@id=\"black\"]");

    //поле комментарий для курьера
    private By commentForCourier = By.xpath("//input[@placeholder=\"Комментарий для курьера\"]");

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void clickMakeOrderButton() {
        driver.findElement(makeOrderButton).click();
    }

    public void clickOrderConfirmationButton() {
        driver.findElement(orderConfirmation).click();
    }

    public void enterFirstName(String fName) {
        driver.findElement(firsName).sendKeys(fName);
    }

    public void enterLastName(String lName) {
        driver.findElement(lastName).sendKeys(lName);
    }

    public void enterAddress(String adress) {
        driver.findElement(address).sendKeys(adress);
    }

    public void enterMetroStation(String station) {
        driver.findElement(metro).sendKeys(station);
    }

    public void selectMetroStation(int element) {
        driver.findElements(metroSuggestions).get(0).click();
    }

    public void enterPhoneNumber(String number) {
        driver.findElement(phoneNumber).sendKeys(number);
    }

    public void deliveryDatesClick() {
        driver.findElement(deliveryDates).click();
    }

    public void selectDeliveryDate(int dateElement) {
        driver.findElements(week).get(dateElement).click();
    }

    public void rentalPeriodClick() {
        driver.findElement(rentalPeriod).click();
    }

    public void selectPeriod(int periodElement) {
        driver.findElements(periodVariants).get(periodElement).click();
    }

    public void selectColor() {
        driver.findElement(color).click();
    }

    public void comments(String comment) {
        driver.findElement(commentForCourier).sendKeys(comment);
    }

    public void completeFirstForm(String firstName, String lastName, String address, String metro, int metroElement,String phoneNumber){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddress(address);
        enterMetroStation(metro);
        selectMetroStation(metroElement);
        enterPhoneNumber(phoneNumber);
        clickNextButton();
    }

    public void completeSecondForm(int dateElement, int periodElement, String comment){
        deliveryDatesClick();
        selectDeliveryDate(dateElement);
        rentalPeriodClick();
        selectPeriod(periodElement);
        selectColor();
        comments(comment);
        clickMakeOrderButton();
        clickOrderConfirmationButton();
    }

    public WebElement orderIsDone() {
        return driver.findElement(By.xpath("//div[@class=\"Order_ModalHeader__3FDaJ\"]"));
    }

    public void closeBrowser() {
        driver.quit();
    }
}
