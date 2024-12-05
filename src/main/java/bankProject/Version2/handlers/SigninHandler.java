package bankProject.Version2.handlers;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import bankProject.Version2.models.SigninRequest;
import bankProject.Version2.models.SigninResponse;
import bankProject.Version2.SignIn;

public class SigninHandler implements HttpHandler {
   
    public void handle(HttpExchange exchange) throws IOException {
        SigninRequest signinData = new SigninRequest();
        signinData.Parse(new InputStreamReader(exchange.getRequestBody()));
        System.out.println("Incoming login request: " + signinData.toString());

        SigninResponse signinResponse = SignIn.signin(signinData);
        String response = signinResponse.toString();
        System.out.println("Outgoing login response: " + response);
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
