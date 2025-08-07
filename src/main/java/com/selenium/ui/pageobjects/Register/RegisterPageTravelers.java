package com.selenium.ui.pageobjects.Register;

import com.selenium.ui.pageobjects.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

public class RegisterPageTravelers extends BasePage {

    public RegisterPageTravelers()
    {
        super();
    }

    By Register = By.cssSelector("div.col-lg-12:nth-child(2) > a:nth-child(6)");
    By Travelers = By.cssSelector("#headingTravelers > h4:nth-child(1) > a:nth-child(1)");
    By selectPremiumPlan = By.cssSelector("#collapseTravelers > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(2)");
    By selectEssentialPlan= By.xpath("//*[@id='collapseTravelers']/div/div/div[2]/a/div/div/div/button");
    By selectPrimaryPlan =  By.xpath("//*[@id='collapseTravelers']/div/div/div[3]/a/div/div/div/button");
    By startDate = By.xpath("//*[@id='tabstrip-1']/div/div[1]/div[1]/span[2]/span/span/span");
    By startdates = By.xpath("//*[@id='TravelStartDate']");
    By EndDate = By.xpath("//*[@id='tabstrip-1']/div/div[1]/div[2]/span[2]/span/span/span");
    By EndDates = By.xpath("//*[@id='TravelEndDate']");
    By country= By.xpath("//*[@id='tabstrip-1']/div/div[2]/div/span[2]");
    By zipCode = By.xpath("//*[@name='USZip']");
    By getQuote = By.xpath("//button[text()='Get Quote']");
    By Next= By.xpath("//*[@id='btnPlanNext']");
    By First_Name= By.xpath("//input[@id='firstName1']");
    By lastName = By.xpath("//*[@id='lastName1']");
    By Date_of_Birth = By.xpath("//*[@id='DOB1']");
    By Address= By.xpath("//*[@id='Address']");
    By City=By.xpath("//*[@id='CityName']");
    By Postal_Code=By.xpath("//*[@id='Zip']");
    By Email_Username=By.xpath("//*[@id='Email']");
    By Mobile_Code=By.xpath("//*[@id='CountryCode']");
    By MobileNumber =By.xpath("//*[@id='MobileNumber']");
    By Next_ButtonComprehensive  =By.xpath("//*[@id='divMembers']/footer/button[2]");
    By Next_ButtonMember  =By.xpath("//*[@id='tabstrip-2']/footer/button[2]");
    By Next_ButtonMemberPlan  =By.xpath("//*[@id='tabstrip-1']/div/footer/button");

    By CardNumber =By.xpath("//*[@id='CardNumber']");
    By NameOnCard= By.xpath("//*[@id='NameOnCard']");
    By CVV=By.xpath("//*[@id='CVV']");
    By chkTerms= By.xpath("//*[@id='chkTerms']");
    By Make_Payment= By.xpath("//*[@id='tabstrip-4']/div/footer/button[2]");
    By date= By.xpath("//*[@id='divcarddetails']/div[2]/div[1]/span[3]/span");
    By date_select= By.xpath("//*[@id='YY_listbox']/li[2]");
    By comprehensivePlan= By.xpath("//*[@id='pivotTableEssential']/tbody/tr[1]/td[2]/label/span[1]");
    By memberPlan= By.xpath("//*[@id='gridDefaultPlans']/div[2]/table/tbody/tr[1]/td[1]/input");
    By password= By.xpath(" //input[@id='Password']");
    By confirmpassword= By.xpath("//input[@id='ConfirmPassword']");

    By firstNameMember= By.xpath("//input[@id='FirstName']");
    By lastNameMember = By.xpath("//*[@id='LastName']");
    By DateofBirthMember = By.xpath("//*[@id='DOB']");
    By AddressMember= By.xpath("//*[@id='Address']");
    By CityMember=By.xpath("//*[@id='CityName']");
    By PostalCodeMember=By.xpath("//*[@id='Zip']");
    By EmailUsernameMember=By.xpath("//*[@id='Email']");
    By MobileCodeMember=By.xpath("//*[@id='CountryCode']");
    By MobileNumberMember =By.xpath("//*[@id='MobileNumber']");
    By NextButtonMemberMember  =By.xpath("//*[@id='tabstrip-2']/footer/button[2]");

    By dateOfexpiry =By.xpath("//*[@id='divCarddetails']/div[4]/div[1]/span[3]");
    By dateOfexpirySelect =By.xpath("//*[@id='YY_listbox']");
    By checktermsMember =By.xpath("//*[@id='SecoundTime']");
    By makePaymentMember =By.xpath("//*[@id='tabstrip-3']/div/footer/button[2]");



    public RegisterPageTravelers Registers()
    {
        click(Register, "Click on Register");
        return this;
    }
    public RegisterPageTravelers MedicalPlansTravelers()
    {
        click(Travelers, "Click on Travelers");
        return this;
    }
    public RegisterPageTravelers selectPremiumComprehensive()
    {
        click(selectPremiumPlan, "Click On Select Medical Plan For Travelers");
        return this;
    }
    public RegisterPageTravelers selectEssentialComprehensive()
    {
        click(selectEssentialPlan, "Click On Select Medical Plan For Travelers");
        return this;
    }
    public RegisterPageTravelers selectPrimaryCare()
    {
        click(selectPrimaryPlan, "Click On Select Medical Plan For Travelers");
        return this;
    }
    public void datesform() throws InterruptedException {
        click(startDate, "Click on StartDate and Its Selected");
        enterValue(startdates, Keys.ENTER);
        click(EndDate, "Click on EndDate and Its Selected");
        enterValue(EndDates, Keys.ARROW_DOWN);
        enterValue(EndDates, Keys.ENTER);
        enterValue(country,Keys.ENTER);
        Thread.sleep(1000);
        click(zipCode, "Entered zipCode");
        enterValue(zipCode,CreatedZipNumber(),"zipCode successfully");
        click(getQuote,"");
        Thread.sleep(1000);
    }
    public void clickOnNext ()
    {
        click(Next,"");
    }
    public void quoteformforEssentialPlan()
    {
      click(comprehensivePlan,"Select the plan");
    }
    public void clickNext_ButtonComprehensive(){

        click(Next_ButtonComprehensive,"Fill All Information successfully");
    }
    public void memberLoginCredentials()
    {
        enterValue(password,"Tester@1","Enter Password");
        enterValue(confirmpassword,"Tester@1", "Enter Confirm password");
        click(Next_ButtonMember,"Click on Next_Button Member");
    }
    public void NextButtonMemberPlan() {
        click(Next_ButtonMemberPlan,"Click on member plan");
    }
    public void travelerForm()
    {
        enterValue(First_Name,CreatedDummyName() ,"Enter FirstName successfully");
        enterValue(lastName,CreatedDummyName(),"LastName successfully");
        enterValue(Date_of_Birth,"04/20/1998","Date of Birth successfully");
        enterValue(Address,"near station","Address successfully");
        enterValue(City,"California","City successfully");
        enterValue(Postal_Code,CreatedZipNumber(),"PostalCode successfully");
        enterValue(Email_Username,CreatedDummyEmail(),"Email/Username successfully");
        enterValue(Mobile_Code,"91","MobileCode successfully");
        enterValue(MobileNumberMember,CreatedPhoneNumber(),"MobileNumber successfully");

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
        Assert.assertEquals(actualTitle, "Member Registration Travel", "Registration Confirmation");
        Thread.sleep(10000);

    }
    public void RegistrationPremiumComprehensivePlan() throws InterruptedException {
        Reporter.log("********* " + new Throwable().getStackTrace()[0].getMethodName() + " *********");
        Registers();
        MedicalPlansTravelers();
        selectPremiumComprehensive();
        datesform();
        clickOnNext();
        travelerForm();
        clickNext_ButtonComprehensive();
        paymentForm();

    }
    public void RegistrationComprehensivePlan() throws InterruptedException {
        Reporter.log("********* " + new Throwable().getStackTrace()[0].getMethodName() + " *********");
        Registers();
        MedicalPlansTravelers();
        selectEssentialComprehensive();
        datesform();
        quoteformforEssentialPlan();
        clickOnNext();
        travelerForm();
        clickNext_ButtonComprehensive();
        paymentForm();
    }
    public void RegistrationPrimaryCarePlan() throws InterruptedException {
        Registers();
        MedicalPlansTravelers();
        selectPrimaryCare();
        click(memberPlan,"Select member Plan");
        NextButtonMemberPlan();
        Thread.sleep(10000);
        enterValue(firstNameMember,CreatedDummyName() ,"Enter FirstName successfully");
        enterValue(lastNameMember,CreatedDummyName(),"LastName successfully");
        enterValue(DateofBirthMember,"04/20/1998","Date of Birth successfully");
        enterValue(AddressMember,"near station","Address successfully");
        enterValue(CityMember,"California","City successfully");
        enterValue(PostalCodeMember,CreatedZipNumber(),"PostalCode successfully");
        enterValue(EmailUsernameMember,CreatedDummyEmail(),"Email/Username successfully");
        enterValue(MobileCodeMember,"91","MobileCode successfully");
        enterValue(MobileNumberMember,CreatedPhoneNumber(),"MobileNumber successfully");
        memberLoginCredentials();
        enterValue(CardNumber,"4111111111111111","CardNumber successfully");
        click(dateOfexpiry,"Entered date");
        click(date_select,"date successfully");
        enterValue(NameOnCard,CreatedDummyName(),"NameOnCard successfully");
        enterValue(CVV,"123","CVV successfully");
        click(checktermsMember,"Selected chkTerms successfully");
        click(makePaymentMember,"Payment successfully");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "MyPhysicianPlan New Member Registration", "Registration Confirmation");
        Thread.sleep(10000);
    }

}

