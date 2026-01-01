package tests;

import base.AuthService;
import base.UserProfileManagementService;
import io.restassured.response.Response;
import models.LoginRequest;
import models.LoginResponse;
import models.ProfileRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class UpdateProfileTest {

    @Test(description = "Verify update profile API...")
    public void testUpdateProfile()
    {
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("ushacn03", "Cybage@101010") );
        LoginResponse loginResponse= response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());
        System.out.println("-----------------Original profile------------------------");

        UserProfileManagementService userProfile = new UserProfileManagementService();
        response = userProfile.getUserProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        System.out.println("----------------Updated profile------------------------");

        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .firstName("Heema")
                .lastName("bhutt")
                .mobileNumber("9513010160")
                .build();
        response = userProfile.updateProfile(loginResponse.getToken(),profileRequest);
        System.out.println(response.asPrettyString());
    }

}
