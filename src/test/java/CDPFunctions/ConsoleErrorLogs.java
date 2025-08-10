package CDPFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;

public class ConsoleErrorLogs {

    private static final Logger log = LoggerFactory.getLogger(ConsoleErrorLogs.class);

    @Test
    public void getConsoleError(){
        ChromeDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.findElement(By.linkText("Cart")).click();
        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");



        LogEntries logEntries= driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logEntry=logEntries.getAll();
        for (LogEntry e:logEntry){

            System.out.println(e.getMessage());
        }


    }
}
