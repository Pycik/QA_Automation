package TestNG;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestNG_Linked {

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
//        driver.manage().deleteAllCookies();
    }

    @Test(priority=1)
    public  void login() {
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


        //***** @Test 3 (priority = 3) *****



        //***** Test 4(priority = 4) *****


        // ***** @Test (priority = 5) *****



        //***** @Test 6(priority=6) *****

    }

    @Test(priority=2)
    public  void  repositionPhoto() {

        System.out.println("Start Test = 2");

// start validation
        WebElement avatar = driver.findElement(By.xpath("//img[contains(@class,'EntityPhoto-circle-5')][@alt='Rumpel Cross']"));
        String validationAvatar = avatar.getAttribute("alt");
        Assert.assertEquals("Rumpel Cross", validationAvatar);

        if (validationAvatar.equals("Rumpel Cross")){
            System.out.println(" Validation YES " + validationAvatar);
        } else {
            System.out.println("Validation NO " + validationAvatar );
        }
// end validation
        System.out.println("Click button avatar: " + validationAvatar.toUpperCase());
        avatar.click();

//      WebElement uploadFile = driver.findElement(By.id("member-photo-edit-upload-input"));
//      uploadFile.sendKeys("D:/progs/Portfolio/img/rus.jpg");

        // start validation
        WebElement editPhotoProfile= driver.findElement(By.xpath("//button[contains(@class,'profile-photo-edit__edit-btn')]"));
        String validationEditPhoto = editPhotoProfile.getTagName();
        Assert.assertEquals("button", validationEditPhoto);

        if (validationEditPhoto.equals("button")){
            System.out.println(" Validation YES " + validationEditPhoto);
        } else {
            System.out.println("Validation NO " + validationEditPhoto);
        }
        // end validation

        System.out.println("Click button edit photo: " + validationEditPhoto.toUpperCase());
        editPhotoProfile.click();

// start Right scroll

        WebElement inputScrollRight = driver.findElement(By.xpath("//*[contains(@class, 'photo-filter__slider-body')]/div[2]/artdeco-slider/input"));

        // start validation
        String validationInputScrollRight = inputScrollRight.getAttribute("value");
        Assert.assertEquals("0", validationInputScrollRight);

        if (validationInputScrollRight.equals("0")){
            System.out.println(" Validation YES " + validationInputScrollRight);
        } else {
            System.out.println("Validation NO " + validationInputScrollRight);
        }
        System.out.println("Start Right Scroll Reposition Foto: " + validationInputScrollRight);

        Actions move = new Actions(driver);
        Action builder = (Action) move.dragAndDropBy(inputScrollRight, -145, 0).build();
        builder.perform();

        String validationInputScrollRightEnd = inputScrollRight.getAttribute("value");
        Assert.assertEquals("-45", validationInputScrollRightEnd);

        if (validationInputScrollRightEnd.equals("-45")){
            System.out.println(" Validation YES " + validationInputScrollRightEnd);
        } else {
            System.out.println("Validation NO " + validationInputScrollRightEnd);
        }

        System.out.println("End Right Scroll Reposition Foto: " + validationInputScrollRightEnd);
        // end validation

// start Left scroll

        WebElement inputScrollLeft = driver.findElement(By.xpath("//*[contains(@class, 'photo-filter__slider-body')]/div[1]/artdeco-slider/input"));

        // start validation
        String validationInputScrollLeft = inputScrollLeft.getAttribute("value");
        Assert.assertEquals("1", validationInputScrollLeft);

        if (validationInputScrollLeft.equals("1")){
            System.out.println(" Validation YES " + validationInputScrollLeft);
        } else {
            System.out.println("Validation NO " + validationInputScrollLeft);
        }

        System.out.println("Start Left Scroll Rich Foto: " + validationInputScrollLeft);

        Actions move2 = new Actions(driver);
        Action builder2 = (Action) move2.dragAndDropBy(inputScrollLeft, 145, 0).build();
        builder2.perform();

        String validationInputScrollLeftEnd = inputScrollLeft.getAttribute("value");
        Assert.assertEquals("3", validationInputScrollLeftEnd);

        if (validationInputScrollLeftEnd.equals("3")){
            System.out.println(" Validation YES " + validationInputScrollLeftEnd);
        } else {
            System.out.println("Validation NO " + validationInputScrollLeftEnd);
        }
        System.out.println("End Left Scroll Rich Foto: " + validationInputScrollLeftEnd);
        // end validation

//click save button size foto-avatar

        WebElement saveButton = driver.findElement(By.cssSelector(".profile-photo-cropper__apply-action.button-primary-medium"));

        //start validation
        String validationSaveButton = saveButton.getText();
        Assert.assertTrue(validationSaveButton.equals("Apply") || validationSaveButton.equals("Применить"));
//        Assert.assertEquals("Apply", validationSaveButton);
        if (validationSaveButton.equals("Apply") || validationSaveButton.equals("Применить")) {
            System.out.println(" Validation YES " + validationSaveButton);
        } else {
            System.out.println("Validation NO" + validationSaveButton );
        }

        saveButton.click();
        System.out.println("click save button Size Foto: " + saveButton.getText().toUpperCase());
//click save in new window

//        WebElement clickBtnNewWindow = (new WebDriverWait(driver, 10))
//        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//footer[contains(@class,'pe-form-footer')]/div[2]/button")));

        WebElement ChangeToNewWindow = driver.findElement(By.className("modal-wormhole-content"));
        ChangeToNewWindow.click();

        WebElement clickThisModalWindow = driver.findElement(By.className("pe-form-footer__actions"));
        clickThisModalWindow.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
//        WebElement waitModalWindowClick = (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//[@data-artdeco-is-focused='true']")));
//      waitModalWindowClick.click();
        //start validation

        String modalWindow = driver.findElement(By.className("modal-wormhole-content")).getAttribute("data-artdeco-is-focused");
        System.out.println("click Modal Window: " + modalWindow);

        Assert.assertEquals("true", modalWindow);

        if (modalWindow.equals("true")) {
            System.out.println(" Validation YES " + modalWindow);
        } else {
            System.out.println("Validation NO" + modalWindow);
        }
        //end validation

        //start validation
        WebElement clickBtnNewWindowSave = driver.findElement(By.xpath("//footer[contains(@class,'pe-form-footer')]/div[2]/button"));
        String validationclickBtnNewWindow = clickBtnNewWindowSave.getText();

        Assert.assertTrue(validationclickBtnNewWindow.equals("Save") || validationclickBtnNewWindow.equals("Сохранить"));

        if (validationclickBtnNewWindow.equals("Save") || validationclickBtnNewWindow.equals("Сохранить")) {
            System.out.println(" Validation YES " + validationclickBtnNewWindow);
        } else {
            System.out.println("Validation NO" + validationclickBtnNewWindow);
        }
        //end validation

        System.out.println("click save button Modal Window: " + validationclickBtnNewWindow);
        clickBtnNewWindowSave.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test(priority=3)
    public  void   changeLanguage() {

        System.out.println("Start Test = 3");

        WebElement settings = driver.findElement(By.id("nav-settings__dropdown"));
        String validationSettingsNoFocus = settings.getAttribute("class");
        System.out.println("Open Profile button Before click " + validationSettingsNoFocus);
        settings.click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String validationSettingsYesFocus = driver.findElement(By.id("nav-settings__dropdown")).getAttribute("class");

        Assert.assertEquals("dropdown open ember-view", validationSettingsYesFocus);

        if (validationSettingsYesFocus.equals("dropdown open ember-view")) {
            System.out.println(" Validation YES " + validationSettingsYesFocus);
        } else {
            System.out.println("Validation NO" + validationSettingsYesFocus);
        }

        System.out.println("Focus Profile click button: " + validationSettingsYesFocus);

        //Определяем и Переключаем окна

        String  mainWindow = driver.getWindowHandle();
        System.out.println("This is main Window " + mainWindow);

        WebElement openSettings = driver.findElement(By.xpath("//*[@id='nav-settings__dropdown-options']/li[2]//li[1]"));
        openSettings.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set handles = driver.getWindowHandles();
        System.out.println("This is all opens Windows " + handles);

        for (String handle1 : driver.getWindowHandles()) {

            System.out.println("Switch to another window " + handle1);
            driver.switchTo().window(handle1);
        }

        System.out.println("Page title is: " + driver.getTitle());
        WebElement language = driver.findElement(By.id("setting-select-language"));
        language.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //start validation
        WebElement optionLanguageValue = driver.findElement(By.tagName("html"));
        String clickLanguage = optionLanguageValue.getAttribute("lang");
        System.out.println("Now Select Language is " + clickLanguage);
        Assert.assertTrue(clickLanguage.equals("ru") || clickLanguage.equals("en"));

        if (clickLanguage.equals("ru") || clickLanguage.equals("en")) {
            System.out.println(" Validation YES " + clickLanguage);
        } else {
            System.out.println("Validation NO" + clickLanguage);
        }

        //end validation

        WebElement clickSelectLanguage = driver.findElement(By.name("selectLanguage"));
        clickSelectLanguage.click();
        System.out.println("click Select Language 'Select' " + clickLanguage);

        //start validation

        String SelectLanguage = clickSelectLanguage.getAttribute("data-artdeco-is-focused");
        Assert.assertEquals("true", SelectLanguage);

        if (SelectLanguage.equals("true")) {
            System.out.println(" Validation YES click 'Select' " + SelectLanguage);
        } else {
            System.out.println("Validation NO" + SelectLanguage);
        }

        //end validation

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

        WebElement optionLanguageValue2 = driver.findElement(By.tagName("html"));
        String clickLanguageAfter =  optionLanguageValue2.getAttribute("lang");
        System.out.println("After Select another Language, Language is " + clickLanguageAfter);
        System.out.println("Page title is: " + driver.getTitle());

    }

    @Test(priority=4)
    public  void changePlacesSkills() {

        System.out.println("Start Test = 4");
//Go back main Page
        WebElement backProfile = driver.findElement(By.className("nav-return"));
        backProfile.click();

//Open Profile
        WebElement openProfileAgain = driver.findElement(By.id("nav-settings__dropdown"));
        String  openProfileAgainValidation = openProfileAgain.getAttribute("class");
        System.out.println(" Before click Profile Settings " + openProfileAgainValidation);
        openProfileAgain.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String  openProfileAgainValidationAfter = driver.findElement(By.id("nav-settings__dropdown")).getAttribute("class");
        System.out.println("After click Profile Settings " + openProfileAgainValidationAfter);

        //start validation
        Assert.assertEquals("dropdown open ember-view", openProfileAgainValidationAfter);

        if (openProfileAgainValidationAfter.equals("dropdown open ember-view")) {
            System.out.println(" Validation YES " + openProfileAgainValidationAfter);
        } else {
            System.out.println("Validation NO" + openProfileAgainValidationAfter);
        }
        //end validation
//
        WebElement clickAvatarProfile = driver.findElement(By.className("nav-settings__topcard"));
        clickAvatarProfile.click();

        WebElement openAddSkills = driver.findElement(By.className("pe-hub-section__expand-button"));
        openAddSkills.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //start validation
        String  clickOpenSkillsValidation = openAddSkills.getAttribute("data-artdeco-is-focused");
        Assert.assertEquals("true", clickOpenSkillsValidation);

        if (clickOpenSkillsValidation.equals("true")) {
            System.out.println(" Validation YES " + clickOpenSkillsValidation);
        } else {
            System.out.println("Validation NO" + clickOpenSkillsValidation);
        }
        System.out.println(" After click add new Profile section " + clickOpenSkillsValidation);
        //end validation

        WebElement openSkills = driver.findElement(By.id("skills-drawer"));
        openSkills.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //start validation
        String  clickSkillsValidation =  driver.findElement(By.xpath("//*[@id='skills-drawer']//button")).getAttribute("data-artdeco-is-focused");
        Assert.assertEquals("true", clickSkillsValidation);

        if (clickSkillsValidation.equals("true")) {
            System.out.println(" Validation YES " + clickSkillsValidation);
        } else {
            System.out.println("Validation NO" + clickSkillsValidation);
        }
        System.out.println(" After click add new Profile section " + clickSkillsValidation);
        //end validation

        WebElement clickOpenSkills = driver.findElement(By.id("skills-card"));
        clickOpenSkills.click();

        WebElement clickModalWindowSkill = driver.findElement(By.tagName("artdeco-modal"));
        clickModalWindowSkill.click();

        WebElement clickModalWindowSkillInput = driver.findElement(By.tagName("input"));
//        clickModalWindowSkillInput.click();

//                  ***** Так делать очень не желательно, ( Пользователь так не делает! ) *****
//
//        JavascriptExecutor jsInput = (JavascriptExecutor) driver;
//        WebElement showInput = driver.findElement(By.cssSelector(".ember-text-field.ember-view"));
//        jsInput.executeScript("arguments[0].setAttribute('data-artdeco-is-focused', 'true')",showInput);
//        WebElement clickOpenSkillsInput = driver.findElement(By.cssSelector(".ember-text-field.ember-view"));
//        WebElement clickOpenSkillsInput = driver.findElement(By.tagName("input"));

        clickModalWindowSkillInput.sendKeys("Cisco");
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

        System.out.println("X Value Button add Skills = " + xCord2);
        System.out.println("Y Value Button add Skills = " + yCord2);

        WebElement Elementsettings = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pv-skills-section__add-text.button-tertiary-medium-muted")));

        Actions actual = new Actions(driver);
        actual.moveToElement(Elementsettings,xCord2,yCord2).click(Elementsettings).build().perform();

        WebElement waitInput = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ember-text-field.ember-view")));

//                  ***** Так делать очень не желательно, ( Пользователь так не делает! ) *****
//        JavascriptExecutor jsInput22 = (JavascriptExecutor) driver;
//        jsInput22.executeScript("arguments[0].setAttribute('data-artdeco-is-focused', 'true')",waitInput);
//
        WebElement clickModalWindowSkillMore = driver.findElement(By.tagName("artdeco-modal"));
        clickModalWindowSkillMore.click();

        WebElement clickModalWindowSkillInputMore = driver.findElement(By.tagName("input"));
        clickModalWindowSkillInputMore.sendKeys("Sql");
        clickModalWindowSkillInputMore.sendKeys(Keys.ENTER);

//        waitInput.sendKeys("Sql");
//        waitInput.sendKeys(Keys.ENTER);

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

        WebElement modalWindowSkills = driver.findElement(By.tagName("artdeco-modal"));

        JavascriptExecutor modalWindowSkill = (JavascriptExecutor) driver;
        modalWindowSkill.executeScript("arguments[0].setAttribute('data-artdeco-is-focused', 'true')",modalWindowSkills);

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

    }

    @Test(priority=5)
    public  void attachFileMessage() {

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

    }

    @Test(priority=6)
    public  void  LogOut() {

        System.out.println("Start Test = 6");

        WebElement btnProfile = driver.findElement(By.id("profile-nav-item"));
        btnProfile.click();

        WebElement btnExit = driver.findElement(By.className("nav-dropdown__action"));
        btnExit.click();
        System.out.println("Exit Application");
        System.out.println("Page title is: " + driver.getTitle());
    }

    @AfterClass
    public static void Close() {
        driver.quit();
    }
}
