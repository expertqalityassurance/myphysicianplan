package selenium;

import com.selenium.dataprovider.JsonDataProvider;
import com.selenium.ui.pageobjects.Loginsite.LoginPage;
import com.selenium.ui.pageobjects.Register.RegisterPagePeopleUS;
import com.selenium.ui.pageobjects.Register.RegisterPageStudents;
import com.selenium.ui.pageobjects.Register.RegisterPageTravelers;
import com.selenium.ui.pageobjects.Register.RegisterPageUSEmployers;
import com.selenium.ui.testbase.TestBase;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class MyPhysicianPlan extends TestBase {

	@Test(groups = {"Smoke_Test_NewUX", "Browserstack"},dataProvider = "TestData", dataProviderClass = JsonDataProvider.class,description = "Verify login", priority = 1)
	public void TC001_Login(String rowID, String description, JSONObject data) throws Exception {
		 new LoginPage().launchApplication().login();}

	@Test(groups = {"Smoke_Test_NewUX", "Browserstack"},dataProvider = "TestData", dataProviderClass = JsonDataProvider.class,description = "Verify Registration with Premium Comprehensive Plan", priority = 2)
	public void TC002_PremiumComprehensivePlan(String rowID, String description, JSONObject data) throws Exception {
		new LoginPage().launchApplication();
		new RegisterPageTravelers().RegistrationPremiumComprehensivePlan();
	}
	@Test(groups = {"Smoke_Test_NewUX", "Browserstack"},dataProvider = "TestData", dataProviderClass = JsonDataProvider.class,description = "Verify Registration with ComprehensivePlan", priority = 3)
	public void TC003_EssentialComprehensivePlan(String rowID, String description, JSONObject data) throws Exception {
		new LoginPage().launchApplication();
		new RegisterPageTravelers().RegistrationComprehensivePlan();
	}

	@Test(groups = {"Smoke_Test_NewUX", "Browserstack"},dataProvider = "TestData", dataProviderClass = JsonDataProvider.class,description = "Verify Registration Primary Care Plan", priority = 4)
	public void TC004_PrimaryCarePlan(String rowID, String description, JSONObject data) throws Exception {
		new LoginPage().launchApplication();
		new RegisterPageTravelers().RegistrationPrimaryCarePlan();
	}

	@Test(groups = {"Smoke_Test_NewUX", "Browserstack"},dataProvider = "TestData", dataProviderClass = JsonDataProvider.class,description = "Verify Registration with Student Plan", priority = 5)
	public void TC005_StudentPlan(String rowID, String description, JSONObject data) throws Exception {
		new LoginPage().launchApplication();
		new RegisterPageStudents().RegistrationStudentPlan();
	}

	@Test(groups = {"Smoke_Test_NewUX", "Browserstack"},dataProvider = "TestData", dataProviderClass = JsonDataProvider.class,description = "Verify with Registration Flexible US Care", priority = 6)
	public void TC006_FlexibleUSCare(String rowID, String description, JSONObject data) throws Exception {
		new LoginPage().launchApplication();
		new RegisterPageUSEmployers().RegistrationFlexibleUSCare();
	}

	@Test(groups = {"Smoke_Test_NewUX", "Browserstack"},dataProvider = "TestData", dataProviderClass = JsonDataProvider.class,description = "Verify with Registration Routine Medical Care", priority = 7)
	public void TC007_RoutineMedicalCare(String rowID, String description, JSONObject data) throws Exception {
		new LoginPage().launchApplication();
		new RegisterPageUSEmployers().RegistrationRoutineMedicalCare();
	}


	@Test(groups = {"Smoke_Test_NewUX", "Browserstack"},dataProvider = "TestData", dataProviderClass = JsonDataProvider.class,description = "Verify with Registration for US Flexible US Care", priority = 8)
	public void TC008_PeopleFlexibleUSCare(String rowID, String description, JSONObject data) throws Exception {
		new LoginPage().launchApplication();
		new RegisterPagePeopleUS().RegistrationFlexibleCare();
	}
	
	@Test(groups = {"Smoke_Test_NewUX", "Browserstack"},dataProvider = "TestData", dataProviderClass = JsonDataProvider.class,description = "Verify with Registration US Routine Medical Care", priority = 9)
	public void TC009_PeopleRoutineMedicalCare(String rowID, String description, JSONObject data) throws Exception {
		new LoginPage().launchApplication();
		new RegisterPagePeopleUS().RegistrationRoutineMedicalCare();

	}

	@Test(groups = {"Smoke_Test_NewUX", "Browserstack"},dataProvider = "TestData", dataProviderClass = JsonDataProvider.class,description = "Verify with Registration with Neuron Plan", priority = 10)
	public void TC010_RegistrationNeuronPlan(String rowID, String description, JSONObject data) throws Exception {
		new LoginPage().launchApplication();
		new RegisterPagePeopleUS().RegistrationNeuroPlan();

	}

}
