package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class Topic_02_Css_xpath {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chrome");
        }

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        sleepInSecond(5);
    }

    @Test
    //edit this line
    public void TC_01_Register_with_empty_data() {
        driver.findElement(By.cssSelector("#frmLogin > div > div.field_btn > button")).click();
        sleepInSecond(5);
        Assert.assertEquals(driver.findElement(By.cssSelector("#txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.cssSelector("#txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.cssSelector("#txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.cssSelector("#txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.cssSelector("#txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.cssSelector("#txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
    }

    @Test
    public void TC_02_Register_with_invalid_email() {
        ///Input Name
        driver.findElement(By.cssSelector("#txtFirstname")).sendKeys("Jacky");
        ///Input email
        driver.findElement(By.cssSelector("#txtEmail")).sendKeys("abc@bdf@hhh");
        ///Input email1
        driver.findElement(By.cssSelector("#txtCEmail")).sendKeys("abc@bdf@hhh");
        ///Input password
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys("123456789");
        ///Input password 1
        driver.findElement(By.cssSelector("#txtCPassword")).sendKeys("123456789");
        ///Input Phonenum
        driver.findElement(By.cssSelector("#txtPhone")).sendKeys("0379076984");
        //Click Dang ky
        driver.findElement(By.cssSelector("#frmLogin > div > div.field_btn > button")).click();
        sleepInSecond(5);
        //check email
        Assert.assertEquals(driver.findElement(By.cssSelector("#txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.cssSelector("#txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void TC_03_Register_with_incorrect_confirm_email() {
        ///Input Name
        WebElement Input_name = driver.findElement(By.cssSelector("#txtFirstname"));
        Input_name.clear();
        Input_name.sendKeys("Jacky");
        ///Input email
        WebElement Email = driver.findElement(By.cssSelector("#txtEmail"));
        Email.clear();
        Email.sendKeys("abc@gmail.com");
        ///Input email1
        WebElement Email1 = driver.findElement(By.cssSelector("#txtCEmail"));
        Email1.clear();
        Email1.sendKeys("abc@bdf@hhh");
        ///Input password
        WebElement Password = driver.findElement(By.cssSelector("#txtPassword"));
        Password.clear();
        Password.sendKeys("123456789");
        ///Input password 1
        WebElement Password1 = driver.findElement(By.cssSelector("#txtCPassword"));
        Password1.clear();
        Password1.sendKeys("123456789");
        ///Input Phonenum
        WebElement Phonenum = driver.findElement(By.cssSelector("#txtPhone"));
        Phonenum.clear();
        Phonenum.sendKeys("0379076984");
        //Click Dang ky
        driver.findElement(By.cssSelector("#frmLogin > div > div.field_btn > button")).click();
        sleepInSecond(5);
        //check email
        Assert.assertEquals(driver.findElement(By.cssSelector("#txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void TC_04_Register_with_password_below_6chars() {
        ///Input Name
        WebElement Input_name = driver.findElement(By.cssSelector("#txtFirstname"));
        Input_name.clear();
        Input_name.sendKeys("Jacky");
        ///Input email
        WebElement Email = driver.findElement(By.cssSelector("#txtEmail"));
        Email.clear();
        Email.sendKeys("abc@gmail.com");
        ///Input email1
        WebElement Email1 = driver.findElement(By.cssSelector("#txtCEmail"));
        Email1.clear();
        Email1.sendKeys("abc@gmail.com");
        ///Input password
        WebElement Password = driver.findElement(By.cssSelector("#txtPassword"));
        Password.clear();
        Password.sendKeys("12345");
        ///Input password 1
        WebElement Password1 = driver.findElement(By.cssSelector("#txtCPassword"));
        Password1.clear();
        Password1.sendKeys("12345");
        ///Input Phonenum
        WebElement Phonenum = driver.findElement(By.cssSelector("#txtPhone"));
        Phonenum.clear();
        Phonenum.sendKeys("0379076984");
        //Click Dang ky
        driver.findElement(By.cssSelector("#frmLogin > div > div.field_btn > button")).click();
        sleepInSecond(5);
        //check password
        Assert.assertEquals(driver.findElement(By.cssSelector("#txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.cssSelector("#txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void TC_05_Register_with_incorrect_confirm_password() {
        ///Input Name
        WebElement Input_name = driver.findElement(By.cssSelector("#txtFirstname"));
        Input_name.clear();
        Input_name.sendKeys("Jacky");
        ///Input email
        WebElement Email = driver.findElement(By.cssSelector("#txtEmail"));
        Email.clear();
        Email.sendKeys("abc@gmail.com");
        ///Input email1
        WebElement Email1 = driver.findElement(By.cssSelector("#txtCEmail"));
        Email1.clear();
        Email1.sendKeys("abc@gmail.com");
        ///Input password
        WebElement Password = driver.findElement(By.cssSelector("#txtPassword"));
        Password.clear();
        Password.sendKeys("1234567");
        ///Input password 1
        WebElement Password1 = driver.findElement(By.cssSelector("#txtCPassword"));
        Password1.clear();
        Password1.sendKeys("12345");
        ///Input Phonenum
        WebElement Phonenum = driver.findElement(By.cssSelector("#txtPhone"));
        Phonenum.clear();
        Phonenum.sendKeys("0379076984");
        //Click Dang ky
        driver.findElement(By.cssSelector("#frmLogin > div > div.field_btn > button")).click();
        sleepInSecond(5);
        //check confirm password
        Assert.assertEquals(driver.findElement(By.cssSelector("#txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void TC_06_Register_with_invalid_phone() {
        ///Input Name
        WebElement Input_name = driver.findElement(By.cssSelector("#txtFirstname"));
        Input_name.clear();
        Input_name.sendKeys("Jacky");
        ///Input email
        WebElement Email = driver.findElement(By.cssSelector("#txtEmail"));
        Email.clear();
        Email.sendKeys("abc@gmail.com");
        ///Input email1
        WebElement Email1 = driver.findElement(By.cssSelector("#txtCEmail"));
        Email1.clear();
        Email1.sendKeys("abc@gmail.com");
        ///Input password
        WebElement Password = driver.findElement(By.cssSelector("#txtPassword"));
        Password.clear();
        Password.sendKeys("1234567");
        ///Input password 1
        WebElement Password1 = driver.findElement(By.cssSelector("#txtCPassword"));
        Password1.clear();
        Password1.sendKeys("1234567");
        ///Input Phonenum
        WebElement Phonenum = driver.findElement(By.cssSelector("#txtPhone"));
        Phonenum.clear();
        Phonenum.sendKeys("037907698423");
        //Click Dang ky
        driver.findElement(By.cssSelector("#frmLogin > div > div.field_btn > button")).click();
        sleepInSecond(5);
        //check phone number
        Assert.assertEquals(driver.findElement(By.cssSelector("#txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond *1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}