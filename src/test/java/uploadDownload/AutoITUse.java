package uploadDownload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class AutoITUse {


    @Test
            public void autoITCheck() throws IOException, InterruptedException {

        ChromeOptions options=new ChromeOptions();
        String downloadPath=System.getProperty("user.dir");
        HashMap<String,Object> chromePrefs=new HashMap<>();
        chromePrefs.put("profile.default_content_setting.popups",0);
        chromePrefs.put("download.default_directory",downloadPath);
        options.setExperimentalOption("prefs",chromePrefs);
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.ilovepdf.com/word_to_pdf");
        driver.findElement(By.id("pickfiles")).click();
        Thread.sleep(2000);
       ProcessBuilder builder=new ProcessBuilder("D:\\VaVe\\Selenium\\AutoIT scripts\\fileupload.exe");
       builder.start();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTask")));
       driver.findElement(By.id("processTask")).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
        Thread.sleep(15000);
       File file= new File("D:\\VaVe\\Selenium\\intellij project\\SeleniumCleverCodes\\pyara singh.pdf");
       if (file.exists()){

           Assert.assertTrue(true);
       }
       else Assert.assertTrue(false);

       file.delete();






    }


}
