package bankProject.Version2.models;

import com.google.gson.Gson;

import bankProject.Version2.UserInfo;

public class SignupResponse {
    private boolean signupSuccess;
    private String message;
    private UserInfo userInfo; 

    public SignupResponse(boolean signupSuccess, String message, UserInfo userInfo) {
        this.signupSuccess = signupSuccess;
        this.message = message;
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
