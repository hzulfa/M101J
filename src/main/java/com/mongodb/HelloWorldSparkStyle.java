package com.mongodb;
import spark.*;
/**
 * Created by ummehunn on 6/30/2015.
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                response.type("text/plain");
                return "Hello World Spark Style";
            }
        });
    }
}
