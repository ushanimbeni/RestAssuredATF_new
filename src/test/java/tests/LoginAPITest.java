package tests;

import base.AuthService;
import io.restassured.response.Response;
import models.LoginRequest;
import models.LoginResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test(description = "Login tests")
    public void loginTest() {

        // Arrange
        AuthService authService = new AuthService();
        LoginRequest loginRequest =
                new LoginRequest("ushacn03", "Cybage@101010");
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse= response.as(LoginResponse.class);
        Assert.assertNotNull(loginResponse.getRoles());
        Assert.assertTrue(loginResponse.getId() > 0, "ID cannot be less than or equal to 0");

    }
}