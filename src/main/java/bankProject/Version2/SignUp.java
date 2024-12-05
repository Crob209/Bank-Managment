package bankProject.Version2;


import bankProject.Version2.Validation;
import bankProject.Version2.models.SignupRequest;
import bankProject.Version2.models.SignupResponse;

public class SignUp {

    public static SignupResponse signup(SignupRequest signupData) {
      
        if (signupData.getName() == null || signupData.getName().isEmpty()) {
            return new SignupResponse(false, "Name cannot be empty", signupData);
        }

        // Email validation
        if (!Validation.emailValidation(signupData.getEmail())) {
            return new SignupResponse(false, "Invalid email format", signupData);
        }

        // Phone number validation
        if (!Validation.validPhoneNumber(signupData.getPhoneNumber())) {
            return new SignupResponse(false, "Invalid phone number", signupData);
        }

        // Password validation
        if (!Validation.passWordValidation(signupData.getPassword())) {
            return new SignupResponse(false, "Weak password", signupData);
        }

        // Save user info if valid
        signupData.userSave(); 
        System.out.println("User signed up successfully: " + signupData.getEmail());
        return new SignupResponse(true, "Signup successful", signupData);
    }
}
