package tests;

import base.AuthService;
import base.UserProfileManagementService;
import io.restassured.response.Response;
import models.LoginRequest;
import models.LoginResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProfileRequestTest {

    @Test(description = "Verify Get user profile API...")
    public void getUserprofileInfoTest()
    {
        AuthService authService = new AuthService();
        LoginRequest loginRequest =
                new LoginRequest("ushacn03", "Cybage@101010");
        Response response = authService.login(loginRequest);
        System.out.println(response.asPrettyString());
        LoginResponse loginResponse= response.as(LoginResponse.class);
        System.out.println("----------------------------------------------------");

        UserProfileManagementService userProfile = new UserProfileManagementService();
        response = userProfile.getUserProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        Assert.assertEquals(loginResponse.getEmail(),"ujsp0385@gmail.com");
    }
}
