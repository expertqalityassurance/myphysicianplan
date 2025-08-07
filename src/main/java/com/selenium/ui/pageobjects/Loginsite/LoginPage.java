package com.selenium.ui.pageobjects.Loginsite;

import com.selenium.dataprovider.GlobalPropertiesReader;
import com.selenium.ui.pageobjects.common.BasePage;
import org.openqa.selenium.By;
import org.testng.Reporter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;
import java.util.Properties;

public class LoginPage extends BasePage {


    public LoginPage() {
        super();
    }

    By USERNAME= By.xpath("//*[@id='UserName']");
    By PASSWORD = By.xpath("//*[@id='Password']");
    By LOGIN_BTN = By.xpath("//*[@id='btnLogin']");




    public LoginPage launchApplication() {
        Reporter.log("********* " + new Throwable().getStackTrace()[0].getMethodName() + " *********");
        Objects.requireNonNull(driver, "Driver object is null...");
        setEnvironmentUrl();
        driver.get(GlobalPropertiesReader.propReader().url());
        Reporter.log("Application is Launched with URL " + GlobalPropertiesReader.propReader().url());
        driver.manage().window().maximize();
        return this;
    }

    public void login() throws InterruptedException {

        Reporter.log("********* " + new Throwable().getStackTrace()[0].getMethodName() + " *********");
        enterValue(USERNAME, GlobalPropertiesReader.propReader().username(), "Username Field");
        enterValue(PASSWORD, GlobalPropertiesReader.propReader().password(), "Password Field");
        clickLoginButton();


    }
    public void clickLoginButton() throws InterruptedException {
        Reporter.log("********* " + new Throwable().getStackTrace()[0].getMethodName() + " *********");
        checkElementIsDisplayed(LOGIN_BTN,"Sign In button is displayed",500);
        clickBySendKey(LOGIN_BTN, "Clicked the Sign in button");
        Thread.sleep(10000);
    }

    public void setEnvironmentUrl () {
        try {
            String url = System.getProperty("staging.urlMerchant");
            if (url != null) {
                FileInputStream in = new FileInputStream("src//main//resources//envconfig.properties");
                Properties props = new Properties();
                props.load(in);
                in.close();
                FileOutputStream out = new FileOutputStream("src//main//resources//envconfig.properties");
                props.setProperty("environment", url);
                props.store(out, null);
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
