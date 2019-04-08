package Hw6thApril;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class NavigateToCellPhonesCategory {
    protected static WebDriver driver;

    static String getCurrentDateTime() {
        //create object for simple date format class and decide format

        DateFormat dateFormat = new SimpleDateFormat("MMDDYYYY");
        //get current date time with date
        Date date = new Date();
        //new format for date
        String date1 = dateFormat.format(date);
        out.println("Current date and time is " + date1);
        return date1;
    }
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\Hw6thApril\\chromedriver.exe");
        driver = new ChromeDriver();//getting new chrome driver
        //apply implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://demo.nopcommerce.com/login");
    }
        @Test
        public void electronics()
        {
            //select electronics category
            driver.findElement(By.linkText("Electronics")).click();
            //click on cellphones
            driver.findElement(By.partialLinkText("Cell phones")).click();
            //actual result
            String actualresult = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
            System.out.println("User is on CellPhones page");
        }

    @After
    public void closeBrowser(){
        driver.close();
    }

}
