package com.matthem.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExceptionsDemo {
    public static void showFile() {
        var filePath = Paths.get(
                System.getProperty("user.dir"),
                "src/main/resources", "file.txt").toAbsolutePath();

        try (
            var reader = Files.newBufferedReader(filePath);
            var writer = Files.newBufferedWriter(Path.of(".."))
        ) {
            var value = reader.read();
        } catch (IOException ie) {
            System.out.println("Could not read data.");
        }
    }

    public static void show() throws IOException {
        var account = new Account();
        try {
            account.withdraw(10);
        } catch (AccountException e) {
            var cause = e.getCause();
            System.out.println(cause.getMessage());
        }
    }

    // NullPointerException Demo
    public static void sayHello(String name) {
        System.out.println(name.toUpperCase());
    }

    // ArrayIndexOutOfBoundsException Demo
    public static void accessArrayElementAt(int index) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(numbers[index]);
    }
}
