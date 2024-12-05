package bankProject.Version2;

import java.util.Scanner;

public class Validation {
	//TODO:Create a method that checks user exits check for number and email
	  
	public static boolean emailValidation(String email) {
		 try {
		 String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
        } catch (java.util.regex.PatternSyntaxException e) {
       	 System.err.println("Invalid email please try again" + e.getMessage());
        }
		 return false;
	 }
	 public static boolean validPhoneNumber(String phoneNumber) {
		 try {
			 String ephonePattern = "^(\\d{3}[- .]?){2}\\d{4}$";
	         java.util.regex.Pattern p = java.util.regex.Pattern.compile(ephonePattern);
	         java.util.regex.Matcher m = p.matcher(phoneNumber);
	         return m.matches();
	         } catch (java.util.regex.PatternSyntaxException e) {
	        	 System.err.println("Invalid phone number please try again" + e.getMessage());
	         }
			 return false;
		 }
	 //Do not need this when GUI only validation
	 public static String getPasswordFromUser() {
	        Scanner scanner = new Scanner(System.in);
	        String password;
	        do {
	            System.out.println("Create your password:");
	            password = scanner.nextLine();
	            if (!passWordValidation(password)) {
	                System.out.println("Password does not meet the criteria. Please try again.");
	            }
	        } while (!passWordValidation(password));
	        return password;
	    }

	    public static boolean passWordValidation(String passWord) {
	        if (!passWord.matches(".*[A-Z].*")) {
	            System.err.println("Password must contain at least one uppercase letter.");
	            return false;
	        }
	        if (!passWord.matches(".*[a-z].*")) {
	            System.err.println("Password must contain at least one lowercase letter.");
	            return false;
	        }
	        if (!passWord.matches(".*[0-9].*")) {
	            System.err.println("Password must contain at least one digit.");
	            return false;
	        }
	        if (!passWord.matches(".*[!@#$%^&*()].*")) {
	            System.err.println("Password must contain at least one special character (!@#$%^&*()).");
	            return false;
	        }
	        return true;
	    }
	}
	 
	 

	 

