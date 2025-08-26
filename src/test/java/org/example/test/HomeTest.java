package org.example.test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.example.HomePage;
import org.example.LoginPage;
import org.example.data.LoginUsers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest extends BaseTest{

    LoginPage loginPage;
    HomePage homePage;

    @Epic("Authentication")
    @Feature("Inventory")
    @Story("Total Visible Items")
    @Test
    public void verifyTotalItems(){
        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.LoginToApp(LoginUsers.STANDARD_USER, LoginUsers.STANDARD_PASSWORD);
        homePage = new HomePage(DriverFactory.getDriver());
        List<String> names = homePage.getAllProductNames();
        Assert.assertEquals(names.size(), 6);
    }

    @Description("Verify that First Item has a Price.")
    @Test
    public void verifyItemPrices(){
        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.LoginToApp(LoginUsers.STANDARD_USER, LoginUsers.STANDARD_PASSWORD);
        homePage = new HomePage(DriverFactory.getDriver());
        List<String> names = homePage.getAllProductNames();
        Assert.assertTrue(homePage.getItemPrice(names.get(0)) > 0);
    }
}
