package com.sedigital.backupapp.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Utilidad para la lectura segura de datos desde la entrada estándar.
 * <p>
 * Proporciona métodos estáticos para leer valores numéricos y cadenas,
 * validando el formato de entrada y solicitando reintentos cuando sea necesario.
 */
public class InputReader {
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Lee un número entero desde la entrada estándar.
     * <p>
     * Muestra el mensaje indicado y valida que el usuario introduzca
     * un valor entero, solicitando nuevamente en caso de error.
     *
     * @param prompt Mensaje mostrado al usuario antes de la lectura.
     * @return Número entero introducido por el usuario.
     */
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

    /**
     * Lee un número decimal desde la entrada estándar.
     * <p>
     * Muestra el mensaje indicado y valida que el usuario introduzca
     * un valor de tipo {@code double}, solicitando nuevamente en caso de error.
     *
     * @param prompt Mensaje mostrado al usuario antes de la lectura.
     * @return Número decimal introducido por el usuario.
     */
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

    /**
     * Lee una cadena de texto desde la entrada estándar.
     * <p>
     * Muestra el mensaje indicado y devuelve la línea introducida por el usuario.
     *
     * @param prompt Mensaje mostrado al usuario antes de la lectura.
     * @return Cadena introducida por el usuario.
     */
    public static String readString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
}
