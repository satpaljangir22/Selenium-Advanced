package org.example.test;

import io.qameta.allure.Description;
import org.example.HomePage;
import org.example.LoginPage;
import org.example.data.LoginUsers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTest{

    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void verifyTotalItems(){
            loginPage = new LoginPage(DriverFactory.getDriver());
            loginPage.LoginToApp(LoginUsers.STANDARD_USER, LoginUsers.STANDARD_PASSWORD);
            homePage = new HomePage(DriverFactory.getDriver());
            List<String> names = homePage.getAllProductNames();
            Assert.assertEquals(names.size(), 6, "Expected Item Total mismatched");
    }

    @Description("Verify that First Item has a Price.")
    @Test
    public void verifyItemPrices(){
            loginPage = new LoginPage(DriverFactory.getDriver());
            loginPage.LoginToApp(LoginUsers.STANDARD_USER, LoginUsers.STANDARD_PASSWORD);
            homePage = new HomePage(DriverFactory.getDriver());
            List<String> names = homePage.getAllProductNames();
            Assert.assertTrue(homePage.getItemPrice(names.get(0)) > 0, "Item Price <= 0");
    }
}
