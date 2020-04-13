package com.matthem;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String inputPrompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(inputPrompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            writeString("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static void writeString(String str) {
        System.out.println(str);
    }
}
