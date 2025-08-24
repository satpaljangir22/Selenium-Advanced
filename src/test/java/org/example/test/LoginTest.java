package org.example.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.LoginPage;
import org.example.data.LoginUsers;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test(dataProvider = "validUser", dataProviderClass = LoginUsers.class)
    public void loginStandardUsers(String userName, String userPassword) {
        loginPage = new LoginPage(driver);
        loginPage.LoginToApp(userName, userPassword);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", userName + " Failed");
    }

    @Test(dataProvider = "inValidUser", dataProviderClass = LoginUsers.class)
    public void loginInvalidUsers(String userName, String userPassword){
        loginPage = new LoginPage(driver);
        loginPage.LoginToApp(userName, userPassword);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", userName + " Failed");
    }
}
