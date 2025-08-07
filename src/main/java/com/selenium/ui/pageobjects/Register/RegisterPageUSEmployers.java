package com.selenium.ui.pageobjects.Register;

import com.selenium.ui.pageobjects.common.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterPageUSEmployers extends BasePage {

    public RegisterPageUSEmployers()
    {
        super();
    }

    By Register = By.cssSelector("div.col-lg-12:nth-child(2) > a:nth-child(6)");
    By USEmployers = By.xpath("//*[@id='headingEmployers']/h4/a");
    By select = By.xpath("//*[@id='collapseEmployers']/div/div/div[1]/a/div/div/div/button");
    By memberPlan= By.xpath("//*[@id='gridDefaultPlans']/div[2]/table/tbody/tr[1]/td[1]/input");
    By Next_ButtonMemberPlan  =By.xpath("//*[@id='tabstrip-1']/div/footer/button");
    By routineMedicalCare  =By.xpath(" //*[@id='collapseEmployers']/div/div/div[2]/a/div/div/div/button");


    By First_Name= By.xpath("//input[@id='FirstName']");
    By lastName = By.xpath("//*[@id='LastName']");
    By Date_of_Birth = By.xpath("//*[@id='DOB']");
    By Address= By.xpath("//*[@id='Address']");
    By City=By.xpath("//*[@id='CityName']");
    By Postal_Code=By.xpath("//*[@id='Zip']");
    By Email_Username=By.xpath("//*[@id='Email']");
    By Mobile_Code=By.xpath("//*[@id='CountryCode']");
    By MobileNumber =By.xpath("//*[@id='MobileNumber']");
    By Next_ButtonMember  =By.xpath("//*[@id='tabstrip-2']/footer/button[2]");


    By CardNumber =By.xpath("//*[@id='CardNumber']");
    By NameOnCard= By.xpath("//*[@id='NameOnCard']");
    By CVV=By.xpath("//*[@id='CVV']");
    By chkTerms= By.xpath("//*[@id='SecoundTime']");
    By Make_Payment= By.xpath("//*[@id='tabstrip-3']/div/footer/button[2]");
    By date= By.xpath("//*[@id='divCarddetails']/div[4]/div[1]/span[3]");
    By date_select= By.xpath("//*[@id='YY_listbox']/li[2]");
    By password= By.xpath(" //input[@id='Password']");
    By confirmpassword= By.xpath("//input[@id='ConfirmPassword']");

    public RegisterPageUSEmployers Registers()
    {
        click(Register, "Click on Register");
        return this;
    }

    public RegisterPageUSEmployers USEmployersPlansTravelers()
    {
        click(USEmployers, "Click on Travelers");
        return this;
    }

    public RegisterPageUSEmployers selectFlexibleUSCare()
    {
        click(select, "Click On Select Medical Plan For Travelers");
        return this;
    }
    public RegisterPageUSEmployers selectRoutineMedicalUSCare()
    {
        click(routineMedicalCare, "Click On Select Medical Plan For Travelers");
        return this;
    }
    public void NextButtonMemberPlan() {
        click(Next_ButtonMemberPlan,"Click on member plan");
    }
    public void travelerForm()
    {
        enterValue(First_Name,CreatedDummyName() ,"FirstName successfully");
        enterValue(lastName,CreatedDummyName(),"LastName successfully");
        enterValue(Date_of_Birth,"04/20/1998","Date of Birth successfully");
        enterValue(Address,"near station","Address successfully");
        enterValue(City,"California","City successfully");
        enterValue(Postal_Code,CreatedZipNumber(),"PostalCode successfully");
        enterValue(Email_Username,CreatedDummyEmail(),"Email/Username successfully");
        enterValue(Mobile_Code,"91","MobileCode successfully");
        enterValue(MobileNumber,CreatedPhoneNumber(),"MobileNumber successfully");

    }
    public void paymentForm() throws InterruptedException {
        enterValue(CardNumber,"4111111111111111","CardNumber successfully");
        click(date,"Entered date");
        click(date_select,"date successfully");
        enterValue(NameOnCard,CreatedDummyName(),"NameOnCard successfully");
        enterValue(CVV,"123","CVV successfully");
        click(chkTerms,"Selected chkTerms successfully");
        click(Make_Payment,"Payment successfully");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "MyPhysicianPlan New Member Registration", "Registration Confirmation");
        Thread.sleep(10000);

    }
    public void memberLoginCredentials(){

        enterValue(password,"Tester@1","Enter Password");
        enterValue(confirmpassword,"Tester@1", "Enter Confirm password");
        click(Next_ButtonMember,"Click on Next_Button Member");
    }
    public void RegistrationFlexibleUSCare() throws InterruptedException {
        Registers();
        USEmployersPlansTravelers();
        selectFlexibleUSCare();
        click(memberPlan,"Select member Plan");
        NextButtonMemberPlan();
        Thread.sleep(10000);
        travelerForm();
        memberLoginCredentials();
        paymentForm();
    }

    public void RegistrationRoutineMedicalCare() throws InterruptedException {

        Registers();
        USEmployersPlansTravelers();
        selectRoutineMedicalUSCare();
        click(memberPlan,"Select member Plan");
        NextButtonMemberPlan();
        Thread.sleep(10000);
        travelerForm();
        memberLoginCredentials();
        paymentForm();


    }

}
