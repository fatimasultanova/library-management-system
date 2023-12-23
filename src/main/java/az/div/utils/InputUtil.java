package az.div.utils;

import java.util.Scanner;

public class InputUtil {
    public static int inputInt(String title){
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextInt();
    }

    public static long inputLong(String title){
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextLong();
    }

    public static String  inputString(String title){
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextLine();
    }
}
