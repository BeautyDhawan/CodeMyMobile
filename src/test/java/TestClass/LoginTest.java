package TestClass;

import Page.LoginPage;
import TestBase.TestBase;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage page;

    public LoginTest(){
        super();

    }
    @BeforeSuite
    public void setup() throws InterruptedException {
        Initializing();
        page = new LoginPage();
    }

    @Test(priority = 1)
    public void LoginButton()  {
       page.loginButton();
    }
    @Test(priority = 2)
    public void userloginTest()  {
        page.userlogin(prop.getProperty("phoneno"),prop.getProperty("password"));
        page.loginclick();
    }
    @Test(priority = 3)
    public void SearchProfile()  {
        page.Search();
    }
    @Test(priority = 4)
    public void Searchperson()  {
        page.SearchSecondElement();
    }

    @AfterSuite
    public void teardown(){

        //driver.quit();
    }
}
