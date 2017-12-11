import handler.PostHandler;
import http.Server;
import org.apache.log4j.Logger;

import java.io.IOException;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class);

    private static PostHandler postHandler;
    private static Server server;
    public static void main(String[] args) throws IOException {
        LOGGER.info("Logger successfully configured.");
        server = new Server();
        server.run();
    }
}
