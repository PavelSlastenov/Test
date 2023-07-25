package page_object;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

  // Кнопка "Далее"
  public static final By NEXT_BUTTON_BUTTON = By.xpath(".//button[text()='Далее']");

  // Поле "Когда привезти самокат"
  public static final By DELIVERY_DATE_INPUT = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

  // Поле "Срок аренды"
  public static final By RENTAL_PERIOD_INPUT = By.xpath(".//input[@placeholder='* Срок аренды']");

  // Поле "Цвет самоката"
  public static final By COLOR_SCOOTER_IS_BLACK_INPUT = By.xpath(".//input[@id='black']");
  public static final By COLOR_SCOOTER_IS_GREY_INPUT = By.xpath(".//input[@id='grey']");



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
}
