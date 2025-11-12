package org.example;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        User currentUser = new User();
        Scanner userInput = new Scanner(System.in);

        String username;
        String password;
        do {
            System.out.print("Enter username: ");
            username = userInput.nextLine();
            System.out.print("Enter password: ");
            password = userInput.nextLine();
        } while (!currentUser.login(username, password));

    }
}