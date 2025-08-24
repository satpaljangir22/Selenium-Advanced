package org.example.data;

import org.testng.annotations.DataProvider;

public class LoginUsers {

    @DataProvider(name = "validUser", parallel = true)
    public static Object[][] getValidUsers() {
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }

    @DataProvider(name="inValidUser", parallel = true)
    public static Object[][] getInvalidUsers(){
        return new Object[][] {
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }
}
