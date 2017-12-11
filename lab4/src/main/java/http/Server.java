package http;

import com.sun.net.httpserver.HttpServer;
import handler.PostHandler;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    private static final Logger LOGGER = Logger.getLogger(Server.class);
    HttpServer server;

    private void init() throws IOException {
        this.server = HttpServer.create(new InetSocketAddress(6789), 0);
    }
    private void post() {
        server.createContext("/employee/post", new PostHandler());
    }

    private void start() {
        this.server.start();
    }

    public void run() throws IOException {
        init();
        post();
        start();
    }
}

