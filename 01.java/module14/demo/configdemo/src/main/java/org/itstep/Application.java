package org.itstep;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Properties;

@Slf4j
public class Application {

    public static void main(String[] args) throws URISyntaxException, IOException {
        Instant start = Instant.now();

        Files.lines(Paths.get(Application.class.getClassLoader().getResource("config.properties").toURI()))
                .forEach(System.out::println);

        Properties properties = new Properties();
        properties.load(Application.class.getClassLoader().getResourceAsStream("config.properties"));

        String name = properties.getProperty("name");
        System.out.println(name);

        Duration d = Duration.between(start, Instant.now());
        log.info(String.format("Your code worked %s", d.toMillis()));
    }
}
