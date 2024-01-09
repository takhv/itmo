package Utility;

import java.util.Scanner;

public class Enter {
    private static Scanner scan;

    public static Scanner getScan() {
        return scan;
    }

    public static void setScan(Scanner scan){
        Enter.scan = scan;
    }
}
