package spring4;

import java.util.Scanner;

public class MessengerImpl implements Messenger{

    @Override
    public String getMessage() {
        System.out.println("Input your message");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

