package tests;

import base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPasswordTests {

    @Test(description = "Verify forgot password API... ")
    public void forgotPasswordTest()
    {
        AuthService authService = new AuthService();
        Response response =  authService.forgotPassword("ujsp0385@gmail.com");
        System.out.println(response.asPrettyString());
    }
}
