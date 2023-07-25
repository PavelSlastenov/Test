import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page_object.MainPage;
import page_object.OrderPage;

public class OrderPageChromeTest {

  private WebDriver driver;

  MainPage mainPage = new MainPage(driver);
  OrderPage orderPage = new OrderPage(driver);

  @Before
  public void before() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(chromeOptions);
  }

  @Test
  public void checkOrderButtonTop() {
    mainPage.open();
    mainPage.clickOrderStatusButtonTop();
    orderPage.isOrderDataHeaderVisible();
  }

  @Test
  public void checkOrderButtonBottom() {
    mainPage.open();
    mainPage.clickOrderStatusButtonBottom();
    orderPage.isOrderDataHeaderVisible();
  }

  @After
  public void after() {
    driver.quit();
  }
}
