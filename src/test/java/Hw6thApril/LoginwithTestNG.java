package Hw6thApril;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LoginwithTestNG {

    protected static WebDriver driver;

    static String getCurrentDateTime() {
            //create object for simple date format class and decide format

            DateFormat dateFormat = new SimpleDateFormat("MMDDYYYY");
            //get current date time with date
            Date date = new Date();
            //new format for date
            String date1 = dateFormat.format(date);
            System.out.println("Current date and time is " + date1);
            return date1;
        }
         @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src\\test\\java\\Hw6thApril\\chromedriver.exe");
        driver = new ChromeDriver();//getting new chrome driver
        //apply implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

}
@Test
public void userShouldbeLoginSuccessfully() {
        //user shoud be on login page
    driver.get("http://demo.nopcommerce.com/login");
//enter given email address
    driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("alpha" + getCurrentDateTime() + "@test.com");
//enter given password
    driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("done123");
//click on login button
    driver.findElement(By.xpath("//input[@value='Log in']")).click();
//check the welcome message.
    String userAbleToseeWelcomeMessage = driver.findElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")).getText();
    Assert.assertEquals("Welcome to our store",userAbleToseeWelcomeMessage);

    System.out.println("User Logged In Successfully.");
    }
    @After
    public void closeBrowser () {
        driver.close();
    }
}