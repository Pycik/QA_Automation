package cookies;


import org.apache.commons.lang3.time.StopWatch;
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

        //get start time
        long startTime = System.currentTimeMillis();
        System.out.println("Start time: " + startTime);

        WebElement profile = driver.findElement(By.xpath("//*[@id=\"topLoginLink\"]/span"));
        profile.click();

        //get end time
        long endTime = System.currentTimeMillis();
        System.out.println("End time: " + endTime);

        long totalTime = endTime - startTime;
        System.out.println("Total page Load time: " + totalTime);

        WebElement name = driver.findElement(By.id("userEmail"));
        name.sendKeys("pyccok@gmail.com");

        WebElement pass = driver.findElement(By.id("userPass"));
        pass.sendKeys("ghbrjk093");
        pass.submit();

        //Get the StopWatch Object and start the StopWatch

        StopWatch pageLoad = new StopWatch();
        pageLoad.start();

        //Get Cookie

        Set <Cookie> cookies = driver.manage().getCookies();
        System.out.println("Size of Cookies " + cookies.size());

        for (Cookie cookie:cookies)
        {
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }

        //Stop the StopWatch
        pageLoad.stop();
        System.out.println("New Page Load Time: " + pageLoad.getTime() + " milliseconds");

    }


}

//httpwatch.com tool for browser