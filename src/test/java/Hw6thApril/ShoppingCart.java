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

public class ShoppingCart {
    protected static WebDriver driver;

    static String getCurrentDateTime()
    {//create object for simple date format class and decide format
        DateFormat dateFormat = new SimpleDateFormat("MMDDYYYY");
        //get current date and time
        Date date = new Date();
        //new format for date
        String date1 = dateFormat.format(date);
        System.out.println("Current date and time is " + date1);
        return date1;

    }
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src\\test\\java\\Hw6thApril\\chromedriver.exe");
        driver = new ChromeDriver();//getting chrome browser
        //implicit wait applied
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/login");


    }
    @Test
    public void add_to_cart()
    {
        //select books category
        driver.findElement(By.linkText("Books")).click();
        //select book named pride and prejudice
        driver.findElement(By.partialLinkText("Pride and Prejudice")).click();
        //click on add to cart
        driver.findElement(By.xpath("//input[@id='add-to-cart-button-39']")).click();
        //actual result
        String actualresult = driver.findElement(By.xpath("//p[@class='content']")).getText();
        Assert.assertEquals("The product has been added to your shopping cart",actualresult);
        System.out.println("The product has been added to your shopping cart");
    }
    @After
    public void closeBrowser()
    {
        driver.close();

    }}
