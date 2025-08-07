package com.selenium.ui.pageobjects.common;

import com.aventstack.extentreports.Status;
import com.selenium.connectors.JsonConnector;
import com.selenium.ui.helper.ExceptionHelper;
import com.selenium.ui.helper.LoggerHelper;
import com.selenium.ui.helper.WaitHelper;
import com.selenium.ui.reporter.ThreadSafeExtent;
import com.selenium.ui.testbase.TestBase;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

public class BasePage {

    private Logger logger = LoggerHelper.getLogger(this.getClass());
    protected WebDriver driver;
    protected Actions action;
    WaitHelper waitHelper;
    private String RandomeName,PhoneNumber,DummyName, DummyEmail, DummyUserName;




    private static int explicitWait = Integer.parseInt(JsonConnector.getConfig("explicitWait") == null ? "10" : JsonConnector.getConfig("explicitWait"));
    private static int implicitwait = Integer.parseInt(JsonConnector.getConfig("implicitWait") == null ? "0" : JsonConnector.getConfig("implicitWait"));
    private static int pageloadwait = Integer.parseInt(JsonConnector.getConfig("pageLoadWait") == null ? "10" : JsonConnector.getConfig("pageLoadWait"));
    private static int pollingTime = Integer.parseInt(JsonConnector.getConfig("pollingTime") == null ? "10" : JsonConnector.getConfig("pollingTime"));

    protected BasePage() {
        driver = TestBase.getDriver();
        waitHelper = new WaitHelper();
    }

    public void launchApp(String url, String desc) {
        try {
            driver.get(url);
            driver.manage().window().maximize();
            if (!desc.isEmpty()) {
                Reporter.log(desc);
            }
        } catch (Exception e) {
            logger.error("Exception thrown in LaunchApp function" + e);
            Reporter.log(e.getLocalizedMessage());
            Assert.assertTrue(false, "Exception thrown in launchapp function " + e);
        }
    }

    public void click(By locator, String desc) {
        try {
            waitHelper.waitForElementClickable(driver, locator, explicitWait, pollingTime).click();
            if (!desc.isEmpty()) {
                Reporter.log(desc);
            }
        } catch (Exception e) {
            logger.error("Exception thrown in Click function" + e);
            Assert.assertTrue(false, "Not able to Click" + e);
        }
    }

    public void clickBySendKey(By locator, String desc) {
        try {
            waitHelper.waitForElementClickable(driver, locator, explicitWait, pollingTime).sendKeys(Keys.ENTER);
            if (!desc.isEmpty()) {
                Reporter.log(desc);
            }
        } catch (Exception e) {
            logger.error("Exception thrown in Click function" + e);
            Assert.assertTrue(false, "Not able to Click" + e);
        }
    }


    /**
     * This Function must be used when there is no page load is happening
     * @param locator
     * @param desc
     */
    public void clickWithOutWait(By locator, String desc) {
        try {
            driver.findElement(locator).click();
            if (!desc.isEmpty()) {
                Reporter.log(desc);
            }
        } catch (Exception e) {
            logger.error("Exception thrown in Click function" + e);
            Assert.assertTrue(false, "Not able to Click" + e);
        }
    }



    public void submit(By locator) throws ExceptionHelper {
        try {
            waitHelper.waitForElementClickable(driver, locator, explicitWait, pollingTime).submit();
        } catch (Exception e) {
            logger.error("Exception thrown in submit function" + e);
            throw new ExceptionHelper(e.getLocalizedMessage());
        }
    }

    public void mouseClick(By locator) {
        WebElement element = driver.findElement(locator);
        action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }
    public void enterValue(By locator, String value, String desc)  {
        try {
            waitHelper.waitForElementVisible(driver, locator, explicitWait, pollingTime).sendKeys(value);
            Reporter.log(value + " is entered in " + desc);
        } catch (Exception e) {
            logger.error("Exception thrown in enterValue function" + e);
            Assert.assertTrue(false, "Not able to enter text");
        }
    }

    public void typeInField(By locator, String value){
        String val = value;
        try {
            WebElement element = driver.findElement(locator);
            element.clear();
            for (int i = 0; i < val.length(); i++) {
                char c = val.charAt(i);
                String s = new StringBuilder().append(c).toString();
                element.sendKeys(s);
            }
            hardDelay(500);
            Reporter.log(value + " is entered");
        }catch (Exception e){
            logger.error("Exception thrown in TypeInField function" + e);
            Assert.assertTrue(false, "Not able to enter text");
        }
    }

    /**
     * Function to clear text
     *
     * @param locator
     * @throws ExceptionHelper
     */
    public void clearText(By locator){
        try {
            waitHelper.waitForElementVisible(driver, locator, 20, 2).clear();
        } catch (Exception e) {
            logger.error("Exception thrown in clearText function" + e);
            Assert.assertTrue(false);
            Reporter.log("Failed while clearing the text" + e);
        }
    }

    /**
     * Function to enter integer/long values
     *
     * @param locator
     * @param value
     * @param desc
     * @throws ExceptionHelper
     */
    public void enterValue(By locator, long value, String desc)  {
        try {
            waitHelper.waitForElementVisible(driver, locator, explicitWait, pollingTime).sendKeys(String.valueOf(value));
            Reporter.log(value + " is entered in " + desc);
        } catch (Exception e) {
            logger.error("Exception thrown in enterValue function" + e);
            Reporter.log("Exception thrown in enterValue function : " + e);
            Assert.assertTrue(false, value +"  "+ desc + " is not displayed");
        }
    }

    /**
     * Function to enter keyboard actions
     *
     * @param locator
     * @param value
     * @throws ExceptionHelper
     */
    public void enterValue(By locator, Keys value) {
        try {
            waitHelper.waitForElementVisible(driver, locator, explicitWait, pollingTime).sendKeys(value);
        } catch (Exception e) {
            logger.error("Exception thrown in enterValue function" + e);
            Reporter.log("Exception thrown in enterValue function : " + e);
            Assert.assertTrue(false, value + " is not displayed");
        }
    }

    /**
     * Function to check if the title matches
     *
     * @param searchString
     * @throws ExceptionHelper
     */
    public void checkTitleMatch(final String searchString) throws ExceptionHelper {
        try {
            waitHelper.waitUntilTitleMatches(driver, searchString);
        } catch (Exception e) {
            logger.error("Title does not match Expected is : " + searchString + " Actual is : " + e);
            Reporter.log("Title does not match Expected is : " + searchString + " Actual is : " + e);
            throw new ExceptionHelper(e.getLocalizedMessage());
        }
    }

    public void checkElementIsDisplayed(By locator, String desc) {
        try {
            Assert.assertTrue(waitHelper.waitForIsDisplayed(driver, locator, Integer.parseInt(JsonConnector.getConfig("explicitWait")), 2));
            ThreadSafeExtent.getTest().log(Status.PASS,  desc+" is displayed" );
        } catch (Exception e) {
            logger.error("Element is not displayed : " + e);
            Reporter.log("Element is not displayed : " + e);
            ThreadSafeExtent.getTest().log(Status.FAIL,  desc+ " is actually not displayed");
            Assert.assertTrue(false, desc.replace("is displayed", "") + " is not displayed");
        }
    }

    public void checkElementIsDisplayed(By locator, String desc, int wait) {
        try {
            Assert.assertTrue(waitHelper.waitForIsDisplayed(driver, locator, wait, 1));
            Reporter.log(desc);
        } catch (Exception e) {
            logger.error("Element is not displayed : " + e);
            Reporter.log("Element is not displayed : " + e);
            Assert.assertTrue(false, desc + " is not displayed");
        }
    }

    public boolean checkIfElementIsDisplayed(By locator, String desc) {
        boolean flag = false;
        try {
            flag = waitHelper.waitForIsDisplayed(driver, locator, Integer.parseInt(JsonConnector.getConfig("explicitWait")), 2);
            Reporter.log("Checking the visibility of the element : " + desc + " : " + flag);
            logger.info("Element is displayed and flag is set to true");
        } catch (Exception e) {
            logger.info("Exception thrown inside checkIfElement...");
            Reporter.log("Checking the visibility of the element : " + desc + " : " + flag);
        }
        return flag;
    }

    public boolean checkIfElementIsDisplayed(By locator, String desc,int wait) {
        boolean flag = false;
        try {
            flag = waitHelper.waitForIsDisplayed(driver, locator,wait, 2);
            Reporter.log("Checking the visibility of the element : " + desc + " : " + flag);
            logger.info("Element is displayed and flag is set to true");
        } catch (Exception e) {
            logger.info("Exception thrown inside checkIfElement...");
            Reporter.log("Checking the visibility of the element : " + desc + " : " + flag);
        }
        return flag;
    }


    public void waitUntilElementIsNotVisibleAndClick(By locator1, By locator2, String desc) throws ExceptionHelper {
        try {
            if (waitHelper.waitForElementNotVisible(driver, locator1, explicitWait, pollingTime)) {
                waitHelper.waitForElementClickable(driver, locator2, explicitWait, pollingTime).click();
                Reporter.log(desc);
            } else {
                logger.error("Element is  displayed even after the explicitwait : ");
                Reporter.log("Element is  displayed even after the explicitwait: ");
            }

        } catch (Exception e) {
            logger.error("Element is not displayed : " + e);
            Reporter.log("Element is not displayed : " + e);
            throw new ExceptionHelper(e.getLocalizedMessage());
        }
    }

    /**
     * Function that returns the text from UI
     *
     * @param locator
     * @return
     * @throws ExceptionHelper
     */
    public String getText(By locator) {
        String text = null;
        try {
            text = waitHelper.waitForPresenceOfElement(driver, locator, explicitWait, pollingTime).getText();
            Reporter.log(text + " is the text got from the application");
        } catch (Exception e) {
            logger.error("Element is not displayed : " + e);
            Reporter.log("Element is not displayed : " + e);
            Assert.assertTrue(false, "Not able to get the text from UI" + e);
        }
        return text;
    }

    /**
     * Function to return count of total no of elements for the provided locator
     *
     * @param locator
     * @return
     * @throws ExceptionHelper
     */
    public int getListOfElementsCount(By locator) {
        int count = 0;
        try {
            waitHelper.waitForElementVisible(driver, locator, explicitWait, pollingTime);
            count = driver.findElements(locator).size();
            Reporter.log(count + " is the count got from the application");
        } catch (Exception e) {
            logger.error("Element is not displayed : " + e);
            Reporter.log("Element is not displayed : " + e);
            Assert.assertTrue(false, e.getMessage()+" failed in get List of elements count method");
        }
        return count;
    }


    /**
     * Function to make the execution wait for certain amount of time
     *
     * @param waittime
     */
    public void hardDelay(int waittime) {
        try {
            Thread.sleep(waittime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to generate random number to append to username to make it look dynamic
     *
     * @return
     */
    public String generateRandomNumber() {
        Random rnd = new Random();
        int number = rnd.nextInt(99);
        // this will convert any number sequence into 6 character.
        return String.format("%1d", number);
    }

    /**
     * Function to generate random number to append to username to make it look dynamic
     *
     * @return
     */
    public int generateRandomNumber(int no) {
        Random rnd = new Random();
        return rnd.nextInt(no)+01;
    }


    public int collectionSet(int no) {
        Random rnd = new Random();
        return rnd.nextInt(no)+1;
    }

    /**
     * Function to generate random number to append to username to make it look dynamic
     *
     * @return
     */
    public int generateRandomNumber(int low,int high) {
        Random r = new Random();
        int lower = low;
        int higher = high;
        return r.nextInt(higher-lower) + lower;
    }

    /**
     * Function to scroll to the element
     *
     * @param locator
     */
    public void scrollToView(By locator) {
        try {
            WebElement element = waitHelper.waitForElementVisible(driver, locator, explicitWait, pollingTime);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
        } catch (Exception e) {
            Assert.assertTrue(false, "Not able to scroll to view");
        }
    }

    /**
     * Function to switch to iframe & window
     *
     * @param id
     */
    public void switchToFrame(By locator, String id) {
        try {
            if (!id.isEmpty()) {
                waitHelper.waitForElementVisible(driver, locator, explicitWait, pollingTime);
                driver.switchTo().frame(id);
            } else {
                driver.switchTo().parentFrame();
            }
        } catch (Exception e) {
            Assert.assertTrue(false, "Not able to switch to frame" + e);
        }
    }

    public void switchToWindow(By locator){
        String Parent_Window = driver.getWindowHandle();
        Set<String> Child_Window = driver.getWindowHandles();
        try {
            for (String a: Child_Window){
                if (Parent_Window.equals(a)){
                    Reporter.log("Successfully Redirect to another window");
                }
                else {
                    driver.switchTo().window(a);
                    hardDelay(2000);
                    waitHelper.waitForElementClickable(driver, locator, explicitWait, pollingTime).click();
                    hardDelay(20000);
                    driver.switchTo().window(Parent_Window);
                }
            }
        }catch (Exception e){
            Assert.assertTrue(false, "Failed to redirect to another window" + e);
        }
    }



    public String trimString(String value) {
        try {
            value = value.trim().replace("#", "")
                    .replace("Application", "")
                    .replace("\n", "");
        } catch (Exception e) {

        }
        return value;
    }

    /**
     * Function to quit webdriver
     */
    public void quitDriver(){
        if(driver!=null){
            driver.close();
        }
    }

    /**
     * Function to perform click using javascript
     */
    public void jsClick(WebElement webElement,String desc){
        try{
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", webElement);
            logger.info("Click " + webElement.toString() + desc);
            Reporter.log(desc);
        }
        catch (Exception e){
            Assert.assertTrue(false,"Failed due to "+ e);
            Reporter.log("Failed due to "+e);
        }
    }

    /**
     * Function to perform clear text box using javascript
     */
    public void jsSetTextBox(By locator,String value){
        try {
            WebElement wb = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='"+value+"';", wb);
        }catch (Exception e){
            Assert.assertTrue(false,"Failed due to "+ e);
            Reporter.log("Failed due to "+e);
        }
    }

    /**
     * Function to get element
     */
    public WebElement getElement(By locator){
        WebElement element = null;
        try {
            element =  waitHelper.waitForPresenceOfElement(driver,locator,30,2);
        }catch(Exception e){
            Assert.assertTrue(false);
            Reporter.log("Failed due to "+ e.getLocalizedMessage());
        }
        return element;
    }

    /**
     * Function to wait for the page load
     */
    public void waitForPageLoadJs(){
        waitHelper.getWait(driver, Duration.ofDays(30),2).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void selectValueByIndex(By locator,int index,String desc){
        waitHelper.waitForPresenceOfElement(driver,locator,30,2);
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }

    public void selectByValue(By locator,String value,String desc){
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }


    public static void validation(WebElement ele,String value) {
        String attValue = ele.getAttribute("value");
        System.out.println("attribute"+attValue);
        if(!attValue.equalsIgnoreCase(value)) {
            Assert.assertEquals(attValue, false);
        }
    }


    public String CreatedPhoneNumber() {
        PhoneNumber = "8"+ generateRandomNumbers(9);;
        return PhoneNumber;
    }
    public String CreatedZipNumber() {
        PhoneNumber = "7"+ generateRandomNumbers(4);
        return PhoneNumber;
    }
    public String CreatedDummyName() {
        DummyName = "TestName " + generateRandomAlphabet(3);
        return DummyName;
    }

    public String CreatedDummyEmail() {
        DummyEmail = "sonali+1"+generateRandomNumbers(2)+"@myphysicianplan.com";
        return DummyEmail;
    }


    public String generateRandomAlphabet(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < length; i++) {
            result.append(alphabet.charAt(rnd.nextInt(alphabet.length())));
        }
        return result.toString();
    }
    public String generateRandomNumbers(int length) {
        String alphabet = "123456789";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < length; i++) {
            result.append(alphabet.charAt(rnd.nextInt(alphabet.length())));
        }
        return result.toString();
    }




    public void mouseHover(By locator, String desc) throws InterruptedException{
        try {
            WebElement element = waitHelper.waitForElementVisible(driver, locator, explicitWait, pollingTime);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();

            Thread.sleep(1000);

            if (!desc.isEmpty()) {
                Reporter.log(desc);

            }
        }
        catch (Exception e) {


            logger.error("Exception thrown in mouseHover function: " + e);
            Assert.assertTrue(false, "Not able to perform mouse hover: " + e);

        }
        Thread.sleep(1000);
    }

    public void scrollDown(By locator) {
        try {
            WebElement scrollableElement = waitHelper.waitForElementVisible(driver, locator, explicitWait, pollingTime);

            // Scroll inside the specific scrollable element
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop +=200", scrollableElement);

            Thread.sleep(500);

            // Scroll up slightly within the scrollable element
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop -=100 ;", scrollableElement);  // Adjust -300 as needed

        } catch (Exception e) {
            Assert.fail("Not able to scroll up within the element: " + e.getMessage());
        }
    }


    public void hoverAndClick(By hoverElementLocator, By clickElementLocator, String description) {
        try {
            WebElement hoverElement = waitHelper.waitForElementVisible(driver, hoverElementLocator, explicitWait, pollingTime);
            Actions actions = new Actions(driver);
            actions.moveToElement(hoverElement).perform();

            // Wait briefly if needed
            Thread.sleep(1000); // or use WebDriverWait for visibility of clickElementLocator

            WebElement clickElement = waitHelper.waitForElementClickable(driver, clickElementLocator, explicitWait, pollingTime);
            actions.moveToElement(clickElement).click().perform();

            if (!description.isEmpty()) {
                Reporter.log(description);
            }
        } catch (Exception e) {
            logger.error("Exception in hoverAndClick: " + e);
            Assert.fail("Unable to hover and click: " + e);
        }
    }

}
