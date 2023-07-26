package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

  // Ожидание элемента
  public static final Duration SHORT_WAIT = Duration.ofSeconds(3);

  // Заголовок "Для кого самокат"
  public static final By ORDER_DATA_HEADER = By.xpath("//*[text()='Для кого самокат']");

  // Заголовок "Про аренду"
  public static final By RENTAL_DATA_HEADER = By.xpath("//*[text()='Про аренду']");

  // Поле "Имя"
  public static final By NAME_INPUT = By.xpath(".//input[@placeholder='* Имя']");

  // Поле "Фамилия"
  public static final By SURNAME_INPUT = By.xpath(".//input[@placeholder='* Фамилия']");

  // Поле "Адрес куда привезти"
  public static final By ADDRESS_INPUT = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

  // Поле "Станция метро"
  public static final By STATION_INPUT = By.xpath(".//input[@placeholder='* Станция метро']");

  // Поле "Номер телефона"
  public static final By PHONE_NUMBER_INPUT = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

  // Поле "Когда привезти самокат"
  public static final By DELIVERY_DATE_INPUT = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

  // Поле "Срок аренды"
  public static final By RENTAL_PERIOD_DROPDOWN = By.xpath(".//div[contains(text(), '* Срок аренды')]");

  // Поле "Цвет самоката"
  public static final By COLOR_SCOOTER_IS_BLACK_INPUT = By.xpath(".//input[@id='black']");
  public static final By COLOR_SCOOTER_IS_GREY_INPUT = By.xpath(".//input[@id='grey']");

  // Поле "Комментарий для курьера"
  public static final By COMMENT_INPUT = By.xpath(".//input[@placeholder='Комментарий для курьера']");

  // Кнопка "Далее"
  public static final By NEXT_BUTTON = By.xpath(".//button[text()='Далее']");

  // Кнопка "Заказать"
  public static final By ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

  // Модальное окно "Хотите оформить заказ?"
  public static final By ORDER_MODAL = By.xpath(".//div[contains(text(), 'Хотите оформить заказ?')]");

  // Кнопка подтверждения заказа
  public static final By CONFIRM_BUTTON = By.xpath(".//button[contains(text(), 'Да')]");

  // Модальное окно "Заказ оформлен"
  public static final By HEADER_MODAL_SUCCESS_BUTTON = By.xpath(".//div[contains(text(), 'Заказ оформлен')]");


  private WebDriver driver;
  public OrderPage(WebDriver driver) {
    this.driver = driver;
  }

  public boolean isOrderDataHeaderVisible() {
    new WebDriverWait(driver, SHORT_WAIT)
        .until(ExpectedConditions.visibilityOfElementLocated(ORDER_DATA_HEADER));
    return driver.findElement(ORDER_DATA_HEADER).isDisplayed();
  }

  public boolean isRentalOrderDataVisible() {
    new WebDriverWait(driver, SHORT_WAIT)
            .until(ExpectedConditions.visibilityOfElementLocated(RENTAL_DATA_HEADER));
    return driver.findElement(RENTAL_DATA_HEADER).isDisplayed();
  }

  public void inputName(String name) {
    driver.findElement(NAME_INPUT).click();
    driver.findElement(NAME_INPUT).sendKeys(name);
  }

  public void inputSurname(String surname) {
    driver.findElement(SURNAME_INPUT).click();
    driver.findElement(SURNAME_INPUT).sendKeys(surname);
  }

  public void inputAddress(String address) {
    driver.findElement(ADDRESS_INPUT).click();
    driver.findElement(ADDRESS_INPUT).sendKeys(address);
  }

  public void inputStation(String station) {
    driver.findElement(STATION_INPUT).click();
    driver.findElement(STATION_INPUT).sendKeys(station);
    driver.findElement(STATION_INPUT).sendKeys(Keys.DOWN, Keys.ENTER);
  }

  public void inputPhoneNumber(String number) {
    driver.findElement(PHONE_NUMBER_INPUT).click();
    driver.findElement(PHONE_NUMBER_INPUT).sendKeys(number);
  }

  public void inputDeliveryDate(String date) {
    driver.findElement(DELIVERY_DATE_INPUT).click();
    driver.findElement(DELIVERY_DATE_INPUT).sendKeys(date);
    driver.findElement(DELIVERY_DATE_INPUT).sendKeys(Keys.ENTER);
  }

  public void inputRentalPeriod(String rental) {
    driver.findElement(RENTAL_PERIOD_DROPDOWN).click();
    driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div[contains(text(), '" + rental + "')]")).click();
  }

  public void clickColorScooter(String colour) {
    driver.findElement(By.xpath(".//input[@id='" + colour + "']")).click();
  }

  public void inputComment(String comment) {
    driver.findElement(COMMENT_INPUT).click();
    driver.findElement(COMMENT_INPUT).sendKeys(comment);
  }

  public void clickNextButton() {
    driver.findElement(NEXT_BUTTON).click();
  }

  public void clickOrderButton() {
    driver.findElement(ORDER_BUTTON).click();
  }

  public boolean isOrderModalVisible() {
    new WebDriverWait(driver, SHORT_WAIT)
            .until(ExpectedConditions.visibilityOfElementLocated(ORDER_MODAL));
    return driver.findElement(ORDER_MODAL).isDisplayed();
  }

  public void clickConfirmButton() {
    driver.findElement(CONFIRM_BUTTON).click();
  }

  public boolean isStatusModalSuccessVisible() {
    new WebDriverWait(driver, SHORT_WAIT)
            .until(ExpectedConditions.visibilityOfElementLocated(HEADER_MODAL_SUCCESS_BUTTON));
    return driver.findElement(HEADER_MODAL_SUCCESS_BUTTON).isDisplayed();
  }
}
