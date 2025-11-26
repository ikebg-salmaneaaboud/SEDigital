package com.sedigital.backupapp.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {
    private static final Scanner sc = new Scanner(System.in);

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Introduce un número entero.");
                sc.nextLine();
            }
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Introduce un número decimal.");
                sc.nextLine();
            }
        }
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
}
