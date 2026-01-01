package tests;

import base.AuthService;
import io.restassured.response.Response;
import models.SignupRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataGenerator;

public class SignupAPITest {

    private AuthService authService = new AuthService();
    private SignupRequest lastSignupRequest;

    @Test(description = "Successful signup with unique user data")
    public void successfulSignupTest() {
        // Generate unique user data
        lastSignupRequest = TestDataGenerator.generateSignupRequest();

        // Send signup request
        Response response = authService.registerUser(lastSignupRequest);

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertEquals(response.asString().trim(), "User registered successfully!",
                "Response message should confirm successful registration");

        // Debug output
        System.out.println("Signup Response:\n" + response.asPrettyString());
    }

    @Test(description = "Verify duplicate username error",
            dependsOnMethods = {"successfulSignupTest"})
    public void duplicateUsernameTest() {
        // Resubmit the same request to trigger duplicate error
        Response response = authService.registerUser(lastSignupRequest);

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 400, "Status code should be 400 for duplicate username");
        Assert.assertEquals(response.asString().trim(), "Error: Username is already taken!",
                "Response should indicate duplicate username");

        // Debug output
        System.out.println("Duplicate Signup Response:\n" + response.asPrettyString());
    }
}
