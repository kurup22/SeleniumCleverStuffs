package CDPFunctions;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v136.network.Network;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class CDPBlockRequest {

    @Test
    public void blockRequest(){

        ChromeDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        DevTools devtools=driver.getDevTools();
        devtools.createSession();

        devtools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));


        devtools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.findElement(By.linkText("Cart")).click();



    }
}
