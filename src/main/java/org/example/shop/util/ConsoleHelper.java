package org.example.shop.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static final Logger logger = LoggerFactory.getLogger(ConsoleHelper.class);
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void printLine(String line) {
        System.out.println(line);
    }
    public static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            logger.error("IOException occurred!", e);
            throw new RuntimeException(e);
        }
    }
}
