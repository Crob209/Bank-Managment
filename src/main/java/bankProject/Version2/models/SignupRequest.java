package bankProject.Version2.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.google.gson.Gson;

import bankProject.Version2.UserInfo;

public class SignupRequest extends UserInfo {
    public SignupRequest() {
        super();
    }

    public void Parse(InputStreamReader stream) {
        Gson gson = new Gson();
        try (BufferedReader bufferedReader = new BufferedReader(stream)) {
            SignupRequest json = gson.fromJson(bufferedReader, SignupRequest.class);
            this.setName(json.getName());
            this.setAge(json.getAge());
            this.setEmail(json.getEmail());
            this.setPhoneNumber(json.getPhoneNumber());
            this.setPassword(json.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
