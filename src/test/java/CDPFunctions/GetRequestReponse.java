package CDPFunctions;

import org.apache.poi.sl.draw.geom.GuideIf;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v136.fetch.Fetch;
import org.openqa.selenium.devtools.v136.network.Network;
import org.openqa.selenium.devtools.v136.network.model.Request;
import org.testng.annotations.Test;

import javax.swing.text.html.Option;
import java.time.Duration;
import java.util.Optional;

public class GetRequestReponse {

   @Test
    public void getDetails() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        DevTools devtools=driver.getDevTools();
        devtools.createSession();

       // priting request url
        devtools.send(Network.enable(Optional.empty(),
                Optional.empty(),Optional.empty()));

        devtools.addListener(Network.requestWillBeSent(),request->{
            Request req=request.getRequest();
            if(req.getUrl().contains("GetBook")) {
                System.out.println(req.getUrl());
            }

        });

// modifying url and sending back
       devtools.send(Fetch.enable(Optional.empty(),Optional.empty())) ;
       devtools.addListener(Fetch.requestPaused(),requestPaused -> {
           if(requestPaused.getRequest().getUrl().contains("GetBook")){

               String url=requestPaused.getRequest().getUrl().replace("=shetty","=BadGuy");

               devtools.send(Fetch.continueRequest(requestPaused.getRequestId(), Optional.of(url),Optional.of(requestPaused.getRequest().getMethod()),
                       Optional.empty(), Optional.empty(),Optional.empty()));

           }
else {
               devtools.send(Fetch.continueRequest(requestPaused.getRequestId(), Optional.of(requestPaused.getRequest().getUrl()),Optional.of(requestPaused.getRequest().getMethod()),
                       Optional.empty(), Optional.empty(),Optional.empty()));

           }
       });



   driver.get("https://rahulshettyacademy.com/angularAppdemo/");
      driver.findElement(By.cssSelector("button[routerlink='/library']")).click();


    }
}