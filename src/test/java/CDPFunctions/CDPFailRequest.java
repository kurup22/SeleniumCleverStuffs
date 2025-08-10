package CDPFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v136.fetch.Fetch;
import org.openqa.selenium.devtools.v136.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v136.network.model.ErrorReason;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CDPFailRequest {

    @Test
    public void failRequest(){

        ChromeDriver driver=new ChromeDriver();
        DevTools devtools=driver.getDevTools();

        devtools.createSession();

       Optional<List<RequestPattern>> patterns= Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty())));


        devtools.send(Fetch.enable(patterns,Optional.empty()));

        devtools.addListener(Fetch.requestPaused(),requestPaused -> {

            devtools.send(Fetch.failRequest(requestPaused.getRequestId(), ErrorReason.FAILED));
        });


        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("button[routerlink='/library']")).click();




    }
}
