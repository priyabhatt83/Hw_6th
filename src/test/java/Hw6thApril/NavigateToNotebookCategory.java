package Hw6thApril;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NavigateToNotebookCategory {
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
        //user should be on login page
        driver.get("http://demo.nopcommerce.com/login");

    }
    @Test
    public void computerCat()
    {
        //click on computer link
        driver.findElement(By.linkText("Computers")).click();
        //click on notebook
        driver.findElement(By.partialLinkText("Notebooks")).click();
        //actual result
        String actualresult = driver.findElement(By.xpath("//h1[contains(text(),'Notebooks')]")).getText();

        System.out.println(" User is on Notebook Page");
    }

@After
    public void closeBrowser(){

        driver.close();
}
}
