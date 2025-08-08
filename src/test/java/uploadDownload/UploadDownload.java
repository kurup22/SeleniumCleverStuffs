package uploadDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class UploadDownload {

    @Test
    public void checkUploadData() throws InterruptedException {

        ChromeOptions options=new ChromeOptions();
        options.addArguments("force-device-scale-factor=1.00");

        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");

        driver.findElement(By.id("downloadButton")).click();
        Thread.sleep(3000);
        WebElement upload=driver.findElement(By.id("fileinput"));
        upload.sendKeys("C:\\Users\\VaVe\\Downloads\\download.xlsx");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*=Toastify]")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("button[class*=Toastify]")));




    }
}
