import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_object.MainPage;
import page_object.OrderPage;

public class WebTest {

  private static final By ORDER_BUTTON = By.cssSelector("button.Header_Link__1TAG7");
  public static final By INPUT_FIELD_ORDER_NUMBER =
      By.xpath(".//input[@type='text' and @class=\"Input_Input__1iN_Z Header_Input__xIoUq\"]");
  public static final By ORDER_SUBMIT_BUTTON = By.xpath(".//button[text()=\"Go!\"]");
  public static final By NOT_FOUND_IMAGE = By.cssSelector("div.Track_NotFound__6oaoY > img");
  public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
  public static final String WRONG_ORDER_NUMBER = "903457984aaa";
  public static final Duration LONG_WAIT = Duration.ofSeconds(20);
  public static final Duration SHORT_WAIT = Duration.ofSeconds(3);
  private WebDriver driver;

  @Before
  public void before() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(chromeOptions);
  }

  @Test
  public void checkOrderButtonTop() {
    MainPage mainPage = new MainPage(driver);
    OrderPage orderPage = new OrderPage(driver);
    mainPage.open();
    mainPage.clickOrderStatusButtonTop();
    orderPage.isOrderDataHeaderVisible();
  }

  @Test
  public void checkOrderButtonBottom() {
    MainPage mainPage = new MainPage(driver);
    OrderPage orderPage = new OrderPage(driver);
    mainPage.open();
    mainPage.clickOrderStatusButtonBottom();
    orderPage.isOrderDataHeaderVisible();
  }

  /// ------------------------------------------------------------------//
//  @Test
//  public void checkOrder_nonExisting_notFound() {
//    driver.get(PAGE_URL);
//    driver.findElement(ORDER_BUTTON).click();
//    WebElement inputField = driver.findElement(INPUT_FIELD_ORDER_NUMBER);
//    inputField.clear();
//    inputField.sendKeys(WRONG_ORDER_NUMBER);
//    driver.findElement(ORDER_SUBMIT_BUTTON).click();
//    boolean isDisplayed = driver.findElement(NOT_FOUND_IMAGE).isDisplayed();
//    assertTrue(isDisplayed);
//  }
//
//  @Test
//  public void checkOrder_implicitWaits_notFound() {
//    driver.manage().timeouts().implicitlyWait(LONG_WAIT);
//    driver.get(PAGE_URL);
//    driver.findElement(ORDER_BUTTON).click();
//    WebElement element = driver.findElement(INPUT_FIELD_ORDER_NUMBER);
//    element.clear();
//    element.sendKeys(WRONG_ORDER_NUMBER);
//    driver.findElement(ORDER_SUBMIT_BUTTON).click();
//    boolean isDisplayed = driver.findElement(NOT_FOUND_IMAGE).isDisplayed();
//    assertTrue(isDisplayed);
//  }
//
//  @Test
//  public void checkOrder_explicitWaits_notFound() {
//    driver.get(PAGE_URL);
//    driver.findElement(ORDER_BUTTON).click();
//
//    WebElement element =
//        new WebDriverWait(driver, SHORT_WAIT)
//            .until(ExpectedConditions.visibilityOfElementLocated(INPUT_FIELD_ORDER_NUMBER));
//    element.clear();
//    element.sendKeys(WRONG_ORDER_NUMBER);
//    driver.findElement(ORDER_SUBMIT_BUTTON).click();
//
//    new WebDriverWait(driver, SHORT_WAIT)
//        .until(ExpectedConditions.visibilityOfElementLocated(NOT_FOUND_IMAGE));
//    boolean isDisplayed = driver.findElement(NOT_FOUND_IMAGE).isDisplayed();
//    assertTrue(isDisplayed);
//  }
//
//  @Test
//  public void checkOrder_pom() {
//    MainPage page = new MainPage(driver);
//    page.open();
//    page.clickCheckOrderStatusButton();
//    page.enterOrderNumber(WRONG_ORDER_NUMBER);
//    assertTrue(page.isImageNotFoundVisible());
//  }
//
//  @Test
//  public void checkOrder_fluentApi() {
//    boolean isImageVisible =
//        new MainPage(driver)
//            .open()
//            .clickCheckOrderStatusButton()
//            .enterOrderNumber(WRONG_ORDER_NUMBER)
//            .isImageNotFoundVisible();
//    assertTrue(isImageVisible);
//  }

  @After
  public void after() {
    driver.quit();
  }
}
