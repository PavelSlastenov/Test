package page_object;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
  String QUESTION_ONE;
  String QUESTION_TWO;
  String QUESTION_THREE;
  String QUESTION_FOUR;
  String QUESTION_FIVE;
  String QUESTION_SIX;
  String QUESTION_SEVEN;
  String QUESTION_EIGHT;

  // Url сервиса для заказа самокатов
  private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

  // Верхняя кнопка "Заказать"
  private static final By ORDER_BUTTON_TOP = By.xpath("(.//button[@class='Button_Button__ra12g'])[1]");

  // Верхняя кнопка "Заказать"
  private static final By ORDER_BUTTON_BOTTOM = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

  // Блок "Вопросы о важном"
  private static final By QUESTION_BUTTON = By.xpath(".//div[@id='accordion__heading-0']/..");

  private WebDriver driver;

  public MainPage(WebDriver driver) {
    this.driver = driver;
  }

  public MainPage open() {
    driver.get(PAGE_URL);
    return this;
  }

  public MainPage clickOrderStatusButtonTop() {
    driver.findElement(ORDER_BUTTON_TOP).click();
    return this;
  }

  public MainPage clickOrderStatusButtonBottom() {
    WebElement element = driver.findElement(ORDER_BUTTON_BOTTOM);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    driver.findElement(ORDER_BUTTON_BOTTOM).click();
    return this;
  }

  public void checkFAQSection(String responseOne, String responseTwo, String responseThree, String responseFour, String responseFive,
                                  String responseSix, String responseSeven, String responseEight) {
    QUESTION_ONE = "Сколько это стоит? И как оплатить?";
    QUESTION_TWO = "Хочу сразу несколько самокатов! Так можно?";
    QUESTION_THREE = "Как рассчитывается время аренды?";
    QUESTION_FOUR = "Можно ли заказать самокат прямо на сегодня?";
    QUESTION_FIVE = "Можно ли продлить заказ или вернуть самокат раньше?";
    QUESTION_SIX = "Вы привозите зарядку вместе с самокатом?";
    QUESTION_SEVEN = "Можно ли отменить заказ?";
    QUESTION_EIGHT = "Я жизу за МКАДом, привезёте?";

    WebElement element = driver.findElement(QUESTION_BUTTON);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    for(int i = 0; i < 8; i++) {
      switch (i) {
        case 1:
          Assert.assertEquals(QUESTION_ONE, driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 0 + "']")).getText());
          driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 0 + "']/..")).click();
          Assert.assertEquals(responseOne, driver.findElement(By.xpath(".//div[@id='accordion__panel-" + 0 + "']/p")).getText());
          break;
        case 2:
          Assert.assertEquals(QUESTION_TWO, driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 1 + "']")).getText());
          driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 1 + "']/..")).click();
          Assert.assertEquals(responseTwo, driver.findElement(By.xpath(".//div[@id='accordion__panel-" + 1 + "']/p")).getText());
          break;
        case 3:
          Assert.assertEquals(QUESTION_THREE, driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 2 + "']")).getText());
          driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 2 + "']/..")).click();
          Assert.assertEquals(responseThree, driver.findElement(By.xpath(".//div[@id='accordion__panel-" + 2 + "']/p")).getText());
          break;
        case 4:
          Assert.assertEquals(QUESTION_FOUR, driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 3 + "']")).getText());
          driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 3 + "']/..")).click();
          Assert.assertEquals(responseFour, driver.findElement(By.xpath(".//div[@id='accordion__panel-" + 3 + "']/p")).getText());
          break;
        case 5:
          Assert.assertEquals(QUESTION_FIVE, driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 4 + "']")).getText());
          driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 4 + "']/..")).click();
          Assert.assertEquals(responseFive, driver.findElement(By.xpath(".//div[@id='accordion__panel-" + 4 + "']/p")).getText());
          break;
        case 6:
          Assert.assertEquals(QUESTION_SIX, driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 5 + "']")).getText());
          driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 5 + "']/..")).click();
          Assert.assertEquals(responseSix, driver.findElement(By.xpath(".//div[@id='accordion__panel-" + 5 + "']/p")).getText());
          break;
        case 7:
          Assert.assertEquals(QUESTION_SEVEN, driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 6 + "']")).getText());
          driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 6 + "']/..")).click();
          Assert.assertEquals(responseSeven, driver.findElement(By.xpath(".//div[@id='accordion__panel-" + 6 + "']/p")).getText());
          break;
        case 8:
          Assert.assertEquals(QUESTION_EIGHT, driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 7 + "']")).getText());
          driver.findElement(By.xpath(".//div[@id='accordion__heading-" + 7 + "']/..")).click();
          Assert.assertEquals(responseEight, driver.findElement(By.xpath(".//div[@id='accordion__panel-" + 7 + "']/p")).getText());
          break;
        default:
          break;
      }
    }
  }
}
