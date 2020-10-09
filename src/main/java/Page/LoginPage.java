package Page;

import TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage extends TestBase {

    @FindBy(xpath = "//a[@data-testid='loginButton']")
    WebElement LoginButton;

    @FindBy(xpath = "//input[@type='text']")
    WebElement phonenum;

    @FindBy(xpath = "//input[@type='password']")
    WebElement password;

    @FindBy(xpath = "//div[@role='button']")
    WebElement loginbutton;

    @FindBy(xpath = "//input[@type='text']")
    WebElement searchBar;

    // initializing the page objects
    public LoginPage() {   // constructor creation

        // this is  pointing to  current class object
        PageFactory.initElements(driver, this);
    }

    public void loginButton() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(LoginButton)).click();

    }

    public void userlogin(String pn, String pwd) {
        phonenum.sendKeys(pn);
        password.sendKeys(pwd);
    }

    public void loginclick() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(loginbutton)).click();
    }

    public void Search() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(searchBar)).sendKeys("@jannatZubair29_");
    }

    public void SearchSecondElement() {
      List<WebElement> ll =  driver.findElements(By.xpath("//div[@role='listbox']"));
      ll.size();
        System.out.println(ll.size());
        for(int i=0; i<ll.size(); i++){
           String s =  ll.get(i).getText();
           if(s.contains("JannatZubair Rahmani")){
               ll.get(i).click();
               break;
           }

        }
    }
}