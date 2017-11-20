package SMS;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Send_SMS {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", "C:/Users/SPARK/workspace/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get("https://sms-fly.ua/");
    }

    @Test
    public  void SMS() {

        WebElement authorization = driver.findElement(By.className("main-links-buttons"));
       authorization.click();

        WebElement login = driver.findElement(By.className("auth_user_name"));
        login.sendKeys("937501674");

        WebElement password = driver.findElement(By.className("auth_user_pwd"));
        password.sendKeys("ghbrjkbcnbr");

        WebElement go = driver.findElement(By.xpath("//button[contains(@class,'submit_button')]"));
        go.click();

        WebElement oneSms = driver.findElement(By.className("main-left-menu"));
        oneSms.click();

        // Добавить номер телефона в контакты

//        WebElement addContacts = driver.findElement(By.className("cell_addcontact"));
//        addContacts.click();
//
//        WebElement phone = driver.findElement(By.xpath("//input[contains(@name,'phone')]"));
//        phone.sendKeys("0935467618");
//
//        WebElement name = driver.findElement(By.xpath("//input[contains(@name,'im')]"));
//        name.sendKeys("Green");
//
//        WebElement submit = driver.findElement(By.xpath("//input[contains(@class,'submit_button')]"));
//        submit.click();

//        WebElement toOneSmsForm = driver.findElement(By.cssSelector(".main-left-menu.main-left-submenu"));
//        toOneSmsForm.click();

        WebElement submit = driver.findElement(By.xpath("//a[contains(@href,'/MyCampaign/ToOne/')]"));
        submit.click();

        WebElement nameTask = driver.findElement(By.xpath("//input[contains(@name,'campaign_name')]"));
        nameTask.sendKeys("Job");

        WebElement recipient = driver.findElement(By.xpath("//input[contains(@name,'recipient')]"));
        recipient.sendKeys("09354676**");

        WebElement text = driver.findElement(By.id("smstext"));
        text.sendKeys("Меня зовут Руслан,резюме есть здесь RuslanPedko.site");

        WebElement sendSms = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
        sendSms.click();

        WebElement sendSmsYes = driver.findElement(By.xpath("//button[contains(@class,'submit_button')]"));
        sendSmsYes.click();
    }

    @AfterClass
    public static void Close() {
        driver.quit();
    }

}
