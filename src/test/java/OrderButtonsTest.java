import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page_object.MainPage;
import page_object.OrderPage;

public class OrderButtonsTest {

  private WebDriver driver;

    @Before
    public void before() {
        driver = new FirefoxDriver();
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

    @After
    public void after() {
        driver.quit();
    }
}
