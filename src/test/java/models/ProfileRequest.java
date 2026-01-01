package models;

public class ProfileRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;

    public ProfileRequest(String firstName, String lastName, String email, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    // ✅ Private constructor used by Builder
    private ProfileRequest(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.mobileNumber = builder.mobileNumber;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getMobileNumber() { return mobileNumber; }

    // ✅ Static Builder class
    public static class Builder {

        private String firstName;
        private String lastName;
        private String email;
        private String mobileNumber;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        // ✅ build returns ProfileRequest
        public ProfileRequest build() {
            return new ProfileRequest(firstName,lastName,email,mobileNumber);
        }
    }
}
