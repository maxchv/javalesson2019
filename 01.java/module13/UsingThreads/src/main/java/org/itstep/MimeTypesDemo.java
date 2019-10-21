package org.itstep;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class MimeTypesDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://github.com/maxchv/javalesson2019/raw/master/books/java%20%D0%B4%D0%BB%D1%8F%20%D0%BF%D1%80%D0%BE%D1%84%D0%B5%D1%81%D1%81%D0%B8%D0%BE%D0%BD%D0%B0%D0%BB%D0%BE%D0%B2.pdf");
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        System.out.println(urlConnection.getContentType());
        Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
        for(Map.Entry<String, List<String>> header: headerFields.entrySet()) {
            System.out.println(header.getKey() + ": " + header.getValue());
        }
    }
}
