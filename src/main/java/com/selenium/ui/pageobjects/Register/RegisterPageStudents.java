package com.selenium.ui.pageobjects.Register;

import com.selenium.ui.pageobjects.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class RegisterPageStudents extends BasePage {

    public RegisterPageStudents()
    {
        super();
    }

    By MedicalPlansStudent = By.xpath("//*[@id='headingStudents']/h4/a");
    By select = By.xpath("//*[@id='collapseStudents']/div/div/div/a/div/div/div/button");
    By startDate = By.xpath("//*[@id='tabstrip-1']/div/div[1]/div[1]/span[2]/span/span/span");
    By EndDate = By.xpath("//*[@id='tabstrip-1']/div/div[1]/div[2]/span[2]/span/span/span");
    By USzipCode = By.xpath("//*[@name='USZip']");
    By next = By.xpath("//*[@id='tabstrip-1']/div/footer/button");
    By firstName = By.xpath("//input[@id='firstName1']");
    By lastName = By.xpath("//input[@id='lastName1']");
    By DOB  = By.xpath("//input[@id='DOB1']");
    By address  = By.xpath("//input[@id='Address']");
    By city  = By.xpath("//input[@id='CityName']");
    By state  = By.xpath("//*[@id='tabstrip-2']/div[3]/div[2]/span[2]");
    By zipCode  = By.xpath("//input[@id='Zip']");
    By email  = By.xpath("//input[@id='Email']");
    By countryCode  = By.xpath("//input[@id='CountryCode']");
    By mobilenumber  = By.xpath("//input[@id='MobileNumber']");
    By memberNext  = By.xpath("//*[@id='tabstrip-2']/footer/button[2]");
    By CardNumber  = By.xpath("//input[@id='CardNumber']");
    By NameOnCard  = By.xpath("//input[@id='NameOnCard']");
    By expiryDate  = By.xpath("//*[@id='divCarddetails']/div[4]/div[1]/span[3]");
    By CVV  = By.xpath("//input[@id='CVV']");
    By accpet = By.xpath("//*[@id='chkTerms']");
    By payment  = By.xpath("//*[@id='tabstrip-3']/div/footer/button[2]");
    By Register = By.cssSelector("div.col-lg-12:nth-child(2) > a:nth-child(6)");
    By startdates = By.xpath("//*[@id='TravelStartDate']");
    By EndDates = By.xpath("//*[@id='TravelEndDate']");
    By states = By.xpath("//*[@id='StateName_option_selected']");

    public RegisterPageStudents Registers()
    {
        click(Register, "Click on Register");
        return this;
    }
    public void RegistrationStudentPlan() throws InterruptedException {
        Registers();
        click(MedicalPlansStudent,"Click on Medical Plans Student");
        click(select,"Click on Medical Plans Student");
        Thread.sleep(1000);
        click(startDate, "Click on StartDate and Its Selected");
        enterValue(startdates, Keys.ENTER);
        Thread.sleep(1000);
        click(EndDate,"");
        enterValue(EndDates, Keys.ARROW_DOWN);
        enterValue(EndDates, Keys.ARROW_DOWN);
        enterValue(EndDates, Keys.ARROW_DOWN);
        enterValue(EndDates, Keys.ARROW_DOWN);
        enterValue(EndDates, Keys.ARROW_DOWN);
        enterValue(EndDates, Keys.ENTER);
        enterValue(USzipCode,"73001","Enter Zip code");
        click(next,"Click on next");
        enterValue(firstName,CreatedDummyName() ,"FirstName successfully");
        enterValue(lastName,CreatedDummyName(),"LastName successfully");
        enterValue(DOB,"04/20/1998","Date of Birth successfully");
        enterValue(address,"near station","Address successfully");
        enterValue(city,"California","City successfully");
        click(state,"");
        enterValue(state, Keys.ARROW_DOWN);
        enterValue(states,Keys.ENTER);
        enterValue(zipCode,CreatedZipNumber(),"PostalCode successfully");
        enterValue(email,CreatedDummyEmail(),"Email/Username successfully");
        enterValue(countryCode,"91","MobileCode successfully");
        enterValue(mobilenumber,CreatedPhoneNumber(),"MobileNumber successfully");
        click(memberNext,"Click on next");
        enterValue(CardNumber,"4111111111111111","Enter Card number");
        enterValue(NameOnCard,"QA,Test","Enter Name on card");
        enterValue(expiryDate, Keys.ARROW_DOWN);
        enterValue(CVV,"123","");
        click(accpet,"Click on accept");
        click(payment,"Click on make Payment");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Member Registration Student", "Registration Confirmation");
        Thread.sleep(10000);

    }
}
