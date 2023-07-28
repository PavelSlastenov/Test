import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page_object.MainPage;
import page_object.OrderPage;


@RunWith(Parameterized.class)
public class OrderPageChromeTest {

  private WebDriver driver;
  private final String name;
  private final String surname;
  private final String address;
  private final String station;
  private final String number;
  private final String date;
  private final String rental;
  private final String colour;
  private final String comment;


  public OrderPageChromeTest(String name, String surname, String address, String station, String number,
                             String date, String rental, String colour, String comment) {
    this.name = name;
    this.surname = surname;
    this.address = address;
    this.station = station;
    this.number = number;
    this.date = date;
    this.rental = rental;
    this.colour = colour;
    this.comment = comment;
  }

  @Parameterized.Parameters
  public static Object[][] getOrderData() {
    return new Object[][] {
            {"Петя", "Смирнов", "Самара", "Черкизовская", "79653456789", "28.07.2923", "сутки", "black", "Спасибо"},
            {"Иван", "Иванов", "Коломна", "Партизанская", "89652345678", "29.07.2923", "двое суток", "grey", "Очень быстро"},
    };
  }

  @Before
  public void before() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(chromeOptions);
  }

  @Test
  public void checkOrder() {
    MainPage mainPage = new MainPage(driver);
    OrderPage orderPage = new OrderPage(driver);

    mainPage.open();
    mainPage.clickOrderStatusButtonTop();
    orderPage.isOrderDataHeaderVisible();
    orderPage.inputName(name);
    orderPage.inputSurname(surname);
    orderPage.inputAddress(address);
    orderPage.inputStation(station);
    orderPage.inputPhoneNumber(number);
    orderPage.clickNextButton();
    orderPage.isRentalOrderDataVisible();
    orderPage.inputDeliveryDate(date);
    orderPage.inputRentalPeriod(rental);
    orderPage.clickColorScooter(colour);
    orderPage.inputComment(comment);
    orderPage.clickOrderButton();
    orderPage.isOrderModalVisible();
    orderPage.clickConfirmButton();
    orderPage.isStatusModalSuccessVisible();
  }

  @After
  public void after() {
    driver.quit();
  }
}
