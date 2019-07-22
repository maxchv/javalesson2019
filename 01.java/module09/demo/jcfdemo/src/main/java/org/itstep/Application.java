package org.itstep;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;

@Slf4j
public class Application {

    public static void main(String[] args) {
        Instant start = Instant.now();

        // TODO: write your code here

        Duration d = Duration.between(start, Instant.now());
        log.info(String.format("Your code worked %s", d));
    }
}
