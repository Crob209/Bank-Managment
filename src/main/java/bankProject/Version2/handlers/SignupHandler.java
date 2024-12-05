package bankProject.Version2.handlers;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import bankProject.Version2.models.SignupRequest;
import bankProject.Version2.models.SignupResponse;
import bankProject.Version2.SignUp;

public class SignupHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        SignupRequest signupData = new SignupRequest();
        signupData.Parse(new InputStreamReader(exchange.getRequestBody()));
        System.out.println("Incoming signup request: " + signupData.toString());

        SignupResponse signupResponse = SignUp.signup(signupData);
        String response = signupResponse.toString();
        System.out.println("Outgoing signup response: " + response);
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
