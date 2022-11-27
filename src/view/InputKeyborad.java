package view;

import java.util.Scanner;

public class InputKeyborad {
    Scanner scanner = new Scanner(System.in);

    public int getValueIntegerKeyboard(){
        return scanner.nextInt();
    }

    public String getStringValueKeyboard(){
        return scanner.next();
    }
}
