import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page_object.MainPage;

@RunWith(Parameterized.class)
public class FAQSectionMainPageTest {

  private WebDriver driver;
  private final String responseOne;
  private final String responseTwo;
  private final String responseThree;
  private final String responseFour;
  private final String responseFive;
  private final String responseSix;
  private final String responseSeven;
  private final String responseEight;

  public FAQSectionMainPageTest(String responseOne, String responseTwo, String responseThree, String responseFour, String responseFive,
                             String responseSix, String responseSeven, String responseEight) {
    this.responseOne = responseOne;
    this.responseTwo = responseTwo;
    this.responseThree = responseThree;
    this.responseFour = responseFour;
    this.responseFive = responseFive;
    this.responseSix = responseSix;
    this.responseSeven = responseSeven;
    this.responseEight = responseEight;
  }


  @Parameterized.Parameters
  public static Object[][] getOrderData() {
    return new Object[][] {
            {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                    "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                    "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                    "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                    "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                    "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                    "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                    "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
            },
    };
  }

  @Before
  public void before() {
    driver = new FirefoxDriver();
  }

  @Test
  public void checkFQASection() {
    MainPage mainPage = new MainPage(driver);
    mainPage.open();
    mainPage.checkFAQSection(responseOne, responseTwo, responseThree, responseFour, responseFive,
            responseSix, responseSeven, responseEight);
  }

  @After
  public void after() {
    driver.quit();
  }
}
