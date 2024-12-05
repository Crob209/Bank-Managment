package bankProject.Version2.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.google.gson.Gson;

public class SigninRequest {
    private String password;
    private String email;

    public SigninRequest() {}

    public void Parse(InputStreamReader stream) {
        Gson gson = new Gson();
        try (BufferedReader bufferedReader = new BufferedReader(stream)) {
            SigninRequest json = gson.fromJson(bufferedReader, SigninRequest.class);
            this.email = json.email;
            this.password = json.password;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
