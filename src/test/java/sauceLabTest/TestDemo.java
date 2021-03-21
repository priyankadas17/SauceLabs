package sauceLabTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestDemo {

    public WebDriver driver = null;

    //https://priyanka.das.17:1f52ebef-0544-461a-b8a5-3c37aab4f65e@ondemand.eu-central-1.saucelabs.com:443/wd/hub
    public static final String USERNAME="priyanka.das.17";
    public static final String ACCESS_KEY="1f52ebef-0544-461a-b8a5-3c37aab4f65e";
    public static final String URL="https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    @BeforeClass
    @Parameters ({"browser","version","platform"})
    public void setup(String br, String vr, String pf) throws MalformedURLException{

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", br);
        capabilities.setCapability("version", vr);
        capabilities.setCapability("platform", pf);
        driver = new RemoteWebDriver(new URL(URL), capabilities);
    }

    @Test

    //login
    public void verifyLogin(){
     driver.get("http://spree-vapasi.herokuapp.com/login");
     Assert.assertTrue(true);
     driver.findElement(By.id("spree_user_email")).sendKeys("priyanka.floral@gmail.com");
     driver.findElement(By.id("spree_user_password")).sendKeys("newlogin");
     driver.findElement(By.xpath("//input[@value='Login']")).click();
     driver.findElement(By.xpath("//a[@href='/logout']")).click();

}
@AfterClass
    public void tearDown(){
        driver.quit();
}
}
