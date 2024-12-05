package bankProject.Version2;

import com.sun.net.httpserver.HttpServer;
import bankProject.Version2.handlers.SigninHandler;
import bankProject.Version2.handlers.SignupHandler;
import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleHttpServer {
    public static void StartServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // Add Signin and Signup endpoints
        server.createContext("/signin", new SigninHandler());
        server.createContext("/signup", new SignupHandler());

        server.setExecutor(null);  // Default executor
        server.start();

        System.out.println("Server is running on port 8000");
    }
}
