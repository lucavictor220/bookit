package handler;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import http.Server;
import model.Book;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.apache.commons.io.IOUtils;
import utils.JsonConverter;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import static java.lang.String.format;

public class PostHandler implements HttpHandler {

    private static final Logger LOGGER = Logger.getLogger(Server.class);

    public void handle(HttpExchange httpExchange) {
        LOGGER.info(format("[SERVER] --> Somebody access services: remote address = %s, request method = %s, request uri = %s",
                httpExchange.getRemoteAddress(), httpExchange.getRequestMethod(), httpExchange.getRequestURI()));
        try {
            InputStream is = httpExchange.getRequestBody();
            StringWriter writer = new StringWriter();
            IOUtils.copy(is, writer, "UTF-8");
            String requestBody = writer.toString();

            Book Book = (Book)JsonConverter.jsonToPojo(requestBody, Book.class);
            String response = "tuple was inserted";
            int status = 200;

            MongoClient mongoClient = new MongoClient();
            MongoDatabase mongoDatabase = mongoClient.getDatabase("lab4pad");
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("pad");

            mongoCollection.insertOne(Book.getDocument());

            httpExchange.sendResponseHeaders(status, response.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                ex.printStackTrace();
                String msg = "SERVER ERROR";
                httpExchange.sendResponseHeaders(500, msg.length());
                OutputStream os = httpExchange.getResponseBody();
                os.write(msg.getBytes(), 0, msg.length());
                os.close();
            } catch (Exception ex1) {
                ex.printStackTrace();
            }
        }
    }
}