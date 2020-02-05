package org.itstep;

import static spark.Spark.*;

public class Server {
    public static void main(String[] args) {
        staticFiles.location("/public");
        get("/", (req, resp) -> "Hello World");
    }
}
