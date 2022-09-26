import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class ConnectGoogle {
        WebDriver driverChrome;
        //WebDriver driverMozilla;

        @BeforeMethod
        void init(){
            driverChrome =  WebDriverManager.chromedriver().create();
            //driverMozilla = WebDriverManager.firefoxdriver().create();
        }

    @Test
    void connection() {
        driverChrome.get("https://google.com");
        driverChrome.manage().window().maximize();

//        driverMozilla.get("https://google.com");
//        driverMozilla.manage().window().maximize();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void tearDown() {
        driverChrome.quit();
        //driverMozilla.quit();
    }
}
