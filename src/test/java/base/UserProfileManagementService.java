package base;

import io.restassured.response.Response;
import models.ProfileRequest;

public class UserProfileManagementService extends BaseService{
    private static final String BASE_PATH="/api/users/";

    public Response getUserProfile(String token)
    {
        setAuthToken(token);
        return getRequest(BASE_PATH+"profile");
    }

    public Response updateProfile(String token, ProfileRequest payload)
    {
        setAuthToken(token);
        return putRequest(payload,BASE_PATH+"profile");
    }
}
