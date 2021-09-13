package com.tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.3 / hostname

        String host = "localhost";
        DesiredCapabilities dc ;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        }else {
            dc = DesiredCapabilities.firefox();
        }
        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }
        
        String completeURL = "http://"+host+":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeURL),dc);
        

        /*System.setProperty("webdriver.chrome.driver","E:\\Browserdrivers\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();*/
    }

    /*@BeforeTest()
    public void setup() throws MalformedURLException {
        String url = "http://192.168.225.147:4444/wd/hub";
        DesiredCapabilities dc =new DesiredCapabilities();
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.WINDOWS);
        this.driver = new RemoteWebDriver((new URL(url)),dc);
    }*/


    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }



}
