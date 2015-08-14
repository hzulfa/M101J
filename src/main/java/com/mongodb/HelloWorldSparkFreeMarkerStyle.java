package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ummehunn on 7/2/2015.
 */
public class HelloWorldSparkFreeMarkerStyle {
    public static void main(String[] args) throws IOException {

        final Configuration configuration = new Configuration();
        final StringWriter writer = new StringWriter();
        configuration.setClassForTemplateLoading(HelloWorldFreeMarkerStyle.class, "/");
        configuration.setDirectoryForTemplateLoading(new File("resources"));
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                response.type("text/plain");
                try {
                    Template helloTemplate = configuration.getTemplate("hello.ftl");

                    Map<String, Object> helloMap = new HashMap<String,Object>();
                    helloMap.put("name", "SparkFreeMarker");
                    helloTemplate.process(helloMap, writer);
                    System.out.print(writer);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
                return writer;
            }
        });

    }
}
