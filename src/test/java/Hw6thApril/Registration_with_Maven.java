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

public class Registration_with_Maven {



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

    public void userShouldRegisterSuccessfully() {
        // opening register page on nopcommerce
        driver.get("http://demo.nopcommerce.com/register");
        //click on register button
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        //Select gender
        driver.findElement(By.xpath("//input[@id='gender-female']")).click();
        //enter given first name
        driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("alpha");
        //enter given last name
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("gabby");
        //enter given email
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("alpha999" + getCurrentDateTime() + "@test.com");
        //enter given password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("done123");
        //enter given confirm password
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("done123");
        //click on registration button
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        //your should able to login successfully able to see message

        String actualRegistrationSuccess = driver.findElement(By.xpath("//div[@class='result']")).getText();

        Assert.assertEquals("Your registration completed", actualRegistrationSuccess);
    }


    @After
     public void closeBrowser () {
    driver.close();}

       }


