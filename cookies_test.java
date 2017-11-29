package cookies;


import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class cookies_test {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", "C:/Users/SPARK/workspace/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get("https://www.olx.ua/");
    }

    @Test
    public  void cookies() {

        WebElement profile = driver.findElement(By.xpath("//*[@id=\"topLoginLink\"]/span"));
        profile.click();

        WebElement name = driver.findElement(By.id("userEmail"));
        name.sendKeys("xxx@gmail.com");

        WebElement pass = driver.findElement(By.id("userPass"));
        pass.sendKeys("xxx");
        pass.submit();


        Set <Cookie> cookies = driver.manage().getCookies();
        System.out.println("Size of Cookies " + cookies.size());

        for (Cookie cookie:cookies)
        {
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }

    }


}
