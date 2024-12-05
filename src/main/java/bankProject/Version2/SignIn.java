package bankProject.Version2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import bankProject.Version2.models.SigninRequest;
import bankProject.Version2.models.SigninResponse;
import bankProject.Version2.UserInfo;

public class SignIn {

    public static SigninResponse signin(SigninRequest signinData) {
        UserInfo user = validateUser(signinData.getEmail(), signinData.getPassword());
        if (user != null) {
            System.out.println("Get email: " + user.getEmail());
            return new SigninResponse(true, "Signin successful", signinData);
        } else {
            return new SigninResponse(false, "Invalid email or password", signinData);
        }
    }

    public static UserInfo validateUser(String email, String password) {
        File folder = new File(UserInfo.USER_DATA_PATH);
        File[] listOfFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                UserInfo user = loadUserFromFile(file.getPath());
                if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    return user;
                }
            }
        }
        return null;
    }

    public static UserInfo loadUserFromFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            Gson gson = new Gson();
            return gson.fromJson(bufferedReader, UserInfo.class);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
        }
        return null;
    }
}
