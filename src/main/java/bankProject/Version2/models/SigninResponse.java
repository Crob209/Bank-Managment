package bankProject.Version2.models;

import com.google.gson.Gson;

public class SigninResponse {
    private boolean signinSuccess;
    private String errorMessage;
    private SigninRequest originalRequest;

    public SigninResponse(boolean signinSuccess, String errorMessage, SigninRequest originalRequest) {
        this.signinSuccess = signinSuccess;
        this.errorMessage = errorMessage;
        this.originalRequest = originalRequest;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
