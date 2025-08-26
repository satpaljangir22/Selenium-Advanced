package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By userName = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void LoginToApp(String loginUserName, String loginUserPassword){
        this.enterText(userName, loginUserName);
        this.enterText(password, loginUserPassword);
        this.clickElement(loginButton);
    }
}
