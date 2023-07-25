package page_object;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

  // Url сервиса для заказа самокатов
  private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

  // Верхняя кнопка "Заказать"
  private static final By ORDER_BUTTON_TOP = By.xpath(".//button[@class='Button_Button__ra12g']");

  // Верхняя кнопка "Заказать"
  private static final By ORDER_BUTTON_BOTTOM = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


//  private static final By ORDER_BUTTON = By.cssSelector("button.Header_Link__1TAG7");
  public static final Duration SHORT_WAIT = Duration.ofSeconds(3);
  public static final By NOT_FOUND_IMAGE = By.cssSelector("div.Track_NotFound__6oaoY > img");


  public static final By INPUT_FIELD_ORDER_NUMBER =
      By.xpath(".//input[@type='text' and @class=\"Input_Input__1iN_Z Header_Input__xIoUq\"]");
  public static final By ORDER_SUBMIT_BUTTON = By.xpath(".//button[text()=\"Go!\"]");

  private WebDriver driver;

  public MainPage(WebDriver driver) {
    this.driver = driver;
  }

  public MainPage open() {
    driver.get(PAGE_URL);
    return this;
  }

  public MainPage clickOrderStatusButtonTop() {
    driver.findElement(ORDER_BUTTON_BOTTOM).click();
    return this;
  }

  public MainPage clickOrderStatusButtonBottom() {
    driver.findElement(ORDER_BUTTON_TOP).click();
    return this;
  }

  public OrderPage enterOrderNumber(String wrongOrderNumber) {
    WebElement element =
        new WebDriverWait(driver, SHORT_WAIT)
            .until(ExpectedConditions.visibilityOfElementLocated(INPUT_FIELD_ORDER_NUMBER));
    element.clear();
    element.sendKeys(wrongOrderNumber);
    driver.findElement(ORDER_SUBMIT_BUTTON).click();
    return new OrderPage(driver);
  }

  public boolean isImageNotFoundVisible() {
    new WebDriverWait(driver, SHORT_WAIT)
        .until(ExpectedConditions.visibilityOfElementLocated(NOT_FOUND_IMAGE));
    return driver.findElement(NOT_FOUND_IMAGE).isDisplayed();
  }
}
