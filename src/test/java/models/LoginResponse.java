package models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {

    private String token;
    private String type;
    private int id;

    @JsonProperty("username")  // Maps JSON "username" to this field
    private String username;

    private String email;
    private List<String> roles;

    // Getters
    public String getToken() { return token; }
    public String getType() { return type; }
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public List<String> getRoles() { return roles; }

    // No-arg constructor
    public LoginResponse() {}

    // All-args constructor
    public LoginResponse(String token, String type, int id, String username, String email, List<String> roles) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
