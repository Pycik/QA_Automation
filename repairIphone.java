package WebDrive;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;







public class repairIphone {

    private static WebDriver driver;


    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", "C:/Users/SPARK/workspace/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://support.apple.com/");
    }

    @Test
    public void scrollingToBottomofAPage() {

        driver.navigate().to("https://support.apple.com/");
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement element = driver.findElement(By.xpath(".//*[@id='ac-globalfooter']/div/nav[2]/div[1]/div/ul/li[4]/a"));
        element.click();

        //clickRepair
        WebElement startRepair = driver.findElement(By.cssSelector(".as-navLink.button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,startRepair);
        startRepair.click();
    }

//    @Test
//    public void repairPhone() {


//Проскроллить страницу к элементу с помощью Javascript
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
//                ,element);

//Проскроллить страницу из текущего положения с заданным смещением
//        ((JavascriptExecutor)driver).executeScript("window.scrollBy(" + x + ","
//                + y + ");");

//Проскроллить страницу с заданным смещением от элемента
//        public void scrollWithOffset(WebElement webElement, int x, int y) {
//
//            String code = "window.scroll(" + (webElement.getLocation().x + x) + ","
//                    + (webElement.getLocation().y + y) + ");";
//
//            ((JavascriptExecutor)driver).executeScript(code, webElement, x, y);
//
//        }
//    }


    @AfterClass
    public static void Close() {

        driver.quit();
    }
}
