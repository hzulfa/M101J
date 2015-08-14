package com.mongodb;
import  freemarker.template.*;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by ummehunn on 7/2/2015.
 */
public class HelloWorldFreeMarkerStyle {
    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreeMarkerStyle.class, "/");
        configuration.setDirectoryForTemplateLoading(new File(
                "resources"));
        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String,Object>();
            helloMap.put("name", "FreeMarker");
            helloTemplate.process(helloMap, writer);
            System.out.print(writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
