package com.selenium.ui.pageobjects.Register;

import com.selenium.ui.pageobjects.common.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterPagePeopleUS extends BasePage {

    public RegisterPagePeopleUS()
    {
        super();
    }

    By Register = By.cssSelector("div.col-lg-12:nth-child(2) > a:nth-child(6)");
    By USPeople= By.xpath("//*[@id='headingResidents']/h4/a");
    By selectUSCare= By.xpath("//*[@id='collapseResidents']/div/div/div[1]/a/div/div/div/button");
    By selectNeuroPlan= By.xpath("//*[@id='collapseResidents']/div/div/div[3]/a/div/div/div/button");
    By routineMedicalCare= By.xpath("//*[@id='collapseResidents']/div/div/div[2]/a/div/div/div/button");
    By memberPlan= By.xpath("//*[@id='gridDefaultPlans']/div[2]/table/tbody/tr[1]/td[1]/input");
    By Next_ButtonMemberPlan  =By.xpath("//*[@id='tabstrip-1']/div/footer/button");

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

    By Next_ButtonPlan  =By.xpath("//*[@id='tabstrip-2']/div/footer/button[2]");


    By CardNumber =By.xpath("//*[@id='CardNumber']");
    By NameOnCard= By.xpath("//*[@id='NameOnCard']");
    By CVV=By.xpath("//*[@id='CVV']");
    By chkTerms= By.xpath("//*[@id='SecoundTime']");
    By Make_Payment= By.xpath("//*[@id='tabstrip-4']/div/footer/button[2]");
    By date= By.xpath("//*[@id='divCarddetails']/div[4]/div[1]/span[3]");
    By date_select= By.xpath("//*[@id='YY_listbox']/li[2]");
    By password= By.xpath(" //input[@id='Password']");
    By confirmpassword= By.xpath("//input[@id='ConfirmPassword']");

    By RoutineMedicalMake_Payment= By.xpath("//*[@id='tabstrip-3']/div/footer/button[2]");
    By zipCode= By.xpath("//*[@id='SearchZip']");
    By nextZipCode= By.xpath("//*[@id='divProviderSelection']/div[1]/div[1]/button");
    By neuroPlan = By.xpath("//*[@id='gridDefaultPlans']/table/tbody/tr/td[1]/input");
    By nextMemberDetails = By.xpath("//*[@id='tabstrip-3']/footer/button[2]");


    public RegisterPagePeopleUS Registers()
    {
        click(Register, "Click on Register");
        return this;
    }

    public RegisterPagePeopleUS USEmployersPlansTravelers()
    {
        click(USPeople, "Click on Travelers");
        return this;
    }
    public RegisterPagePeopleUS clickOnSelectUSCare()
    {
        click(selectUSCare, "Click on Travelers");
        return this;
    }
    public RegisterPagePeopleUS clickOnSelectmedicalCare()
    {
        click(routineMedicalCare, "Click on Travelers");
        return this;
    }
    public RegisterPagePeopleUS clickOnSelectNeuroPlan()
    {
        click(selectNeuroPlan, "Click on Travelers");
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
        Thread.sleep(100000);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Member Registration", "Registration Confirmation");

    }

    public void paymentFormForRoutine() throws InterruptedException {
        enterValue(CardNumber,"4111111111111111","CardNumber successfully");
        click(date,"Entered date");
        click(date_select,"date successfully");
        enterValue(NameOnCard,CreatedDummyName(),"NameOnCard successfully");
        enterValue(CVV,"123","CVV successfully");
        click(chkTerms,"Selected chkTerms successfully");
        click(RoutineMedicalMake_Payment,"Payment successfully");
        Thread.sleep(100000);
    }


    public void RegistrationVerification() throws InterruptedException {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "MyPhysicianPlan New Member Registration", "Registration Confirmation");

    }
    public void RegistrationVerificationForNeuro() throws InterruptedException {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Member Registration", "Registration Confirmation");

    }

    public void memberLoginCredentials(){

        enterValue(password,"Tester@1","Enter Password");
        enterValue(confirmpassword,"Tester@1", "Enter Confirm password");
        click(Next_ButtonMember,"Click on Next_Button Member");
    }

    public void RegistrationFlexibleCare() throws InterruptedException {

        Registers();
        USEmployersPlansTravelers();
        clickOnSelectUSCare();
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
        clickOnSelectmedicalCare();
        click(memberPlan,"Select member Plan");
        NextButtonMemberPlan();
        Thread.sleep(10000);
        travelerForm();
        memberLoginCredentials();
        paymentFormForRoutine();
    }

    public void RegistrationNeuroPlan() throws InterruptedException {

        Registers();
        USEmployersPlansTravelers();
        clickOnSelectNeuroPlan();
        Thread.sleep(1000);
        enterValue(zipCode,"73001","Enter Zip Code");
        click(nextZipCode,"Click on Next");
        Thread.sleep(1000);
        scrollToView(Next_ButtonMemberPlan);
        NextButtonMemberPlan();
        click(neuroPlan,"Select Neuro Plan");
        click(Next_ButtonPlan,"Click on Next_Button Member");
        travelerForm();
        click(nextMemberDetails,"Click on next member details ");
        paymentForm();
    }

}

