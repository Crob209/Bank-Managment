package bankProject.Version2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInfo {
    public static final String USER_DATA_PATH = "data";
    private String name;
    private int age;
    private String email;
    private String phoneNumber;
    private String password;

    public UserInfo() {}

    public UserInfo(String name, int age, String email, String phoneNumber, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be a negative number");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String fileName() {
        return getName() + ".json";
    }
    

    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public void userSave() {
        try {
            Files.createDirectories(Paths.get(USER_DATA_PATH));
            Gson gson = new Gson();
            String userInfoJson = gson.toJson(this);

            try (FileWriter fw = new FileWriter(USER_DATA_PATH + "/" + fileName())) {
                fw.write(userInfoJson);
            }
        } catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
        }
    }

    public static UserInfo load(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            Gson gson = new Gson();
            return gson.fromJson(bufferedReader, UserInfo.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

   
}
