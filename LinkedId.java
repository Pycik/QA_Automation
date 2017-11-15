package WebDrive;


import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LinkedId {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", "C:/Users/SPARK/workspace/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get("https://www.linkedin.com/");
    }

    @Test
    public  void LoginLinkedId() {
        //***** Test1 (priority = 1) *****
        System.out.println("Start Test = 1");
        System.out.println("Page title is: " + driver.getTitle());

        WebElement login = driver.findElement(By.id("login-email"));
        login.sendKeys("romanokey@bigmir.net");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("0977501674");
        password.submit();

        System.out.println("Page title is: " + driver.getTitle());

        //***** @Test2 (priority = 2) *****
        System.out.println("Start Test = 2");
//      WebElement avatar = driver.findElement(By.cssSelector(".lazy-image.feed-identity-module__member-photo.profile-rail-card__member-photo.EntityPhoto-circle-5.ghost-person.loaded"));

        WebElement avatar = driver.findElement(By.cssSelector(".lazy-image.feed-identity-module__member-photo.profile-rail-card__member-photo.EntityPhoto-circle-5.loaded"));
        avatar.click();

        System.out.println("Click button avatar: ");

//        assertTrue(driver.findElement(By.cssSelector(".title")).getText().contains("text"));
//      WebElement uploadFile = driver.findElement(By.id("member-photo-edit-upload-input"));
//      uploadFile.sendKeys("D:/progs/Portfolio/img/rus.jpg");

        WebElement editFoto = driver.findElement(By.cssSelector(".pv-top-card-section__edit-photo"));
        editFoto.click();

        System.out.println("Click button edit foto: " + editFoto.getText());


// start Right scroll

        WebElement inputScrollRight = driver.findElement(By.xpath("//*[contains(@class, 'photo-filter__slider-body')]/div[2]/artdeco-slider/input"));
        System.out.println("Start Right Scroll Reposition Foto: " + inputScrollRight.getLocation().getX());

        Actions move = new Actions(driver);
        Action builder = (Action) move.dragAndDropBy(inputScrollRight, -145, 0).build();
        builder.perform();

        System.out.println("End Right Scroll Reposition Foto: ");

// start Left scroll

        WebElement inputScrollLeft = driver.findElement(By.xpath("//*[contains(@class, 'photo-filter__slider-body')]/div[1]/artdeco-slider/input"));
        System.out.println("Start Left Scroll Rich Foto: " + inputScrollLeft.getLocation().getX());

        Actions move2 = new Actions(driver);
        Action builder2 = (Action) move2.dragAndDropBy(inputScrollLeft, 145, 0).build();
        builder2.perform();

        System.out.println("End Left Scroll Rich Foto:");

//click save button size foto-avatar

        WebElement saveButton = driver.findElement(By.cssSelector(".profile-photo-cropper__apply-action.button-primary-medium"));
        saveButton.click();

        System.out.println("click save button Size Foto: " + saveButton.getTagName().toUpperCase());
//click save in new window
        WebElement clickBtnNewWindow = (new WebDriverWait(driver, 10))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//footer[contains(@class,'pe-form-footer')]/div[2]/button")));

        JavascriptExecutor saveBtnNewWindow = (JavascriptExecutor) driver;
        saveBtnNewWindow.executeScript("arguments[0].click();", clickBtnNewWindow);

        //***** @Test 3 (priority = 3) *****
        System.out.println("Start Test = 3");

        WebElement settings = driver.findElement(By.id("nav-settings__dropdown"));
        settings.click();

        System.out.println("click save button in New Window: " + settings.getTagName().toUpperCase());

        //Определяем и Переключаем окна

        String  handle = driver.getWindowHandle();
        System.out.println("This is main Window " + handle);

        WebElement openSettings = driver.findElement(By.xpath("//*[@id='nav-settings__dropdown-options']/li[2]//li[1]"));
        openSettings.click();

        Set handles = driver.getWindowHandles();
        System.out.println("This is all opens Windows " + handles);

        for (String handle1 : driver.getWindowHandles()) {

            System.out.println("Switch to another window " + handle1);
            driver.switchTo().window(handle1);
        }

        WebElement language = driver.findElement(By.id("setting-select-language"));
        language.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement clickSelectLanguage = driver.findElement(By.name("selectLanguage"));
        clickSelectLanguage.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Select dropdown = new Select(driver.findElement(By.tagName("select")));
        dropdown.selectByIndex(5);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //***** Test 4(priority = 4) *****
        System.out.println("Start Test = 4");

        WebElement backProfile = driver.findElement(By.className("nav-return"));
        backProfile.click();

        WebElement openProfileAgain = driver.findElement(By.id("profile-nav-item"));
        openProfileAgain.click();

        WebElement clickAvatarProfile = driver.findElement(By.className("nav-settings__topcard"));
        clickAvatarProfile.click();

        WebElement openAddSkills = driver.findElement(By.className("pe-hub-section__expand-button"));
        openAddSkills.click();

        WebElement openSkills = driver.findElement(By.id("skills-drawer"));
        openSkills.click();

        WebElement clickOpenSkills = driver.findElement(By.id("skills-card"));
        clickOpenSkills.click();

//                  ***** Так делать очень не желательно, ( Пользователь так не делает! ) Другого решения не нашел *****

        JavascriptExecutor jsInput = (JavascriptExecutor) driver;
        WebElement showInput = driver.findElement(By.cssSelector(".ember-text-field.ember-view"));
        jsInput.executeScript("arguments[0].setAttribute('data-artdeco-is-focused', 'true')",showInput);

//        WebElement clickOpenSkillsInput = driver.findElement(By.cssSelector(".ember-text-field.ember-view"));
        WebElement clickOpenSkillsInput = driver.findElement(By.tagName("input"));
        clickOpenSkillsInput.sendKeys("Cisco");
        WebElement clickOpenSkillsInputs = driver.findElement(By.cssSelector(".button-primary-medium.ml2"));
        clickOpenSkillsInputs.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");

        int xCord2 = driver.findElement(By.cssSelector(".pv-skills-section__add-text.button-tertiary-medium-muted")).getLocation().getX();
        int yCord2 = driver.findElement(By.cssSelector(".pv-skills-section__add-text.button-tertiary-medium-muted")).getLocation().getY();

        System.out.println("X Value Button = " + xCord2);
        System.out.println("Y Value Button = " + yCord2);

                WebElement Elementsettings = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pv-skills-section__add-text.button-tertiary-medium-muted")));

        Actions actual = new Actions(driver);
        actual.moveToElement(Elementsettings,xCord2,yCord2).click(Elementsettings).build().perform();

        WebElement waitInput = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ember-text-field.ember-view")));

        JavascriptExecutor jsInput22 = (JavascriptExecutor) driver;
        jsInput22.executeScript("arguments[0].setAttribute('data-artdeco-is-focused', 'true')",waitInput);

        waitInput.sendKeys("Sql");
        waitInput.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // start change Location place

        WebElement changeLocation = driver.findElement(By.xpath("//a[@data-control-name='edit_skills']"));
        changeLocation.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement modalWindo = driver.findElement(By.tagName("artdeco-modal"));

        JavascriptExecutor modalWindow = (JavascriptExecutor) driver;
        modalWindow.executeScript("arguments[0].setAttribute('data-artdeco-is-focused', 'true')",modalWindo);

// Определяем координаты первого обьекта
        int xCord4 = driver.findElement(By.xpath("//*[contains(@class, 'pv-skills__list')]/li[1]/div/span/span/li-icon")).getLocation().getX();
        int yCord4 = driver.findElement(By.xpath("//*[contains(@class, 'pv-skills__list')]/li[1]/div/span/span/li-icon")).getLocation().getY();

        System.out.println("X Value skill - 1 = " + xCord4);
        System.out.println("Y Value skill - 1 = " + yCord4);

        WebElement changeLocation33 = driver.findElement(By.xpath("//*[contains(@class, 'pv-skills__list')]/li[3]/div/span/span/li-icon"));
// Определяем координаты второго обьекта
        int xCord5 = driver.findElement(By.xpath("//*[contains(@class, 'pv-skills__list')]/li[3]/div/span/span/li-icon")).getLocation().getX();
        int yCord5 = driver.findElement(By.xpath("//*[contains(@class, 'pv-skills__list')]/li[3]/div/span/span/li-icon")).getLocation().getY();

        System.out.println("X Value skill - 3 = " + xCord5);
        System.out.println("Y Value skill - 3 = " + yCord5);

// Меняем 1й и 3й обьект местами ( но этого не происходит! ) так как WebDriver не видит нарисованные элементы "svg" и другие...
        Actions clickModalWindow = new Actions(driver);
        clickModalWindow.moveToElement(changeLocation33,xCord5,yCord5).dragAndDropBy(changeLocation33,xCord4,yCord4).build().perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();        }

        WebElement changeLocationSaveBtn = driver.findElement(By.cssSelector(".pv-skills__save.button-primary-medium.ml2.fr.ember-view"));
        changeLocationSaveBtn.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ***** @Test (priority = 5) *****

        System.out.println("Start Test = 5");

        WebElement openMessage = driver.findElement(By.id("messaging-nav-item"));
        openMessage.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement uploadFiles = driver.findElement(By.xpath("//*[contains(@class, 'msg-compose-form__left-actions')]/form[1]/input[3]"));
        uploadFiles.sendKeys("D:/progs/Portfolio/img/rus.jpg");

//                      ******** Первое решение было таким ( Пользователь так не делает! ) **********
//        JavascriptExecutor changeInputType = (JavascriptExecutor) driver;
//        changeInputType.executeScript("arguments[0].setAttribute('type', 'file')",uploadFiles);
//        uploadFiles.sendKeys("D:/progs/Portfolio/img/rus.jpg");

        WebElement textMessage = driver.findElement(By.xpath("//*[contains(@class, 'msg-compose-form__autoscroll')]/textarea"));
        textMessage.sendKeys("Hello,I'm Russell Crowe, nice Day");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement btnClose = driver.findElement(By.className("remove-attachment"));
        btnClose.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        textMessage.clear();

        //***** @Test 6(priority=6) *****
        System.out.println("Start Test = 6");

        WebElement btnProfile = driver.findElement(By.id("profile-nav-item"));
        btnProfile.click();

        System.out.println("Open Profile = " + btnProfile.getTagName().toUpperCase());

        WebElement btnExit = driver.findElement(By.className("nav-dropdown__action"));
        btnExit.click();
        System.out.println("Exit Application" + "\n Verification no true/false ,because not understand how does it work 'AssertTrue' and other ...");

    }
}
