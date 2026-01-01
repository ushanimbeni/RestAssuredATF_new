package base;

import io.restassured.response.Response;

import java.util.HashMap;

public class AuthService extends BaseService {

    private static final String BASE_PATH = "/api/auth/";

    public Response login(Object payload){
        return postRequest(payload,BASE_PATH+"login");
    }

    public Response registerUser(Object payload){
        return postRequest(payload,BASE_PATH+"signup");
    }

    public Response forgotPassword(String emailAdress)
    {
        HashMap<String,String> payload = new HashMap<>();
        payload.put("email",emailAdress);
        return postRequest(payload,BASE_PATH+"forgot-password");

    }

}
