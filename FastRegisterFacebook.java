package WebDrive;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GreatGoogleEmail {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", "C:/Users/SPARK/workspace/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");

    }

    @Test
    public void  register() {
        System.out.println("Page title is: " + driver.getTitle());

        WebElement name = driver.findElement(By.id("u_0_g"));
        name.sendKeys("Russell");

        WebElement lastName = driver.findElement(By.id("u_0_i"));
        lastName.sendKeys("Crove");

        WebElement mail = driver.findElement(By.id("u_0_l"));
        mail.sendKeys("romanokey@bigmir.net");
        WebElement mail2 = driver.findElement(By.id("u_0_o"));
        mail2.sendKeys("romanokey@bigmir.net");

        WebElement pass = driver.findElement(By.id("u_0_s"));
        pass.sendKeys("qZaXwS10");


        WebElement day = driver.findElement(By.id("day"));
        day.click();
        WebElement numberDay = driver.findElement(By.xpath(".//*[@id='day']/option[10]"));
        numberDay.click();

        WebElement month = driver.findElement(By.id("month"));
        month.click();
        WebElement numberMonth = driver.findElement(By.xpath(".//*[@id='month']/option[4]"));
        numberMonth.click();

        WebElement year = driver.findElement(By.id("year"));
        year.click();
        WebElement numberYear = driver.findElement(By.xpath(".//*[@id='year']/option[29]"));
        numberYear.click();

//        WebElement man = driver.findElement(By.id("u_0_4"));
//        man.click();
        WebElement man2 = driver.findElement(By.id("u_0_7"));
        man2.click();


        WebElement greatButton = driver.findElement(By.id("u_0_y"));
        greatButton.click();

        System.out.println("Page title is: " + driver.getTitle());


//       ждем 10 сек пока появиться селектор
//        WebElement dynamicElement = (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='initialView']/div[2]/div[3]/div/div/content[1]")));
//        dynamicElement.click();

    }

    @AfterClass
    public static void Close() {

        driver.quit();
    }
}