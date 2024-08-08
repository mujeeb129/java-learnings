package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class SimpleHttpServer {
    private static final int PORT = 8000;
    private static final Map<String, String> data = new HashMap<>();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server    started on port " + PORT);
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();
            String path = exchange.getRequestURI().getPath();
            String query = exchange.getRequestURI().getQuery();
            System.out.println(query);

            switch (method) {
                case "GET":
                    handleGet(exchange, path);
                    break;
                case "POST":
                    handlePost(exchange, path);
                    break;
                case "PATCH":
                    handlePatch(exchange, path);
                    break;
                case "DELETE":
                    handleDelete(exchange, path);
                    break;
                default:
                    // Handle unsupported methods
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_GATEWAY, -1);
            }
        }

        private void handleGet(HttpExchange exchange, String path) throws IOException {
            // Implement GET logic here
            String response = "GET request received for path: " + path;
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        }

        private void handlePost(HttpExchange exchange, String path) throws IOException {
            // Implement POST logic here
            String response = "POST request received for path: " + path;
            System.out.println(response);
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        }

        private void handlePatch(HttpExchange exchange, String path) throws IOException {
            // Implement PATCH logic here
            String response = "PATCH request received for path: " + path;
            System.out.println(response);
        }

        private void handleDelete(HttpExchange exchange, String path) throws IOException {
            // Implement DELETE logic here
            String response = "DELETE request received for path: " + path;
            System.out.println(response);
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        }
    }
}
